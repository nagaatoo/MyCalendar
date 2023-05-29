package ru.numbdev.mycalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.numbDev.openapi.model.UserAuth;
import ru.numbdev.mycalendar.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {MyCalendarApplication.class, SpringSecurityWebAuxTestConfig.class})
//@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.yaml")
@ActiveProfiles(profiles = "test")
public class AuthTest {

    @Autowired
    private UserService userService;

    @Test
    public void auth() {
        var creds = new UserAuth();
        creds.setLogin("ivanov.i");
        creds.setPassword("");
        var token = userService.getToken(creds);
        assert token != null;
    }

}
