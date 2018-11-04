package hr.ja.cajger.repository;

import hr.ja.cajger.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepositrory extends JpaRepository<Calendar, Long> {

    @Query("from Calendar c where c.owner.id = ?1")
    List<Calendar> findAllByUserId(Long userId);
}
