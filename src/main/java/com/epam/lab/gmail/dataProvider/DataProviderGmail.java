package com.epam.lab.gmail.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderGmail {

    @DataProvider(name = "excelData")
    public Object[][] getEXCELData() {
        return DataXLSXReader.getDataFromXLSX().stream().map(i -> new Object[]{i}).toArray(Object[][]::new);
    }
}
