package demo03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRealmTest {

    private static final transient Logger log = LoggerFactory.getLogger(CustomRealm.class);

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");

        if (!subject.isAuthenticated()) {
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return;
            }
        }

        log.info("登陆成功，认证成功");

        log.info("是否通过认证？{}",subject.isAuthenticated());

        subject.logout();

        log.info("推出后是否还是通过认证？{}",subject.isAuthenticated());
    }
}
