package com.shadab.pdfreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JoinRowSet;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.shadab.model.JobSeeker;

public class ReadPDF implements IReadPDF {

	public List<JobSeeker> readPDFAndParse(String CVsPath) throws IOException {
		// TODO Auto-generated method stub

		File cvsFolder = new File(CVsPath);
		ArrayList<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();
		if (cvsFolder.exists() && cvsFolder.isDirectory()) {
			File[] cvsList = cvsFolder.listFiles();
			for (File file : cvsList) {

				try (PDDocument document = PDDocument.load(file)) {

					document.getClass();

					if (!document.isEncrypted()) {

						PDFTextStripperByArea stripper = new PDFTextStripperByArea();
						stripper.setSortByPosition(true);

						PDFTextStripper tStripper = new PDFTextStripper();

						String pdfFileInText = tStripper.getText(document);
						// System.out.println("Text:" + st);

						// split by whitespace
						String lines[] = pdfFileInText.split("\\r?\\n");
						int lineCount =0;
						JobSeeker jobSeeker = new JobSeeker();
						jobSeeker.setName(lines[0]);
						jobSeeker.setLocation(lines[1]);
						for (String line : lines) {
							if(lineCount>1) {
							if(line.contains("Email :")) {
 								jobSeeker.setEmail(line.split("Email :")[1]);
							}
							else if(line.contains("Phone :")) {
								jobSeeker.setPhoneNumber(line.split("Phone :")[1]);
								
							}
							}
							lineCount++;
						}
						jobSeekerList.add(jobSeeker);

					}

				}

			}

		}

		return jobSeekerList;
	}

}
