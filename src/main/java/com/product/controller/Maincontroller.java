package com.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.product.dao.Dealerdao;
import com.product.dao.Manufacturerdao;
import com.product.dao.Productdao;
import com.product.model.Dealer;
import com.product.model.Manufacturer;
import com.product.model.Product;
import com.product.report.Excelreport;
import com.product.report.UploadAction;
import com.product.service.Dealerservice;
import com.product.service.Productservice;

@Controller
public class Maincontroller 
{
	Logger logger = Logger.getLogger(Maincontroller.class);
	
	@Autowired
	private Productservice productserv;
	@Autowired
	private Dealerservice dserv;
	
	@Autowired
	private Productdao pdao;
	@Autowired
	private Dealerdao ddao;
	
	@Autowired
	private Manufacturerdao mdao;
	
	@RequestMapping("/")
	public ModelAndView registerPage(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		session.removeAttribute("loginuser");
		
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("Registration");
		return mdv;
	}
	@RequestMapping(path = "/registrationform")
	public ModelAndView processRegisterPage(@ModelAttribute Manufacturer mnf,@ModelAttribute Dealer dl,HttpServletRequest req)
	{
		String chk = req.getParameter("check");
		ModelAndView mdv = new ModelAndView();
		
		if(chk.equalsIgnoreCase("manufacturer"))
		{
			String message = mdao.saveManufacturer(mnf)+"";
			
			if(message != null)
			{
				mdv.addObject("frwdmessage", "Successfully registered as "+chk);
			}
			else
			{
				mdv.addObject("frwdmessage", "Some error occured....");
			}
		}
		else if(chk.equalsIgnoreCase("dealer"))
		{
			String message = dserv.saveDealer(dl)+"";
			if(message != null)
			{
				mdv.addObject("frwdmessage", "Successfully registered as "+chk);
			}
			else
			{
				mdv.addObject("frwdmessage", "Some error occured....");
			}
		}
			
		mdv.setViewName("Registration");
		
		return mdv;
	}
	
	@RequestMapping(path = "/loginPage")
	public ModelAndView login()
	{
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("Login");
		return mdv;
	}
	
	@RequestMapping(path="/validateLogin")
	public String validateLogin(@ModelAttribute Manufacturer mnf,@ModelAttribute Dealer dl,HttpSession session)
	{
		Manufacturer mnfr = mdao.login(mnf.getEmail(), mnf.getPwd());
		Dealer dlr = dserv.showDealer(dl.getEmail(), dl.getPwd());
		if(mnfr != null)
		{
			session.setAttribute("loginuser", mnfr);
			return "redirect:/manufacturerhome";
		}
		else if(dlr != null)
		{
			session.setAttribute("loginuser", dlr);
			return "redirect:/dealerhome";
		}
		else
		{
			session.setAttribute("msg", "Invalid username and password");
			return "redirect:/loginPage";
		}
	}
	
	@RequestMapping(path = "/manufacturerhome")
	public ModelAndView manufacturerHome(HttpSession session)
	{
		session.setAttribute("pageNo",1);
		List<Product> plist = pdao.getProductPagination(1);
		
		ModelAndView mdv = new ModelAndView();
		session.setAttribute("productList", plist);
		mdv.setViewName("Manufacturerhome");
		return mdv;
	}
	
	@RequestMapping(path = "/goNextPage")
	public ModelAndView manufacturerHomeNext(HttpSession session)
	{
		int pageNo = (int)session.getAttribute("pageNo");
		pageNo++;
		session.setAttribute("pageNo",pageNo);
		List<Product> plist = pdao.getProductPagination(pageNo);
		if(plist.size()==0)
		{
			session.setAttribute("pageNo",1);
			plist=pdao.getProductPagination(1);
		}
		List<Dealer> dlist = dserv.showAllDealers();
		
		ModelAndView mdv = new ModelAndView();
		session.setAttribute("productList", plist);
		mdv.setViewName("Manufacturerhome");
		return mdv;
	}
	
	@RequestMapping(path = "/goPreviousPage")
	public ModelAndView manufacturerHomePrev(HttpSession session)
	{
		int pageNo = (int)session.getAttribute("pageNo");
		pageNo--;
		if(pageNo<=0){pageNo=1;}
		session.setAttribute("pageNo",pageNo);
		List<Product> plist = pdao.getProductPagination(pageNo);
		List<Dealer> dlist = dserv.showAllDealers();
		
		ModelAndView mdv = new ModelAndView();
		session.setAttribute("productList", plist);
		mdv.setViewName("Manufacturerhome");
		return mdv;
	}

	@RequestMapping(path = "/dealerhome")
	public ModelAndView dealerHome(HttpSession session)
	{
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("dealerhome");
		return mdv;
	}
	
	@RequestMapping("/addProductView")
	public ModelAndView addProduct()
	{
		List<Dealer> dlist = dserv.showAllDealers();
		ModelAndView mdv = new ModelAndView();
		mdv.addObject("title","ADD PRODUCT");
		mdv.addObject("dealerList",dlist);
		mdv.setViewName("addproductform");
		return mdv;
	}
	
	
	@RequestMapping(value="/addProductSubmit",method=RequestMethod.POST)
	public String handleProduct(@Valid @ModelAttribute("product") Product product,BindingResult res,
			@RequestParam("dealers") List<String> dealerList)
	{
		if(res.hasErrors())
		{
			List<ObjectError> err = res.getAllErrors();
			for(ObjectError e : err)
			{
			   System.out.println(e);	
			}
			return "addproductform";
		}

		List<Dealer> dealers = new ArrayList<Dealer>();
		for (String name : dealerList) 
		{
			Dealer dealer = ddao.getDealerByName(name);
			List<Product> products = dealer.getProduct();
			products.add(product);
			
			dealers.add(dealer);
		}
		product.setDealer(dealers);
		pdao.addProduct(product);		
		return "redirect:/manufacturerhome";
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId)
	{
		logger.info("Deleting product with ID"+productId);
		productserv.removeProduct(productId);
		
		return "redirect:/manufacturerhome";
	}
	
	@RequestMapping("/updateProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable("productId") int productId, HttpSession session)
	{
		List<Dealer> dealers = dserv.showAllDealers();
		
		Product product = productserv.showProduct(productId);
		ModelAndView mdv = new ModelAndView();
		mdv.addObject("product", product);
		mdv.addObject("dealerList",dealers);
		mdv.setViewName("updateForm");
		
		return mdv;
		
	}
	
	
	@RequestMapping("/searchProduct")
	public ModelAndView search(@RequestParam("search") String str,HttpSession session)
	{
		ModelAndView mdv = new ModelAndView();
		session.setAttribute("productList", pdao.getProductByName(str));
		mdv.setViewName("Manufacturerhome");
		
		return mdv;
	}
	
	@RequestMapping("/report")
	public ModelAndView exportReport(HttpSession session)
	{
		return new ModelAndView(new Excelreport(),"pList",(List<Product>) session.getAttribute("productList"));
	}
	
	@RequestMapping("/uploadPage")
	public String uploadPage()
	{
		return "Uploadfileform";
	}
	@RequestMapping(path="/uploadAction",method = RequestMethod.POST)
	public ModelAndView processUpload(@RequestParam("xlfile") CommonsMultipartFile file) throws IOException
	{
		UploadAction up = new UploadAction();
		ModelAndView mdv = new ModelAndView();
		System.out.println(file.getOriginalFilename());
		
		List<Product> plist = productserv.showAllProducts();
		List<Product> lp = up.uploadAction();
		List<String> p1 = new ArrayList<String>();
		List<String> p2 = new ArrayList<String>();
		int flag=0;
		
		for (Product product : plist) 
		{
			p1.add(product.getProductComp());
			p2.add(product.getProductCategory());
		}
		
		for (Product p : lp)
		{
			if(!p1.contains(p.getProductComp()) || !p2.contains(p.getProductCategory()))
			{
				flag++;
				productserv.saveProduct(p);
				mdv.addObject("message", flag+" records uploaded");
				
			}
			
		}
		
		mdv.setViewName("Uploadfileform");
		return mdv;
	
	}
	
	@RequestMapping("/saveSales")
	public String saveSales(@RequestParam int sales, @RequestParam int pid)
	{
		pdao.saveProductSales(sales, pid);
		return "redirect:/dealerhome";
	}

}
