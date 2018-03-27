package com.pluralsight.security;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
import java.io.Serializable;

public class FitnessPermissionEvaluator implements PermissionEvaluator {

    private DataSource dataSource;

    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        Object[] args = {((User)auth.getPrincipal()).getUsername(),
            targetDomainObject.getClass().getName(),
            permission.toString()};

        int count = template.queryForObject("select count(*) from permissions where username = ? and target = ? " +
                "and permission = ?", args, Integer.class);

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
