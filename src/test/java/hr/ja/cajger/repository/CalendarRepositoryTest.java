package hr.ja.cajger.repository;


import groovy.util.logging.Slf4j;
import hr.ja.cajger.model.Calendar;
import hr.ja.cajger.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CalendarRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CalendarRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CalendarRepositrory calendarRepositrory;

    @Test
    public void testFindAllByUserId() {
        Long userId = null;
        { // given
            Calendar cal1 = new Calendar();

            cal1.setName("cal1");
            User user1 = User.builder().name("pero").build();
            cal1.setOwner(user1);
            entityManager.persist(user1);
            entityManager.persist(cal1);
            entityManager.flush();
            userId = user1.getId();
            log.debug("Got {} ID", userId);
        }
        { // test
            List<Calendar> calendars = calendarRepositrory.findAllByUserId(userId);
            assertThat(calendars).isNotNull().hasSize(1);
            for (Calendar c : calendars) {
                Assert.assertNull(c.getOwner());
            }
        }

    }
}

