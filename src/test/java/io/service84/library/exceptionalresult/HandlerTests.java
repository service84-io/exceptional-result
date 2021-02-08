package io.service84.library.exceptionalresult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class HandlerTests {
  @TestConfiguration
  public static class Configuration {

    @Bean
    public Handler getHandler() {
      return new Handler();
    }
  }

  // Test Subject
  @Autowired private Handler handler;

  @Test
  public void translatesException() {
    Object response = UUID.randomUUID();
    ExceptionalException exception = new ExceptionalException(HttpStatus.OK.value(), response);
    ResponseEntity<Object> responseWrapper = handler.handleExceptionalResultException(exception);
    assertEquals(HttpStatus.OK, responseWrapper.getStatusCode());
    assertEquals(response, responseWrapper.getBody());
  }
}
