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
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.PlexusTestCase;
import org.codehaus.plexus.component.annotations.Requirement;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IBLoggingTest extends PlexusTestCase {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        comp = ( org.apache.maven.plugin.logging.Log) lookup( org.apache.maven.plugin.logging.Log.class);

    }

    @Requirement
    org.apache.maven.plugin.logging.Log comp;

    @Test
    public void testShowOutput() {
        assertNotNull("Got component", comp);
        comp.info("X");
    }

}
