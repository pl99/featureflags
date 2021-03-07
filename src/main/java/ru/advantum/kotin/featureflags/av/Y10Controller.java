package ru.advantum.kotin.featureflags.av;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("y10")
public class Y10Controller {
    @GetMapping("route")
    public String calculateRoute(){
        return "Routes for Y10 retail group calculated!";
    }

}
