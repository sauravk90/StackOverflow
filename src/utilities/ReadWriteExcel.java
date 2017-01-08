package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel  {

	File src = new File("C:\\Users\\saurav.kumar\\Desktop\\Dumps\\New folder\\Credentials.xlsx");
	
	public String ReadExcelByColandRow(int rowNum, int colNum) throws IOException{
		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet wsheet = wBook.getSheetAt(0);
		
		XSSFRow row = wsheet.getRow(rowNum);
		XSSFCell cell = row.getCell(colNum);
		
		if(cell.getCellTypeEnum() == CellType.STRING){
			return cell.getStringCellValue();
		}
		else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}
		else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}
		else
			return null;
		
	}
	
	
	
}
