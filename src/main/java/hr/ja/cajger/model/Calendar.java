package hr.ja.cajger.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calendar extends AbstractAuditable<User, Long> {


    @Column
    String name;

    @Singular
    @OneToMany(mappedBy = "calendar")
    List<Resource> resources;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;
}
