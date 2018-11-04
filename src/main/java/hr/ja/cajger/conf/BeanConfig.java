package hr.ja.cajger.conf;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;

@Configuration
public class BeanConfig {

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////		objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.setDateFormat(new ISO8601DateFormat());
//
//        jsonConverter.setObjectMapper(objectMapper);
//        return jsonConverter;
//    }

    public static void main(String[] args) {
        String p = "2018-11-02T00:00:20";
        LocalDateTime res = LocalDateTime.parse(p);
        System.out.println(res);
    }

//    @ModelAttribute
//    public LocalDateTime initLocalDate() {
//
//        return LocalDateTime.now();
//    }
}
