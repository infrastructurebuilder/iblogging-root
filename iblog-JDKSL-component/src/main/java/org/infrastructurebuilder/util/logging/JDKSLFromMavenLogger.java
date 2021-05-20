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
package org.infrastructurebuilder.util.logging;

import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import org.joor.Reflect;

public class JDKSLFromMavenLogger implements System.Logger {
  private final String name;
  private final int    plThreshold;
  // This is a org.codehaus.plexus.logging.Logger
  private final Object v;

  public JDKSLFromMavenLogger(final Object o) {
    Object v1 = null;
    String n1 = null;
    int    t1 = 5;
    // A Maven Log has a field called "logger" that is an internal plexus logger
    try {
      v1 = Reflect.on(o).field("logger").get();
      n1 = Reflect.on(v1).call("getName").get();
      t1 = Reflect.on(v1).call("getThreshold").get();

    } catch (Throwable t) {
      System.err.println("No viable logger in field 'logger'");
    }
    this.v = v1;
    this.name = n1;
    this.plThreshold = t1;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean isLoggable(Level level) {
    switch (Objects.requireNonNull(level)) {
    case DEBUG:
    case TRACE:
      return plThreshold < 1;
    case ERROR:
      return plThreshold < 5;
    case INFO:
      return plThreshold < 2;
    case ALL:
    case WARNING:
      return plThreshold < 3;
    default:
      return false;

    }
  }

  @Override
  public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
    if (isLoggable(level))
      localLog(level, rb(bundle, msg), thrown);
  }

  private String rb(ResourceBundle bundle, String format, Object... params) {
    return Optional.ofNullable(bundle).map(b -> String.format(b.getString(format), params))
        .orElse(String.format(format, params));
  }

  @Override
  public void log(Level level, ResourceBundle bundle, String format, Object... params) {
    if (isLoggable(level))
      localLog(level, rb(bundle, format, params), null);
  }

  private void localLog(Level level, String rb, Throwable t) {
    if (plThreshold != 5) { // As of 2021-04-8, 5 means DISABLED
      final String x;
      switch (level) {
      case ALL:
      case DEBUG:
        x = "debug";
        break;
      case ERROR:
        x = "error";
        break;
      case INFO:
        x = "info";
        break;
      case TRACE:
        x = "debug";
        break;
      case WARNING:
        x = "warn";
        break;
      case OFF:
      default:
        x = null;
        break;
      }
      if (x != null) {
        Reflect r = Reflect.on(v);
        if (t != null) {
          r.call(x, rb, t);
        } else {
          r.call(x, rb);
        }
      }
    }
  }
}
