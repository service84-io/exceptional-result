package io.service84.library.exceptionalresult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ExceptionalExceptionTests {
  @Test
  public void integerConstructorBad() {
    assertThrows(
        Exception.class,
        () -> {
          new ExceptionalException(-1, UUID.randomUUID());
        });
  }

  @Test
  public void integerConstructorISE() {
    Object response = UUID.randomUUID();
    ExceptionalException exception =
        new ExceptionalException(HttpStatus.INTERNAL_SERVER_ERROR.value(), response);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
    assertEquals(response, exception.getResponse());
  }

  @Test
  public void integerConstructorOK() {
    Object response = UUID.randomUUID();
    ExceptionalException exception = new ExceptionalException(HttpStatus.OK.value(), response);
    assertEquals(HttpStatus.OK, exception.getStatus());
    assertEquals(response, exception.getResponse());
  }

  @Test
  public void statusConstructorISE() {
    Object response = UUID.randomUUID();
    ExceptionalException exception =
        new ExceptionalException(HttpStatus.INTERNAL_SERVER_ERROR, response);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
    assertEquals(response, exception.getResponse());
  }

  @Test
  public void statusConstructorOK() {
    Object response = UUID.randomUUID();
    ExceptionalException exception = new ExceptionalException(HttpStatus.OK, response);
    assertEquals(HttpStatus.OK, exception.getStatus());
    assertEquals(response, exception.getResponse());
  }
}
