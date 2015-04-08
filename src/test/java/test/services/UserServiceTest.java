package test.services;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auditing.backend.model.User;
import com.auditing.backend.service.UserService;
import com.auditing.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class UserServiceTest {

	private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	@Resource
	private UserService ds;

	@Test
	public void testLoadedData() {
		assertNotNull(
				"User with username: henrycm should be loaded from sql -> ",
				ds.getUser("henrycm"));
	}

	@Test
	public void insert() {
		logger.debug("Inserting user...");
		User u = new User();
		u.setId(10L);
		u.setUsername("TestUser1");
		u.setPassword("Test1User");
		assertNotNull("Inserting user..", ds.save(u));
	}
}
