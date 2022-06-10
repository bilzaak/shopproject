package kasba.shop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kasba.shop.model.Makeprice;
import kasba.shop.model.Odar;
import kasba.shop.model.Stock;
import kasba.shop.repo.Makepricerepo;
import kasba.shop.repo.Odarrepo;
import kasba.shop.repo.Productrepo;
import kasba.shop.repo.Stockrepo;
import kasba.shop.repo.Userregrepo;

@Controller
@RequestMapping("/order")
public class Odarcontrol {
@Autowired
private Odarrepo orr;
@Autowired
private Productrepo prr;
@Autowired
private Stockrepo str;

@Autowired
private Makepricerepo mpr;
@Autowired
private Userregrepo urr;

List<Odar> odlist=null;
String record="";
public void checduplicateproduct(Odar oj){
	int t=0;
for(Odar k : odlist) {
	if(oj.getShopid()==k.getShopid() && oj.getCompany().contentEquals(k.getCompany()) &&
			oj.getName().contentEquals(k.getName()) && oj.getCode().contentEquals(k.getCode())) {
		t++;
	}
	
}

if(t<1) {
	odlist.add(oj);
}
else {
record=record+", product name "+oj.getName()+" , code; "+oj.getCode()+" , company: "+oj.getCode()+" taken two times, remove any one record";
}
	


}

@PostMapping("/saveorder")	
public ResponseEntity<Odar> addodar(@RequestBody List<Odar> lst,HttpSession session){
	record="";
	odlist = new ArrayList<Odar>();
	for(Odar o : lst) {
		checduplicateproduct(o);	
		
	}
	
	Odar o = lst.get(0);
	o.setShopid((int) session.getAttribute("shopid"));
	
	if(!record.contentEquals("")){
		
		o.setCompany(record);
		return new  ResponseEntity<Odar>(o,HttpStatus.OK);	 	
	}
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String wrong="";
	
     	try {
 Date od=sdf.parse(o.getStringorderdate());   
		o.setOrderdate(od);	  
		   }catch(Exception e) {
		wrong="wrong date , make correction";  
			   
		   }

	
   if(!wrong.contentEquals("")) {
		o.setCompany(wrong);
		return new  ResponseEntity<Odar>(o,HttpStatus.OK);	   
   }
	
   
   for(Odar p : lst) {
		
		if(p.getAmount()<1) {
			p.setCompany("invalid product amount in record no "+(1+lst.indexOf(p)));
			return new  ResponseEntity<Odar>(p,HttpStatus.OK);			
			
		}
		
if(prr.existsByCompanyAndNameAndCode(p.getCompany(),p.getName(),p.getCode())) {
		p.setTrid(o.getTrid());
		p.setOrderdate(o.getOrderdate());
		p.setShopid(o.getShopid());	
		
	}
	
	if(!prr.existsByCompanyAndNameAndCode(p.getCompany(),p.getName(),p.getCode())){
	p.setCompany("this product is not available in database make correction in record no "+(1+lst.indexOf(p)));
	return new  ResponseEntity<Odar>(p,HttpStatus.OK);		
	}

   
		}
	
   SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String memokey=Integer.toString(o.getShopid())+sdf2.format(new Date());
for(Odar or : lst){
	or.setMemokey(memokey);
or.setTrid(o.getTrid());
or.setOrderdate(o.getOrderdate());
or.setShopid(o.getShopid());
or.setStringorderdate(o.getStringorderdate()); // setting or copying the first field input to other field or record

List<Stock> st = str.findByShopidAndCompanyAndNameAndCode(or.getShopid(),or.getCompany(),or.getName(),or.getCode()); 
List<Makeprice> mpp =mpr.findByShopidAndCompanyAndCode(or.getShopid(),or.getCompany(),or.getCode()); 
if(st.isEmpty()){
			Makeprice mp = new Makeprice();
		   mp.setAvg(or.getUnitprice());mp.setMax(or.getUnitprice());mp.setMin(or.getUnitprice());
		   mp.setLast(or.getUnitprice());
			mp.setCompany(or.getCompany());mp.setName(or.getName());mp.setCode(or.getCode());
			mp.setShopid(or.getShopid()); // this section will store a avrg min and max price of a particular product 
		if(mpp.isEmpty()) {
			mpr.save(mp); 
		}
		
		if(!mpp.isEmpty()) {
			Makeprice mp2=mpp.get(0);
			mp.setPid(mp2.getPid());
			mpr.save(mp); 
		}	
			// and save uniquely no duplicate product will be stored for same shopid
			
			Stock stock = new Stock();  // this section will store the amount of a particular product uniquely in the stock
			stock.setCompany(or.getCompany()); // how many product is available in the stock it will show it
			stock.setShopid(or.getShopid());
			stock.setName(or.getName());stock.setCode(or.getCode());
			stock.setTotalprice(or.getTotalprice());
			stock.setUnitprice(stock.getTotalprice());
			stock.setAmount(or.getAmount());
			str.save(stock);
			
 }
		

if(!st.isEmpty()){
	 Makeprice mp = getprice(or);				
	mp.setCompany(or.getCompany());
	mp.setName(or.getName());
	mp.setCode(or.getCode());
	mp.setShopid(or.getShopid()); // this section will store a avrg min and max price of a particular product 
	if(mpp.isEmpty()) {
		mpr.save(mp); 
	}
	
	if(!mpp.isEmpty()) {
		Makeprice mp2=mpp.get(0);
		mp.setPid(mp2.getPid());
		mpr.save(mp); 
	}	
		Stock stock = st.get(0); // only single record will be store for each unique shop id according to company name and product code and product name;
      	float amount = stock.getAmount()+or.getAmount();
      	stock.setAmount(amount);stock.setCode(or.getCode());
      	stock.setTotalprice(or.getUnitprice()*amount);
      	stock.setUnitprice(or.getUnitprice());
		str.save(stock);
			
}
 	}
	
	
orr.saveAll(lst);	
o.setCompany("successfully saved invoice");
return new  ResponseEntity<Odar>(o,HttpStatus.OK);	


}


public Makeprice getprice(Odar or){
	List<Odar> lst=orr.findByShopidAndCompanyAndCodeAndNameOrderByUnitpriceAsc(or.getShopid(),or.getCompany(),or.getCode(),or.getName());
	Makeprice mp = new Makeprice();
	int size=lst.size()-1;
	mp.setMin(lst.get(0).getUnitprice());
	mp.setLast(or.getUnitprice());
	
	mp.setMax(lst.get(size).getUnitprice());
	if(or.getUnitprice()>mp.getMax()) { // i am checking the running price is greater than the previous order price or not if then update price
		
		mp.setMax(or.getUnitprice());
	}
	
	float avg=orr.avrg(or.getCompany(),or.getShopid(),or.getName(),or.getCode());
	mp.setAvg(avg); 
	return mp;
	
	
}


		


}








