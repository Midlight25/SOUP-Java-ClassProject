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

		// Create data/ if it doesn't exist already.
		if (new File("data/").mkdir()) {
			System.out.println("Created new data directory.");
		} else {
			System.out.println("data/ already exists.");
		}

		// Create OrderHistory.txt in data/
		try {
			// Path orderHistoryFileName = Paths.get(dataPath.toString(),
			// "OrderHistory.txt");
			File orderHistoryFile = new File("data/OrderHistory.txt");

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
			// Path productsFileName = Paths.get(dataPath.toString(), "Products.txt");
			File productsFile = new File("data/Products.txt");
			if (productsFile.createNewFile()) {
				System.out.println("Created Products.txt");

				FileWriter productWriter = new FileWriter(productsFile);
				productWriter.write("TomatoSoup 5.00 100\n");
				productWriter.write("ChickenSoup 5.00 100\n");
				productWriter.write("VegetableSoup 3.00 100\n");
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
			// Path userInfoFileName = Paths.get(dataPath.toString(), "UserInfo.txt");
			File userInfoFile = new File("data/UserInfo.txt");
			if (userInfoFile.createNewFile()) {
				System.out.println("Created UserInfo.txt");

				FileWriter userInfoWriter = new FileWriter(userInfoFile);
				userInfoWriter.write("darius test Seller\n");
				userInfoWriter.close();
			} else {
				System.out.println("Skipping UserInfo.txt, it already exists");
			}
		} catch (IOException e) {
			System.out.println("An error occurred creating UserInfo.txt.");
			e.printStackTrace();
		}
	}
}
