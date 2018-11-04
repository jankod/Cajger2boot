package hr.ja.cajger.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource extends AbstractAuditable<User, Long> {

    @Column
    String eventColor;
    @Column
    String eventBackgroundColor;
    @Column
    String eventBorderColor;
    @Column
    String eventTextColor;
    @Column
    String eventClassName;


    @ManyToOne
    @JoinColumn(name = "calendar_id")
    Calendar calendar;

    @Singular
    @OneToMany(mappedBy = "resources")
    List<Event> events;

}
