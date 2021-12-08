package com.SOUPcorp.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FirstTimeSetup {
	public static void setup() {
		System.out.println("Initiating First Time Setup");

		final URL fileURL = App.class.getProtectionDomain().getCodeSource().getLocation();
		String parentDir = "";

		try {
			// Attempt to get URI from URL to find folder where executable resides
			final URI fileURI = fileURL.toURI();
			File jarFile = new File(fileURI);
			parentDir = jarFile.getParent();
			System.out.println(parentDir);

		} catch (URISyntaxException exception) {
			System.err.println("URI Syntax Exception: " + exception.getMessage());
			System.err.println("Path to executable could not be resolved to URI, please move executable " +
					" to a different location and try again.");
			System.exit(1);
		}

		Path dataPath = Paths.get(parentDir, "data");

		try {
			Files.createDirectories(dataPath);
		} catch (IOException e) {
			System.out.println("Unable to create directory.");
			e.printStackTrace();
		}

		System.out.println(dataPath);

	}
}
