package ru.numbdev.mycalendar;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import ru.numbDev.openapi.model.*;
import ru.numbdev.mycalendar.repository.CalendarRepository;
import ru.numbdev.mycalendar.service.CalendarService;
import ru.numbdev.mycalendar.service.OrganizationService;
import ru.numbdev.mycalendar.service.ScheduleService;
import ru.numbdev.mycalendar.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {MyCalendarApplication.class, SpringSecurityWebAuxTestConfig.class})
//@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.yaml")
@ActiveProfiles(profiles = "test")
class MyCalendarApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private ScheduleService scheduleService;

    @Before
    public void setAuthContext() {
        UserDetails userDetails = Mockito.mock(SpringSecurityWebAuxTestConfig.UserImpl.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(userDetails);
    }

    @Test
    void contextLoads() throws JsonProcessingException {
        calendarService.uploadHolidays();

        var owner = saveUser("ivanov.i", "Иванов Иван Иванович");
        assert owner != null;

        var manager = saveUser("petrov.p", "Петров Петр Петрович");
        assert manager != null;

        var customer = saveUser("denisov.d", "Денисов Денис Денисович");
        assert customer != null;

        var organization = saveOrganization(owner.getLogin(), "ООО Ромашка ", "nnagatoo@mai.ru");
        assert organization != null && organization.getId() != null;

        CalendarCreate calendarCreate = new CalendarCreate();
        calendarCreate.setTitle("Календарь ромашки");
        calendarCreate.setOrganizationId(organization.getId());
        var calendar = calendarService.create(calendarCreate);
        assert  calendar != null;
    }

    User saveUser(String login, String fio) {
        User userr = new User();
        userr.setFIO(fio);
        userr.login(login);
        return userService.create(userr);
    }

    @Test
    void buildCalendar() {
        var params = new ScheduleGenerate();
        params.setTitle("Тестовое расписание");
        params.setWorkDays(2);
        params.setUsers(List.of("petrov.p", "denisov.d", "denisov.d", "chepurko.c", "aleksandrov.d"));
        params.setManagers(List.of("vladimirov.d"));
        params.setPeriodOfSchedule("YEAR");
        var schedule = scheduleService.buildScheduleAndSave(1L, params);
        Long id = schedule.getId();
        assert id != null;

        var get = scheduleService.getById(id);
        assert get.getId() != null;

        scheduleService.removeSchedule(id);
        try {
            scheduleService.getById(id);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    Organization saveOrganization(String owner, String name, String email) {
        var organization = new OrganizationCreate();
        organization.setName(name);
        organization.setEmail(email);
        return organizationService.create(owner, organization);
    }

}
