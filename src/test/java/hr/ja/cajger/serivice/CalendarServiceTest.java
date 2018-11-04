package hr.ja.cajger.serivice;


import hr.ja.cajger.model.Calendar;
import hr.ja.cajger.model.User;
import hr.ja.cajger.repository.CalendarRepositrory;
import hr.ja.cajger.service.CalendarService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarServiceTest {

    @Autowired()
    CalendarService calendarService;

    @MockBean
    CalendarRepositrory calendarRepositrory;


    @Before
    public void setUp() {
        Mockito.when(calendarRepositrory.findAllByUserId(22L)).thenReturn(createSimpleCalendars());
    }

    private List<Calendar> createSimpleCalendars() {
        List<Calendar> calendars = Lists.newArrayList();

        calendars.add(Calendar.builder().name("cal1").build());

        return calendars;
    }

    @Test
    public void testGetAllCalendarFromUser() {
        List<Calendar> calendars = calendarService.getAllCalendarFromUser(22L);
        assertEquals(1, calendars.size());
    }

    @Test
    public void testG() {
        // calendarService.saveCalendar(new Calendar(""));
    }
}
