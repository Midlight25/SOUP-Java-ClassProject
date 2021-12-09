package com.SOUPcorp.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FirstTimeSetup {

	/**
	 * Sets up data files for application in data/ in the same folder as the jar
	 * executable.
	 */
	public static void setup() {
		System.out.println("Initiating First Time Setup");

		Path dataPath = Paths.get(getDataDir());

		// Create data/ if it doesn't exist already.
		try {
			Files.createDirectories(dataPath);
		} catch (IOException e) {
			System.out.println("Unable to create data/ directory.");
			e.printStackTrace();
		}

		// Create OrderHistory.txt in data/
		try {
			Path orderHistoryFileName = Paths.get(dataPath.toString(), "OrderHistory.txt");
			File orderHistoryFile = orderHistoryFileName.toFile();

			if (orderHistoryFile.createNewFile()) {
				System.out.println("Created OrderHistory.txt");
			} else {
				System.out.println("Skipping OrderHistory.txt, it already exists");
			}
		} catch (IOException e) {
			System.out.println("An error occurred creating OrderHistory.txt");
		}

		// Create Products.txt in data/
		try {
			Path productsFileName = Paths.get(dataPath.toString(), "Products.txt");
			File productsFile = productsFileName.toFile();
			if (productsFile.createNewFile()) {
				System.out.println("Created Products.txt");

				FileWriter productWriter = new FileWriter(productsFile);
				productWriter.write("TomatoSoup 5.00 100");
				productWriter.write("ChickenSoup 5.00 100");
				productWriter.write("VegetableSoup 3.00 100");
				productWriter.close();
			} else {
				System.out.println("Skipping Products.txt, it already exists");
			}
		} catch (IOException e) {
			System.out.println("An error occurred creating Products.txt.");
			e.printStackTrace();
		}

		// Create UserInfo.txt in data/
		try {
			Path userInfoFileName = Paths.get(dataPath.toString(), "UserInfo.txt");
			File userInfoFile = userInfoFileName.toFile();
			if (userInfoFile.createNewFile()) {
				System.out.println("Created UserInfo.txt");

				FileWriter userInfoWriter = new FileWriter(userInfoFile);
				userInfoWriter.write("darius test Seller");
				userInfoWriter.close();
			} else {
				System.out.println("Skipping UserInfo.txt, it already exists");
			}
		} catch (IOException e) {
			System.out.println("An error occurred creating UserInfo.txt.");
			e.printStackTrace();
		}
	}

	/**
	 * Gets the path to the Jar executable
	 * 
	 * @return The path to the Jar executable as a string.
	 * @throws URISyntaxException
	 */
	public static String getJarDir() throws URISyntaxException {

		final URL fileURL = App.class.getProtectionDomain().getCodeSource().getLocation();
		String parentDir = "";

		// Attempt to get URI from URL to find folder where executable resides
		final URI fileURI = fileURL.toURI();
		File jarFile = new File(fileURI);
		parentDir = jarFile.getParent();
		return parentDir;
	}

	/**
	 * Gets the path to the data/ folder
	 * 
	 * @return Path to data/ folder as a string.
	 */
	public static String getDataDir() {

		String parentDir = "";

		try {
			parentDir = FirstTimeSetup.getJarDir();
		} catch (URISyntaxException exception) {
			System.err.println("URI Syntax Exception: " + exception.getMessage());
			System.err.println("Path to executable could not be resolved to URI, please move executable " +
					" to a different location and try again.");
			exception.printStackTrace();
		}

		// Create path to data sub-folder and return as string
		Path dataPath = Paths.get(parentDir, "data");
		return dataPath.toString();
	}
}
