package com.epam.lab.gmail.dataProvider;

import com.epam.lab.gmail.dataobject.UserModelGmail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.epam.lab.utils.Constants.DATA_XLSX;

public final class DataXLSXReader {

    public static List<UserModelGmail> getDataFromXLSX() {

        List<UserModelGmail> users = new ArrayList<>();
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File(DATA_XLSX));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                UserModelGmail user = new UserModelGmail();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            user.setLogin(nextCell.getStringCellValue());
                            break;
                        case 1:
                            user.setPassword(nextCell.getStringCellValue());
                            break;
                        case 2:
                            user.setReceiver(nextCell.getStringCellValue());
                            break;
                        case 3:
                            user.setSubject(nextCell.getStringCellValue());
                            break;
                        case 4:
                            user.setText(nextCell.getStringCellValue());
                            break;
                    }
                }
                users.add(user);
            }
            inputStream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return users;
    }
}
