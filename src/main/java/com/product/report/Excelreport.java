package com.product.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.product.model.Dealer;
import com.product.model.Product;
import com.product.service.Productservice;

public class Excelreport extends AbstractXlsView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		
		response.setHeader("Content-Disposition", "attachment; filename=\"product_report.xls\"");
		
		
		List<Product> plist =  (List<Product>) model.get("pList");
		List<Dealer> dlist =  (List<Dealer>) model.get("dList");
		
		Sheet sheet = workbook.createSheet("Product List");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("PRODUCT");
		header.createCell(2).setCellValue("DESCRIPTION");
		header.createCell(3).setCellValue("PRICE");
		header.createCell(4).setCellValue("START DATE");
		header.createCell(5).setCellValue("END DATE");
		
		int rowNum = 1;
		
		for (Product p : plist)
		{
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(p.getProductId());
			row.createCell(1).setCellValue(p.getProductComp()+" "+p.getProductCategory());
			row.createCell(2).setCellValue(p.getProductDesc());
			row.createCell(3).setCellValue(p.getProductPrice());
			row.createCell(4).setCellValue(p.getStartdt());
			row.createCell(5).setCellValue(p.getEnddt());
			
		}
		
	}

}
