/**
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

import javax.inject.Named;

import org.apache.maven.plugin.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("logging-maven-component")
public class LoggingMavenComponent implements Log {

  private final static String content(final CharSequence cs) {
    if (cs == null)
      return "";
    return cs.toString();
  }

  private Logger log = LoggerFactory.getLogger(LoggingMavenComponent.class);

  public LoggingMavenComponent() {
  }

  @Override
  public void debug(final CharSequence content) {
    log.debug(content(content));
  }

  @Override
  public void debug(final CharSequence content, final Throwable error) {
    log.debug(content(content), error);
  }

  @Override
  public void debug(final Throwable error) {
    log.debug(content(null), error);
  }

  @Override
  public void error(final CharSequence content) {
    log.error(content(content));
  }

  @Override
  public void error(final CharSequence content, final Throwable error) {
    log.error(content(content), error);

  }

  @Override
  public void error(final Throwable error) {
    log.error(content(null), error);

  }

  @Override
  public void info(final CharSequence content) {
    log.info(content(content));
  }

  @Override
  public void info(final CharSequence content, final Throwable error) {
    log.info(Optional.ofNullable(content).orElse(content(null)).toString(), error);

  }

  @Override
  public void info(final Throwable error) {
    log.info(content(null), error);
  }

  @Override
  public boolean isDebugEnabled() {
    return log.isDebugEnabled();
  }

  @Override
  public boolean isErrorEnabled() {
    return log.isErrorEnabled();
  }

  @Override
  public boolean isInfoEnabled() {
    return log.isInfoEnabled();
  }

  @Override
  public boolean isWarnEnabled() {
    return log.isWarnEnabled();
  }

  public final LoggingMavenComponent setClass(final Class<?> clazz) {
    log = LoggerFactory.getLogger(clazz);
    return this;
  }

  public final LoggingMavenComponent setClass(final String clazz) {
    log = LoggerFactory.getLogger(clazz);
    return this;
  }

  @Override
  public void warn(final CharSequence content) {
    log.warn(content(content));
  }

  @Override
  public void warn(final CharSequence content, final Throwable error) {
    log.warn(content(content), error);
  }

  @Override
  public void warn(final Throwable error) {
    log.warn(content(null), error);
  }

}
