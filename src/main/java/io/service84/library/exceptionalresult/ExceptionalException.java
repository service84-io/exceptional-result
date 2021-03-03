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
