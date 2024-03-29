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

/*
 * @deprecated Use ExceptionalException in the models package
 */
@Deprecated(since = "1.3.0")
@SuppressWarnings("serial")
public class ExceptionalException
    extends io.service84.library.exceptionalresult.models.ExceptionalException {
  public ExceptionalException(HttpStatus status, Object response) {
    super(status, response);
  }

  public ExceptionalException(Integer code, Object response) {
    super(code, response);
  }
}
