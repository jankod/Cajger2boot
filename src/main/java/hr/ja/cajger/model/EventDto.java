package hr.ja.cajger.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {


    Long id;

    // ISO8601
    LocalDateTime start;
    LocalDateTime end;

    String title;
    String resourceId;


}
