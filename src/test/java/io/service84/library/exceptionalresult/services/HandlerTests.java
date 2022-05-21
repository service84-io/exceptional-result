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

package io.service84.library.exceptionalresult.services;

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

import io.service84.library.exceptionalresult.models.ExceptionalException;

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

  @SuppressWarnings("deprecation")
  @Test
  public void translatesLegacyException() {
    Object response = UUID.randomUUID();
    io.service84.library.exceptionalresult.ExceptionalException exception =
        new io.service84.library.exceptionalresult.ExceptionalException(
            HttpStatus.OK.value(), response);
    ResponseEntity<Object> responseWrapper = handler.handleExceptionalResultException(exception);
    assertEquals(HttpStatus.OK, responseWrapper.getStatusCode());
    assertEquals(response, responseWrapper.getBody());
  }

  @Test
  public void translatesException() {
    Object response = UUID.randomUUID();
    ExceptionalException exception = new ExceptionalException(HttpStatus.OK.value(), response);
    ResponseEntity<Object> responseWrapper = handler.handleExceptionalResultException(exception);
    assertEquals(HttpStatus.OK, responseWrapper.getStatusCode());
    assertEquals(response, responseWrapper.getBody());
  }
}
