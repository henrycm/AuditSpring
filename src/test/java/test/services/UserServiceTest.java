package test.services;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.config.TestConfigApp;

import com.auditing.backend.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		com.auditing.config.PersistenceJPAConfig.class, TestConfigApp.class })
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
}
