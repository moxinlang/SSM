import javax.annotation.Resource;

import jxl.common.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ruoheng.model.User;
import com.ruoheng.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationcontext.xml")
public class MyTest {
	Logger logger = Logger.getLogger(MyTest.class);
	@Resource
	UserService userService;
	@Test
	public void insertTest(){
		logger.info("insert");
		User user = new User();
		user.setUserName("moxinlang");
		user.setPassword("11111");
		user.setRoleName("系统管理员");
		User u = userService.login(user);
		logger.info("login user="+u);
		
	}
}
