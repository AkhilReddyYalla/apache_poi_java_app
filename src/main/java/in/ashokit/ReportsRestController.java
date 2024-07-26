package in.ashokit;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportsRestController {
	
	@Autowired
	private ReportsService reportsService;
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachmenet;filename=courses.xls";
		
		response.setHeader(headerKey, headerValue);
		
		reportsService.generateExcel(response);
		
		response.flushBuffer();
		
		
	}

}
