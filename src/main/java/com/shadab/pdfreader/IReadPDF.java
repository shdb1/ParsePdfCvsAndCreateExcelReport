package com.shadab.pdfreader;

import java.io.IOException;
import java.util.List;

import com.shadab.model.JobSeeker;

public interface IReadPDF {

	public List<JobSeeker> readPDFAndParse(String CVsPath) throws IOException ;
	
}
