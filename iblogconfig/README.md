#  Configuring your logging

Depend on

```xml
  <groupId>org.infrastructurebuilder.util</groupId>
  <artifactId>iblogconfig</artifactId>
  <version>${some.version}</version>
  <classifier>test</classifier>
  <scope>test</scope>
```

At deployment time, if your code is headed to a `prod` designated environment, the deployer will inject a dependency on `<classifier>prod</classifier>` of some viable version of the config.

This should also allow you to benefit from automatic addition of a logging framework (including the correct `slf4j-api`).

## How To Generate A New Environment
Don't like the log configs available?  Have a shot at making a different one.

### The Name's The Thing
First, decide the classifier you'll want to use.  This cannot conflict with an existing classifier.  We will hereafter call this value `CLASSIFIER`.

#### Setup Filtering
In the `pom.xml` add a new `execution` to the `maven-resources-plugin` as follows:

```
					<execution>
						<id>CLASSIFIER</id>
						<phase>process-resources</phase>
						<goals>
							<goal>copy-resources</goal>
						</goals>
						<configuration>
							<outputDirectory>${project.build.directory}/CLASSIFIER</outputDirectory>
							<filters>
								<filter>${basedir}/src/filters/prod.properties</filter>
								<filter>${basedir}/src/filters/CLASSIFIER.properties</filter>
							</filters>
						</configuration>
					</execution>
```

#### Setup Artifact Attachment
Also in `pom.xml`, add a new execution to the `maven-jar-plugin`:
```
					<execution>
						<id>CLASSIFIER</id>
						<phase>package</phase>
						<goals>
							<goal>jar</goal>
						</goals>
						<configuration>
							<classesDirectory>${project.build.directory}/CLASSIFIER</classesDirectory>
							<classifier>CLASSIFIER</classifier>
						</configuration>
					</execution>
```


### Overrides
Second, create a `CLASSIFIER.properties` file in `src/filters`, much like `src/filters/test.properties`.
In that file, override the properties from `src/filters/prod.properties` that you'd like overridden.  The existing properties are pretty self-explanatory.

### I Don't Like Your logback.xml

That's a bit harder to deal with.  You can attempt to execute a different resource copy by adding new resources to your `CLASSIFIER`'s filtering execution by
changing the `<resources/>` section.  If you do this, you'll need to filter the resultant fileset yourself.  This might not work and is not suggested.


```
					<execution>
						<id>CLASSIFIER</id>
						<phase>process-resources</phase>
						<goals>
							<goal>copy-resources</goal>
						</goals>
						<configuration>
							<configuration>
								<resources>
									<resource>
										<directory>src/main/some-other-resources</directory>
										<filtering>true</filtering>
									</resource>
								</resources>
							</configuration>
							<outputDirectory>${project.build.directory}/CLASSIFIER</outputDirectory>
							<filters>
								<filter>${basedir}/src/filters/prod.properties</filter><!-- or maybe not include this -->
								<filter>${basedir}/src/filters/CLASSIFIER.properties</filter>
							</filters>
						</configuration>
					</execution>
```


