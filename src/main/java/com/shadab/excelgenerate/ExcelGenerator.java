package com.shadab.excelgenerate;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.shadab.model.JobSeeker;

public class ExcelGenerator implements IExcelGenerator{
	
	private static String[] columns = {"Name", "PhoneNumber", "Email", "Date Of Birth", "Location"};

	@Override
	public void generateExcelSheet(List<JobSeeker> jobSeekers, String outputDirectory, String outputFileName) throws IOException {
		// TODO Auto-generated method stub
		
		 // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("JobSeeker");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(JobSeeker jobSeeker: jobSeekers) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(jobSeeker.getName());

            row.createCell(1)
                    .setCellValue(jobSeeker.getPhoneNumber());
            row.createCell(2)
            .setCellValue(jobSeeker.getEmail());
            Cell dateOfBirthCell = row.createCell(3);
            dateOfBirthCell.setCellValue(jobSeeker.getDateOfBirth());
            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(4)
                    .setCellValue(jobSeeker.getLocation());
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(outputDirectory+outputFileName+".xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
		
	}


