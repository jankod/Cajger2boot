package hr.ja.cajger.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event extends AbstractAuditable<User, Long> {

    @Column
    @Builder.Default()
    String color = "blue";

    @Column
    LocalDateTime start;

    @Column
    LocalDateTime end;

    @Column
    String name;


    @ManyToOne()
    @JoinColumn
    Resource resources;
}
