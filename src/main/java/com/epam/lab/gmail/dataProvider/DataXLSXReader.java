package com.epam.lab.gmail.dataProvider;

import com.epam.lab.gmail.dataobject.UserModelGmail;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class DataXLSXReader {

    public static List<UserModelGmail> getDataFromXLSX(File file) {

        List<UserModelGmail> gmailDataList = new ArrayList<>();
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(file));

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                UserModelGmail gmailData = new UserModelGmail();
                Row row = rows.next();
                //Sometimes Excel return deleted rows with blank cells
                if (Objects.nonNull(row.getCell(1))) {
                    gmailData.setLogin(row.getCell(0).getStringCellValue());
                    gmailData.setPassword(row.getCell(1).getStringCellValue());
                    gmailData.setReceiver(row.getCell(2).getStringCellValue());
                    gmailData.setSubject(row.getCell(3).getStringCellValue());
                    gmailData.setText(row.getCell(4).getStringCellValue());
                    gmailDataList.add(gmailData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gmailDataList;
    }
}
