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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.ContainerConfiguration;
import org.codehaus.plexus.DefaultContainerConfiguration;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusConstants;
import org.codehaus.plexus.classworlds.ClassWorld;
import org.eclipse.sisu.space.SpaceModule;
import org.eclipse.sisu.space.URLClassSpace;
import org.eclipse.sisu.wire.WireModule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMavenComponentTest {

  public final static Logger logger = LoggerFactory.getLogger(LoggingMavenComponentTest.class);
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  Log cLog;
  private ClassWorld kw;
  private ContainerConfiguration dpcreq;
  private DefaultPlexusContainer c;

  @Before
  public void setUp() throws Exception {

    final String realm = "testing";
    kw = new ClassWorld(realm, this.getClass().getClassLoader());

    dpcreq = new DefaultContainerConfiguration().setClassWorld(kw).setClassPathScanning(PlexusConstants.SCANNING_INDEX)
        .setName(realm);
    c = new DefaultPlexusContainer(dpcreq, new WireModule(new SpaceModule(new URLClassSpace(kw.getClassRealm(realm)))));

    cLog = (Log) c.lookup("org.apache.maven.plugin.logging.Log", "logging-maven-component");

  }

  @Test
  public void testCons() {
    LoggingMavenComponent a = new LoggingMavenComponent(logger);
    assertNotNull(a);
  }

  @Test
  public void testComponent() {
    cLog.info("X");
    cLog.info("X", new RuntimeException("X"));
    cLog.info(new RuntimeException("X"));
    cLog.debug("Y");
    cLog.debug("Y", new RuntimeException("X"));
    cLog.debug(new RuntimeException("X"));
    cLog.error("error");
    cLog.error("error", new RuntimeException("X"));
    cLog.error(new RuntimeException("X"));
    cLog.warn("Warning");
    cLog.warn("Warning", new RuntimeException("X"));
    cLog.warn(new RuntimeException("X"));
    assertTrue(cLog.isDebugEnabled());
    assertTrue(cLog.isErrorEnabled());
    assertTrue(cLog.isWarnEnabled());
    assertTrue(cLog.isInfoEnabled());
  }

  @Test
  public void testLoggingMavenComponent() {
    assertNotNull("Got component", cLog);
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
