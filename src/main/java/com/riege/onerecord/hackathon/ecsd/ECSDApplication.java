package com.riege.onerecord.hackathon.ecsd;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;

@SpringBootApplication
@RestController
public class ECSDApplication extends WicketBootStandardWebApplication {

	@Autowired
	Environment environment;

	@Override
	protected void init() {
		super.init();
		Logger logger = LoggerFactory.getLogger(this.getClass());
		// following is made with figlet
		// just do brew install figlet :)
		logger.info("  ___  _   _       ____ ____  ____   ");
		logger.info(" / _ \\| \\ | | ___ / ___/ ___||  _ \\  ");
		logger.info("| | | |  \\| |/ _ \\ |   \\___ \\| | | | ");
		logger.info("| |_| | |\\  |  __/ |___ ___) | |_| | ");
		logger.info(" \\___/|_| \\_|\\___|\\____|____/|____/  ");
		logger.info("ONeCSD initialized.");
		logger.info("ONeCSD Version: " + getVersion());
		logger.info("ONeCSD Log level"
			+ ": INFO:"  + (logger.isInfoEnabled()  ? " ON" : "OFF")
			+ ", TRACE:" + (logger.isTraceEnabled() ? " ON" : "OFF")
			+ ", DEBUG:" + (logger.isDebugEnabled() ? " ON" : "OFF")
			+ ", WARN:"  + (logger.isWarnEnabled()  ? " ON" : "OFF")
			+ ", ERROR:" + (logger.isErrorEnabled() ? " ON" : "OFF")
			+ ", Logger class: " + logger.getClass().getName()
		);
	}

	public static ECSDApplication getWebApplication() {
		return (ECSDApplication) get();
	}

	/*
	 * Starting with different Spring profiles
	 * by setting environment variable
	 *
	 *   spring.profiles.active=development
	 *
	 * e.g. in IntelliJ run configuration
	 *
	 * "development" is 'the' wicket-spring-boot profile
	 * for development, it also activates development mode
	 * inside Wicket, see
	 * https://github.com/MarcGiffing/wicket-spring-boot#spring-profile-configuration
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * To run the application in development mode,
		 * it is recommneded to run BootRunApplication instead
		 */
		ConfigurableApplicationContext ctx =
				SpringApplication.run(ECSDApplication.class, args);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new ECSDSession(request);
	}

	/*
	 * @return version from bootJar MANIFEST Implementation-Version or NULL
	 */
	public static String getVersion() {
		/*
		 * Maybe available if started from a JAR/WAR file.
		 * Must be set in build.gradle via
		 * tasks.withType(Jar) { manifest { attributes( 'Implementation-Version'    : ..
		 */
		String version = ECSDApplication.class.getPackage().getImplementationVersion();

		/*
		 * If JAR/WAR got unpacked, then try to read from META-INF/MANIFEST.MF:
		 */
		if (version == null || version.isEmpty()) {
			try {
				InputStream inputStream = getWebApplication().getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF");
				if (inputStream != null) {
					Manifest manifest = new Manifest(inputStream);
					version = manifest.getMainAttributes()
						.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
				}
			} catch (IOException e) {
				// we can't do anything better, maybe it's "dev" then
				version = "dev";
			}
		}
		if (version == null || version.isEmpty()) {
			version = "dev";
		}
		return version;
	}

}
