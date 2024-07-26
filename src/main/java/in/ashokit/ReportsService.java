package in.ashokit;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportsService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	//HttpServletResponse is part of the Java Servlet API and is used in web applications to represent the response that a server sends back to a client. 
	
	public void generateExcel(HttpServletResponse response) throws Exception{
		
		List<Course> courses = courseRepo.findAll();
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		HSSFSheet sheet = workBook.createSheet("Course Info");
		
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("HallTicket");
		
		int dataRowIndex = 1;
		
		for(Course course : courses) {
			
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			
			dataRow.createCell(0).setCellValue(course.getCid());
			dataRow.createCell(1).setCellValue(course.getName());
			dataRow.createCell(2).setCellValue(course.getHTNo());
			dataRowIndex++;
			
		}
			
		try(ServletOutputStream ops = response.getOutputStream()){
			workBook.write(ops);
		}finally {
			workBook.close();
		}
		
	}
}

