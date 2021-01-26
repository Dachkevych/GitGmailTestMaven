package base.com.ua.utils;

import static base.com.ua.utils.ConfigProperties.getTestProperty;

public final class Constants {

  /*
  Tag name for search
   */
  public static final String SELENIUM_JAVA = "selenium java";
  public static final String CUCUMBER_JAVA = "cucumber java";
  public static final String TESTNG_JAVA = "testng java";
  public static final String JUNIT_JAVA = "junit java";
  public static final String SPRING_JAVA = "spring java";
  public static final String SELENIUM = "selenium";
  public static final String CUCUMBER = "cucumber";
  public static final String TESTNG = "testng";
  public static final String JUNIT = "junit";
  public static final String SPRING = "spring";

  /*
  Get data from config.properties
   */
  public static final String CONFIG_PROPERTIES = "src/main/resources/config.properties";
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

  private Constants() {}
}
