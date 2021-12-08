package com.SOUPcorp.app;

import java.io.File;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;

public class FirstTimeSetup {
	public static void setup() {
		System.out.println("Initiating First Time Setup");

		final URL fileURL = App.class.getProtectionDomain().getCodeSource().getLocation();

		try {
			// Attempt to get URI from URL to find folder where executable resides
			final URI fileURI = fileURL.toURI();
			File jarFile = new File(fileURI);
			String parentDir = jarFile.getParent();

		} catch (URISyntaxException exception) {
			System.err.println("URI Syntax Exception: " + exception.getMessage());
			System.exit(1);
		}

	}
}
