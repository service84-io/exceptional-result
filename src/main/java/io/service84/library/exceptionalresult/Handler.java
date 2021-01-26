package io.service84.library.exceptionalresult;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Handler {
  @ExceptionHandler(ExceptionalException.class)
  @ResponseBody
  public ResponseEntity<Object> handleExceptionalResultException(
      HttpServletRequest request, ExceptionalException ex) {
    return new ResponseEntity<>(ex.getResponse(), ex.getStatus());
  }
}
