/*
 * @formatter:off
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
 * @formatter:on
 */
package org.infrastructurebuilder.util.logging;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.ContainerConfiguration;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.classworlds.ClassWorld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMavenComponentTest {

  public final static Logger logger = LoggerFactory.getLogger(LoggingMavenComponentTest.class);

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
  }

  Log cLog;
  Log dLog;
  private ClassWorld kw;
  private ContainerConfiguration dpcreq;
  private DefaultPlexusContainer c;

  @BeforeEach
  public void setUp() throws Exception {

//    final String realm = "testing";
//    kw = new ClassWorld(realm, this.getClass().getClassLoader());
//
//    dpcreq = new DefaultContainerConfiguration().setClassWorld(kw).setClassPathScanning(PlexusConstants.SCANNING_INDEX)
//        .setName(realm);
//    c = new DefaultPlexusContainer(dpcreq, new WireModule(new SpaceModule(new URLClassSpace(kw.getClassRealm(realm)))));
//
//    cLog = (Log) c.lookup(Log.class.getCanonicalName().toString(), LOGGING_MAVEN_COMPONENT);

    cLog = new LoggingMavenComponent();
    dLog = new LoggingMavenComponent(LoggerFactory.getLogger("TESTME!"));
  }

  @Test
  public void testCons() {
    LoggingMavenComponent a = new LoggingMavenComponent();
    assertNotNull(a);
  }

  @Test
  public void testComponent() {
    cLog.info("X");
    RuntimeException k = new RuntimeException("X");
    cLog.info("X", k);
    cLog.info(k);
    cLog.debug("Y");
    cLog.debug("Y", k);
    cLog.debug(k);
    cLog.error("error");
    cLog.error("error", k);
    cLog.error(k);
    cLog.warn("Warning");
    cLog.warn("Warning", k);
    cLog.warn(k);
    assertTrue(cLog.isDebugEnabled());
    assertTrue(cLog.isErrorEnabled());
    assertTrue(cLog.isWarnEnabled());
    assertTrue(cLog.isInfoEnabled());
  }

  @Test
  public void testLoggingMavenComponent() {
    assertNotNull(cLog, "Got component");
  }

  @Test
  public void testLoggingMavenComponentWothLog() {
    assertNotNull(dLog, "Got component");
  }

  @Test
  public void testSetClassClassOfQ() {
    ((LoggingMavenComponent) cLog).setClass(this.getClass());
  }

  @Test
  public void testSetClassString() {
    ((LoggingMavenComponent) cLog).setClass(this.getClass().getCanonicalName());
  }

}
