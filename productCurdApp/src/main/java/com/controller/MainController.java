package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.Dao.ProductDao;
import com.Model.Product;

@Controller
public class MainController {
	
	@Autowired
	ProductDao productdao;

	@RequestMapping("/home")
	public String getHome(Model m) {
		List<Product> allProducts = productdao.getAllProducts();
		m.addAttribute("product", allProducts);
		return "home";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Product_Add");
		return "add_product_form";
	}
	
	@RequestMapping(path="/handle-product",method=RequestMethod.POST)
	public RedirectView processForm(@ModelAttribute("product") Product prod,HttpServletRequest req) {
		RedirectView rv = new RedirectView();
		productdao.createProduct(prod);
		System.out.println(prod);
		rv.setUrl(req.getContextPath()+"/home");
		return rv;
	}
	
	@RequestMapping("/delete-product/{id}")
	public RedirectView deleteProd(@PathVariable("id")int id,HttpServletRequest req) {
		this.productdao.deleteProduct(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(req.getContextPath()+"/home");
		return rv;
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id")int id,Model m) {
		Product product = this.productdao.getProduct(id);
		m.addAttribute("product", product);
		return "update_form";
	}
}
