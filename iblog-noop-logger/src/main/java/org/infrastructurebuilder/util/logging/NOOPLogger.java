/*
 * Copyright © 2019 admin (admin@infrastructurebuilder.org)
 *
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
/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.infrastructurebuilder.util.logging;

import java.util.ResourceBundle;

public class NOOPLogger implements System.Logger {
  public NOOPLogger() {
    System.err.println("NOOP Logger Created");
  }

  @Override
  public String getName() {
    return getClass().getName();
  }

  @Override
  public boolean isLoggable(Level arg0) {
    return false;
  }

  @Override
  public void log(Level arg0, ResourceBundle arg1, String arg2, Throwable arg3) {
  }

  @Override
  public void log(Level arg0, ResourceBundle arg1, String arg2, Object... arg3) {
  }
}
