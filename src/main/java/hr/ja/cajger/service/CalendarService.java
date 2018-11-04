package hr.ja.cajger.service;

import hr.ja.cajger.model.Calendar;
import hr.ja.cajger.repository.CalendarRepositrory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CalendarService {


    @Autowired
    private CalendarRepositrory calendarRepositrory;

    //@Transactional(readOnly = true)
    public List<Calendar> getAllCalendarFromUser(Long userId) {
        List<Calendar> cal = calendarRepositrory.findAllByUserId(userId);
        log.debug("User ID has {} calendars", cal.size());
        return cal;
    }

    public void saveCalendar(Calendar calendar) {
        calendarRepositrory.save(calendar);
    }


}
