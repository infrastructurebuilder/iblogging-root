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

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import org.joor.Reflect;
import org.slf4j.helpers.MarkerIgnoringBase;

public class SLF4JFromMavenLogger extends MarkerIgnoringBase {
  private static final long serialVersionUID = 1882197939628480859L;
  private final Logger      proxy;

  public SLF4JFromMavenLogger(final Object o) {

    proxy = Reflect.on(o).as(Logger.class);
  }

  @Override
  public void debug(final String msg) {
    proxy.log(Level.DEBUG, msg);
  }

  @Override
  public void debug(final String format, final Object arg) {
    proxy.log(Level.DEBUG, String.format(format, arg));
  }

  @Override
  public void debug(final String format, final Object... arguments) {
    proxy.log(Level.DEBUG, String.format(format, arguments));
  }

  @Override
  public void debug(final String format, final Object arg1, final Object arg2) {
    proxy.log(Level.DEBUG, String.format(format, arg1, arg2));

  }

  @Override
  public void debug(final String msg, final Throwable t) {
    proxy.log(Level.DEBUG, msg, t);
  }

  @Override
  public void error(final String msg) {
    proxy.log(Logger.Level.ERROR, msg);
  }

  @Override
  public void error(final String format, final Object arg) {
    proxy.log(Logger.Level.ERROR, String.format(format, arg));
  }

  @Override
  public void error(final String format, final Object... arguments) {
    proxy.log(Logger.Level.ERROR, String.format(format, arguments));
  }

  @Override
  public void error(final String format, final Object arg1, final Object arg2) {
    proxy.log(Logger.Level.ERROR, String.format(format, arg1, arg2));

  }

  @Override
  public void error(final String msg, final Throwable t) {
    proxy.log(Logger.Level.ERROR, msg, t);
  }

  @Override
  public void info(final String msg) {
    proxy.log(Logger.Level.INFO, msg);
  }

  @Override
  public void info(final String format, final Object arg) {
    proxy.log(Logger.Level.INFO, String.format(format, arg));
  }

  @Override
  public void info(final String format, final Object... arguments) {
    proxy.log(Logger.Level.INFO, String.format(format, arguments));
  }

  @Override
  public void info(final String format, final Object arg1, final Object arg2) {
    proxy.log(Logger.Level.INFO, String.format(format, arg1, arg2));

  }

  @Override
  public void info(final String msg, final Throwable t) {
    proxy.log(Logger.Level.INFO, msg, t);
  }

  @Override
  public boolean isDebugEnabled() {
    return proxy.isLoggable(Level.DEBUG);
  }

  @Override
  public boolean isErrorEnabled() {
    return proxy.isLoggable(Level.ERROR);
  }

  @Override
  public boolean isInfoEnabled() {
    return proxy.isLoggable(Level.INFO);
  }

  @Override
  public boolean isTraceEnabled() {
    return false;
  }

  @Override
  public boolean isWarnEnabled() {
    return proxy.isLoggable(Level.WARNING);
  }

  @Override
  public void trace(final String msg) {
  }

  @Override
  public void trace(final String format, final Object arg) {
  }

  @Override
  public void trace(final String format, final Object... arguments) {
  }

  @Override
  public void trace(final String format, final Object arg1, final Object arg2) {
  }

  @Override
  public void trace(final String msg, final Throwable t) {
  }

  @Override
  public void warn(final String msg) {
    proxy.log(Logger.Level.WARNING, msg);
  }

  @Override
  public void warn(final String format, final Object arg) {
    proxy.log(Logger.Level.WARNING, String.format(format, arg));
  }

  @Override
  public void warn(final String format, final Object... arguments) {
    proxy.log(Logger.Level.WARNING, String.format(format, arguments));
  }

  @Override
  public void warn(final String format, final Object arg1, final Object arg2) {
    proxy.log(Logger.Level.WARNING, String.format(format, arg1, arg2));

  }

  @Override
  public void warn(final String msg, final Throwable t) {
    proxy.log(Logger.Level.WARNING, msg, t);
  }
}
