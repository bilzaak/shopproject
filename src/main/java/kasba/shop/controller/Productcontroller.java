package kasba.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kasba.shop.model.Product;
import kasba.shop.model.Psh;
import kasba.shop.repo.Productrepo;


@Controller
@RequestMapping("/product")
public class Productcontroller {

@Autowired
private Productrepo prr;
List<Product> pdlist=null;
String record="";
public void checkduplicateproduct(Product p) {
	int t=0;
	for(Product pk : pdlist) {
		
	if(pk.getCompany().contentEquals(p.getCompany()) && pk.getName().contentEquals(p.getName()) && pk.getCode().contentEquals(p.getCode())){
		
		t++;
	}
		
	}
	
	if(t>0) {
		record=record+" ,"+p.getCompany()+" ,"+p.getName()+" ,"+p.getCode()+" is taken two times ";
	}
	else {
		pdlist.add(p);
	}
	
}

@PostMapping("/saveentry")
ResponseEntity<Product> addproduct(@RequestBody List<Product> lst){
	
	pdlist=new ArrayList<Product>();
for(Product pr : lst) {
	
	checkduplicateproduct(pr);
	
}


if(!record.contentEquals("")) {
	Product pt = new Product();
	pt.setCompany("company field is empty ");
	return new ResponseEntity<Product>(pt,HttpStatus.OK);
}
	
    Product p1=new Product();
	String up=lst.get(0).getCompany();

	
	if(up.length()<1) {
	p1.setCompany("company field is empty ");

	return new ResponseEntity<Product>(p1,HttpStatus.OK);
	                 }
	
	
	for(Product p : lst) {
		p.setCompany(up);
		
		
	}
	
	
	

String sms="";

for(Product p : lst) {
	
if(prr.existsByCompanyAndCode(p.getCompany(),p.getCode()) || prr.existsByCompanyAndNameIgnoreCase(p.getCompany(),p.getName())){
sms=sms+",the product code or name already exists , record no "+(1+lst.indexOf(p));
p1.setCompany(sms);
	return new ResponseEntity<Product>(p1,HttpStatus.OK);
}

	if(p.getName().length()<1) {
		sms=sms+" product name is empty in record no  "+(1+lst.indexOf(p));
	
		p1.setCompany(sms);
		return new ResponseEntity<Product>(p1,HttpStatus.OK);
	}
	
	if(p.getUnitprice()<1 || p.getUnitprice()==0) {
		
		sms=sms+" invalid product price in record no  "+(1+lst.indexOf(p));
	
		p1.setCompany(sms);
		return new ResponseEntity<Product>(p1,HttpStatus.OK);
	}
	
	if(p.getCode().length()<1) {
		
		sms=sms+" product code is empty  in record no"+(1+lst.indexOf(p));
	
		p1.setCompany(sms);
		return new ResponseEntity<Product>(p1,HttpStatus.OK);
	}

	

}

	
if(sms.contentEquals("")) {
	
	prr.saveAll(lst);
	p1.setCompany("successfully added record");
}

return new ResponseEntity<Product>(p1,HttpStatus.OK);

}


@PostMapping("/searchbycompany")
ResponseEntity<List<Product>> sbycompany(@RequestBody String company){
	
	List<Product> lst=prr.findByCompanyContainingIgnoreCase(company);
	
	return new ResponseEntity<List<Product>>(lst,HttpStatus.OK);
	                
}

@PostMapping("/searchbycode")
ResponseEntity<List<Product>> sbycode(@RequestBody String code){
	
	List<Product> lst=prr.findByCodeContainingIgnoreCase(code);
	
	return new ResponseEntity<List<Product>>(lst,HttpStatus.OK);
	                
}

@PostMapping("/searchbyname")
ResponseEntity<List<Product>> sbyname(@RequestBody String name){
	List<Product> lst=prr.findByNameContainingIgnoreCase(name);
	return new ResponseEntity<List<Product>>(lst,HttpStatus.OK);
	                
}

@PostMapping("/filterproduct")
ResponseEntity<List<Product>> productproduct(@RequestBody Psh psh){
	if(psh.getSby().contentEquals("byname")) {
		List<Product> lst=prr.findByCompanyAndNameContainingIgnoreCase(psh.getCompany(),psh.getName());
		return new ResponseEntity<List<Product>>(lst,HttpStatus.OK);
	}

	List<Product> lst=prr.findByCompanyAndCodeContainingIgnoreCase(psh.getCompany(),psh.getCode());
	return new ResponseEntity<List<Product>>(lst,HttpStatus.OK);	
	

	                
}



@RequestMapping(value="/update",method=RequestMethod.PUT)
ResponseEntity<Product> PUTP(@RequestBody Product product){
	
	String sms="";
	if(product.getName().length()<1) {
		sms=", empty product name ";
	}
	
	if(product.getCompany().length()<1) {
		
		sms=sms+", product company is empty ";
		
	}
	
	if(product.getCode().length()<1) {
		
		sms=sms+", product code is empty ";
		
	}
	
	if(product.getUnitprice()<0 || product.getUnitprice()==0) {
		sms=sms+", invalid unit price ";
	}
	
	
	
	if(sms.contentEquals("")) {
		prr.save(product);
		product.setCompany("successfull");
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
product.setCompany(sms);
return new ResponseEntity<Product>(product,HttpStatus.OK);
	                
}
	

}
