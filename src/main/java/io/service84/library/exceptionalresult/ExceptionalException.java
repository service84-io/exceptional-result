package io.service84.library.exceptionalresult;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ExceptionalException extends RuntimeException {
  private Object response;
  private HttpStatus status;

  public ExceptionalException(HttpStatus status, Object response) {
    super("Exceptional Result Exception");
    this.status = status;
    this.response = response;
  }

  public ExceptionalException(Integer code, Object response) {
    super("Exceptional Result Exception");
    this.status = HttpStatus.valueOf(code);
    this.response = response;
  }

  public Object getResponse() {
    return response;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
