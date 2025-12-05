package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {
    private static final String excel_data_path = "";

    public static String getExcelData(String excelFileName, String sheetName, int rowNum, int colNum) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String cellData;
        try {
            workBook = new XSSFWorkbook(excel_data_path + excelFileName);
            sheet = workBook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            return cellData;

        } catch (IOException e) {
            System.out.println("Error reading excel file" + e.getMessage());
            return "";
        }
    }
}
