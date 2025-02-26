package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class LoggingAspectTest {

    @InjectMocks
    private LoggingAspect loggingAspect;

    @Test
    void whenLoggingSuccess(CapturedOutput output) {
        // given


        // when


        // then

    }
}
