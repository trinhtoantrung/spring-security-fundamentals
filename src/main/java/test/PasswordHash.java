package test;

import junit.framework.TestCase;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testMD5Hash() {
        String password = "secret";
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String passwordEncode = md5PasswordEncoder.encodePassword(password, null);
        System.out.println(passwordEncode);
    }

    public void testBcryptHash() {
        String password = "secret";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = bCryptPasswordEncoder.encode(password);
        System.out.println(passwordEncode);
    }
}