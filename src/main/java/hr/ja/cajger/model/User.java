package hr.ja.cajger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder()
@AllArgsConstructor()
@NoArgsConstructor
public class User extends AbstractPersistable<Long> {

    @Column
    String name;

    @Column
    String email;

    @JsonIgnore
    @Column
    String password;

    @OneToMany(mappedBy = "owner")
    @Singular
    List<Calendar> calendars;


}
