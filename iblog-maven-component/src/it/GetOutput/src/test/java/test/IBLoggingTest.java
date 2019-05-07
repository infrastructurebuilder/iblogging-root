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
        comp = ( ShowOutput) lookup( ShowOutput.class);

    }

    @Requirement
    ShowOutput comp;

    @Test
    public void testShowOutput() {
        assertNotNull("Got component", comp);
        comp.doIt();
    }

}
