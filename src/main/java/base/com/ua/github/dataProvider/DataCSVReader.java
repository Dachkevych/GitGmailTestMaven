package base.com.ua.github.dataProvider;

import au.com.bytecode.opencsv.CSVReader;
import base.com.ua.github.dto.UserModelGithub;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static base.com.ua.utils.Constants.DATA_CSV;

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
