package com.epam.lab.utils;

import static com.epam.lab.utils.ConfigProperties.getTestProperty;

public final class Constants {

    private Constants(){}

    public final static String SELENIUM_JAVA = "selenium java";
    public final static String SELENIUM = "selenium";
    public final static String SPRING = "spring";
    public final static String SPRING_JAVA = "spring java";
    public final static String CONFIG_PROPERTIES = "src/main/resources/config.properties";

    /*
    Get data from config.properties
     */

    public static final String PATH_LOG4J = getTestProperty("pathLog4j");
    public static final String LINK_GITHUB = getTestProperty("linkGithub");
    public static final String LINK_GMAIL = getTestProperty("linkGmail");
    public static final String DATA_CSV = getTestProperty("dataCSV");
    public static final String DATA_XLSX = getTestProperty("dataXLSX");

    /*
    DataProviser
     */

    public static final String GIT_PROVIDE = "dataCSV";
    public static final String GMAIL_PROVIDER = "excelData";

}
