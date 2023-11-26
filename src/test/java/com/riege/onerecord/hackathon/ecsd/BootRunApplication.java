package com.riege.onerecord.hackathon.ecsd;

import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.Base64;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude={EmbeddedMongoAutoConfiguration.class})
@RestController
public class BootRunApplication {

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
		// create Cache for Fonts, this might take a while
		// but saves easily 2 seconds later when we use the font
		Logger logger = LoggerFactory.getLogger(ECSDApplication.class);

		logger.info("PDFFontCacheInitialization thread creation");
		new Thread("PDFFontCacheInitialization") {
			@Override
			public void run() {
				logger.info("PDFFontCacheInitialization running");
				new PDType1Font(Standard14Fonts.FontName.HELVETICA);
				logger.info("PDFFontCacheInitialization finished");
			}
		}.start();
		logger.info("PDFFontCacheInitialization started");

		// Important: get the desktop prior start the SpringApplication
		// because the SpringApplication sets the system to be headless

		Desktop desktop = GraphicsEnvironment.isHeadless() ? null : Desktop.getDesktop();
		/*
		 * 2 ways to run it:
		 *
		 * (1) SpringApplication.run(ECSDApplication.class, args);
		 * (2) new SpringApplicationBuilder()
		   			.sources(ECSDApplication.class)
					.run(args);
		 */
		ConfigurableApplicationContext ctx =
			SpringApplication.run(ECSDApplication.class, args);

		if (desktop != null) {
			String embeddedServerPort = ctx.getEnvironment().getProperty("server.port");
			String url = "http://localhost:" + embeddedServerPort;
			// use RestClient to get data from 1R server and set the formfields:
			String parameter =
				"w=157-11111111"
					+ "&o=ORG"
					+ "&d=DST"
					+ "&p=DE%2FRA%2F123456-001"
					// + "&n=Aircraft%20engine%20spare%20parts%0dSecond%20Line"
					+ "&n=Aircraft%20engine%20spare%20parts"
					+ "&s=SCO"
					+ "&m=XRY";
			parameter =
				"w=020-55474661"
					+ "&o=DUS"
					+ "&d=ATL"
					+ "&p=DE%2FRA%2F123456-001"
					// + "&n=Aircraft%20engine%20spare%20parts%0dSecond%20Line"
					+ "&n=Consolidation%20as%20per%0dattached%20list"
					+ "&s=SCO"
					+ "&m=XRY";
			// url = url + "?" + parameter;
			url = url + "?id="
					+ Base64.getEncoder().encodeToString(parameter
							.replaceAll("%2F", "/")
							.replaceAll("%20", " ")
							.replaceAll("%0a", "\n")	// LF
							.replaceAll("%0d", "\r")	// CR
							.getBytes()
						);
			System.err.println("URL=" + url);
			desktop.browse(URI.create(url));
		}
	}

}
