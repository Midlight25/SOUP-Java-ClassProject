# SOUP-Java-ClassProject

[![CodeQL](https://github.com/Midlight25/SOUP-Java-ClassProject/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)](https://github.com/Midlight25/SOUP-Java-ClassProject/actions/workflows/codeql-analysis.yml)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

A class project for Object Oriented Design, by designing a desktop application for SOUP, an online retailer for Soup Cans.

## Authors

- Michael Mesquita (Midlight25)
- Darius Hassan (dhassan)
- Jordan Burgher

## Description

This is a simulated desktop app for a storefront called "SOUP." It sells cans of soup, (go figure.) This project is written in Java 11 but is packaged for release for 1.8 to maintain interoperability with Oracle's public JRE version. This project is built using Maven, the associated commands for compiling, testing, and generating documentation are below.

## Commands

- `mvn compile` - Compile java files to .class files.
- `mvn package` - Compile java files to .jar executable.
- `mvn test` - Run JUnit4 tests.
- `mvn site` - Compile Maven Project Details and Javadoc to project website in target/site folder.
- `java -cp target/classes com.SOUPcorp.app.App` - run class files from compilation step.
- `java -jar target/SOUP-Java-ClassProject-1.0.jar` - run the jar executable from the packaging step.
