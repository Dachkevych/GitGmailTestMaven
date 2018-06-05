package com.epam.lab.utils;

import static com.epam.lab.utils.ConfigProperties.getTestProperty;

public final class Constants {

    /*
    Tag name for search
     */
    public final static String SELENIUM_JAVA = "selenium java";
    public final static String CUCUMBER_JAVA = "cucumber java";
    public final static String TESTNG_JAVA = "testng java";
    public final static String JUNIT_JAVA = "junit java";
    public final static String SPRING_JAVA = "spring java";
    public final static String SELENIUM = "selenium";
    public final static String CUCUMBER = "cucumber";
    public final static String TESTNG = "testng";
    public final static String JUNIT = "junit";
    public final static String SPRING = "spring";

    /*
    Get data from config.properties
     */
    public final static String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static final String PATH_LOG4J = getTestProperty("pathLog4j");
    public static final String LINK_GITHUB = getTestProperty("linkGithub");
    public static final String LINK_GMAIL = getTestProperty("linkGmail");
    public static final String DATA_CSV = getTestProperty("dataCSV");
    public static final String DATA_XLSX = getTestProperty("dataXLSX");
    public static final String GIT_PROVIDE = "dataCSV";
    public static final int LIST_SIZE = 10;

    /*
    DataProviser
     */
    public static final String GMAIL_PROVIDER = "excelData";
    private Constants() {
    }

}
