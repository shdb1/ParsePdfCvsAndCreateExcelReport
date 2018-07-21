package com.shadab.init;

import java.io.IOException;
import java.util.List;

import com.shadab.excelgenerate.ExcelGenerator;
import com.shadab.model.JobSeeker;
import com.shadab.pdfreader.ReadPDF;

public class InitProcess {
	public static void main(String[] args) {
		ReadPDF readPDF = new ReadPDF();
		ExcelGenerator ex = new ExcelGenerator();
		try {
			List<JobSeeker> jobSeekers= readPDF.readPDFAndParse("C:\\\\Users\\\\mshadab\\\\Downloads\\\\CVs"); 
			ex.generateExcelSheet(jobSeekers, "C:\\\\\\\\Users\\\\\\\\mshadab\\\\\\\\Downloads\\\\\\\\CVs\\\\\\\\", "ReceivedProfiles");
 		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}

}
