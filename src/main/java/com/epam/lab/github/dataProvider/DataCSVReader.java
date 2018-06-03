package com.epam.lab.github.dataProvider;

import au.com.bytecode.opencsv.CSVReader;
import com.epam.lab.github.dataobject.UserModelGithub;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.lab.utils.Constants.DATA_CSV;

public final class DataCSVReader {

    public static List<UserModelGithub> getUsersFromCSV() throws IOException {
        List<UserModelGithub> userModelList = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(DATA_CSV), ',');
        String[] line = null;

        while ((line = reader.readNext()) != null) {
            UserModelGithub user = new UserModelGithub(line[0], line[1]);
            userModelList.add(user);
        }
        return userModelList;
    }
}
