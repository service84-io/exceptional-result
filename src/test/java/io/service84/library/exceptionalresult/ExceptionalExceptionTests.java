/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
