import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Bank;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grinder {
    public static void main(String[] args) throws IOException {
        for(int i=1;i<=10;i++) {
            List<Bank> list = makeListFromExcel(args[0], String.valueOf(i));
            makeJsonFiles(list);
        }
    }

    private static List makeListFromExcel(String excelPath, String sheetNum) {
        List<Bank> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(excelPath);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(Integer.parseInt(sheetNum));

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Bank bank = new Bank();

                int seq = 0;

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                        if (seq == 0) {
                            bank.setBankName(cell.getStringCellValue());
                            seq++;
                        } else if (seq == 1) {
                            bank.setApiCode(cell.getStringCellValue());
                            seq++;
                        } else if (seq == 2) {
                            bank.setBankSeq(cell.getStringCellValue());
                            seq++;
                        } else if (seq == 3) {
                            bank.setResponse(cell.getStringCellValue());
                        } else System.out.println("Error occurred while reading excel row");
                    }

                }
                list.add(bank);
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void makeJsonFiles(List<Bank> list) throws IOException {
        System.out.println("===== started json file creation =====");
        for (Bank bank : list) {
            // Naming file
            System.out.println("stored content \t" + bank.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("테스트");
            sb.append("-");
            sb.append(bank.getBankName());
            sb.append(bank.getBankSeq());
            sb.append("-");
            sb.append("은행");
            sb.append(bank.getApiCode());
            sb.append(".json");

            // Write file using gson
            try (Writer writer = new FileWriter(sb.toString())) {
                Gson gson = new GsonBuilder()
                        .disableHtmlEscaping()
                        .setPrettyPrinting()
                        .create();

                String response = bank.getResponse().replaceAll("\\\\", "'");
                response = response.replaceAll("\n", "");
                response = response.replaceAll("\" \\{", "{");
                gson.toJson(response, writer);
            }

        }

        System.out.println("===== finished json creation successfully =====");
    }
}
