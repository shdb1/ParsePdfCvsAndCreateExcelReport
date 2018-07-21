package com.shadab.excelgenerate;

import java.io.IOException;
import java.util.List;

import com.shadab.model.JobSeeker;

public interface IExcelGenerator {
	
	public void generateExcelSheet(List<JobSeeker> jobSeekers , String outputDirectory, String outputFileName) throws IOException;

}
