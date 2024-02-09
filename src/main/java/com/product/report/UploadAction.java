package com.product.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.Productdao;
import com.product.model.Product;


public class UploadAction 
{
	public  List<Product> uploadAction() throws IOException
	{
		String path="D:\\Dummydata.xls";
		File f = new File(path);
		FileInputStream inputData = new FileInputStream(f);
		
	   HSSFWorkbook wb = new HSSFWorkbook(inputData);
		HSSFSheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum()-sh.getFirstRowNum();
	
		List<Product> lp = new ArrayList<Product>();
		
		for(int i=1; i<=rowcount; i++)
		{
			List<String> list = new ArrayList();
			List<Double> list2 = new ArrayList();
			int cellcount = sh.getRow(i).getLastCellNum();
			
			for(int j=0; j<cellcount; j++)
			{
				if(sh.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
				{
					list2.add(sh.getRow(i).getCell(j).getNumericCellValue());
				}
				if(sh.getRow(i).getCell(j).getCellType()==CellType.STRING)
				{
					list.add(sh.getRow(i).getCell(j).getStringCellValue());
				}
				
			}
			Product p = new Product();
			p.setProductComp(list.get(0));
			p.setProductCategory(list.get(1));
			p.setProductDesc(list.get(2));;
			p.setProductPrice(list2.get(0));
			
			lp.add(p);
		}
		
		lp = lp.stream().distinct().collect(Collectors.toList());
		
		return lp;
		
	}
	


}
