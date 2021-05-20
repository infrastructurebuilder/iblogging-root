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

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.plugin.logging.Log;


import java.lang.System;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

@Named("logging-maven-component")
public class LoggingMavenComponent implements Log {

  private final static String content(final CharSequence cs) {
    if (cs == null)
      return "";
    return cs.toString();
  }

  private Logger log = System.getLogger(LoggingMavenComponent.class.getName());

  @Inject
  public LoggingMavenComponent() {
  }

  public LoggingMavenComponent(Logger log) {
    this();
    this.setLog(log);
  }

  // Check type then cast to LoggingMavenComponent then setLog
  public void setLog(Logger log) {
    this.log = log;
  }

  @Override
  public void debug(final CharSequence content) {
    log.log(Level.DEBUG,content(content));
  }

  @Override
  public void debug(final CharSequence content, final Throwable error) {
    log.log(Level.DEBUG,content(content), error);
  }

  @Override
  public void debug(final Throwable error) {
    log.log(Level.DEBUG,content(null), error);
  }

  @Override
  public void error(final CharSequence content) {
    log.log(Logger.Level.ERROR, content(content));
  }

  @Override
  public void error(final CharSequence content, final Throwable error) {
    log.log(Logger.Level.ERROR, content(content), error);

  }

  @Override
  public void error(final Throwable error) {
    log.log(Logger.Level.ERROR, content(null), error);

  }

  @Override
  public void info(final CharSequence content) {
    log.log(Logger.Level.INFO, content(content));
  }

  @Override
  public void info(final CharSequence content, final Throwable error) {
    log.log(Logger.Level.INFO, Optional.ofNullable(content).orElse(content(null)).toString(), error);

  }

  @Override
  public void info(final Throwable error) {
    log.log(Logger.Level.INFO, content(null), error);
  }

  @Override
  public boolean isDebugEnabled() {
    return log.isLoggable(Level.DEBUG);
  }

  @Override
  public boolean isErrorEnabled() {
    return log.isLoggable(Level.ERROR);
  }

  @Override
  public boolean isInfoEnabled() {
    return log.isLoggable(Level.INFO);
  }

  @Override
  public boolean isWarnEnabled() {
    return log.isLoggable(Level.WARNING);
  }

  public final LoggingMavenComponent setClass(final Class<?> clazz) {
    log = System.getLogger(clazz.getName());
    return this;
  }

  public final LoggingMavenComponent setClass(final String clazz) {
    log = System.getLogger(clazz);
    return this;
  }

  @Override
  public void warn(final CharSequence content) {
    log.log(Logger.Level.WARNING, content(content));
  }

  @Override
  public void warn(final CharSequence content, final Throwable error) {
    log.log(Logger.Level.WARNING, content(content), error);
  }

  @Override
  public void warn(final Throwable error) {
    log.log(Logger.Level.WARNING, content(null), error);
  }

}
