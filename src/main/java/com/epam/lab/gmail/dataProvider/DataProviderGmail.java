package com.epam.lab.gmail.dataProvider;

import com.epam.lab.utils.ConfigProperties;
import org.testng.annotations.DataProvider;

import java.io.File;

public class DataProviderGmail {

    @DataProvider(parallel = true)
    public Object[] getData() {
        return DataXLSXReader.getDataFromXLSX(new File(ConfigProperties.getTestProperty("dataXLSX"))).toArray();
    }
}
