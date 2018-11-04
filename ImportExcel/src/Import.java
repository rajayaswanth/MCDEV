import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Import {
	
	public static void readFromExcel(String file) throws IOException
	{
		System.out.println(file);
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet myExcelSheet = myExcelBook.getSheet("medicine");
		XSSFRow row = myExcelSheet.getRow(0);
		System.out.println(row);
		myExcelBook.close(); 
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readFromExcel("/home/basanta/SSSAMC/MCDEV/ImportExcel/Medicine Database.xlsx");
	}

}
