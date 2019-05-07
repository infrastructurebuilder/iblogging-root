package test;

import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

@Component(instantiationStrategy = "per-lookup", role = ShowOutput.class, hint = "injectTest", description = "SLF4j-backed Maven Log")
public class ShowOutput {

    @Requirement
    Log log;

    public ShowOutput() {
    }

    public void doIt() {
        log.error("ERROR.  OH NOES");
    }

}
