package hr.ja.cajger.conf;

import hr.ja.cajger.model.Calendar;
import hr.ja.cajger.model.Event;
import hr.ja.cajger.model.Resource;
import hr.ja.cajger.model.User;
import hr.ja.cajger.repository.CalendarRepositrory;
import hr.ja.cajger.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Configuration
@Slf4j
class LoadDatabase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CalendarRepositrory calendarRepositrory;

    @Profile("dev")
    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("init development database");
            User user1 = User.builder().name("pero").password("pero")
                    .email("pero@gmail.com").build();


            LocalDateTime now = LocalDateTime.now().withHour(10);
            Event event1 = Event.builder().start(now)
                    .end(now.plusHours(2))
                    .color("red")
                    .name("Event 1")
                    .build();

            Resource resourceRoom1 = Resource.builder()
                    .event(event1)
                    .build();

            Calendar cal1 = Calendar.builder()
                    .name("calendar 1")
                    .resource(resourceRoom1)
                    .build();
            resourceRoom1.setCalendar(cal1);
            event1.setResources(resourceRoom1);

            calendarRepositrory.saveAndFlush(cal1);
            userRepository.save(user1);
        };
    }
}