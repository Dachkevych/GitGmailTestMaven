package com.epam.lab.github.dataProvider;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderGithub {

    @DataProvider(name = "dataCSV")
    public Object[][] getCSVData() throws IOException {
        return DataCSVReader.getUsersFromCSV().stream().map(i -> new Object[]{i}).toArray(Object[][]::new);
    }
}