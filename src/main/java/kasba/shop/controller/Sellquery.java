package kasba.shop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kasba.shop.helper.Masikodar;
import kasba.shop.helper.Masiksell;
import kasba.shop.repo.Sellingrepo;
import kasba.shop.model.*;

@RequestMapping("/sellquery")
@Controller
public class Sellquery {
	@Autowired
	private Sellingrepo slr;

	@PostMapping("/sellinamonth")
	public ResponseEntity<Masiksell> costprofitinamonth(@RequestBody String[] asik,HttpSession session) throws ParseException{
	int shopid=(int) session.getAttribute("shopid");
		if(asik[0].contentEquals("january")) {
			asik[0]="01";
		}
		if(asik[0].contentEquals("february")) {
			asik[0]="02";
		}
		if(asik[0].contentEquals("march")) {
			asik[0]="03";
		}
		if(asik[0].contentEquals("april")) {
			asik[0]="04";
		}
		if(asik[0].contentEquals("may")) {
			asik[0]="05";
		}
		if(asik[0].contentEquals("june")) {
			asik[0]="06";
		}
		if(asik[0].contentEquals("july")) {
			asik[0]="07";
		}
		if(asik[0].contentEquals("august")) {
			asik[0]="08";
		}
		if(asik[0].contentEquals("september")) {
			asik[0]="09";
		}
		if(asik[0].contentEquals("october")) {
			asik[0]="10";
		}
		if(asik[0].contentEquals("november")) {
			asik[0]="11";
		}
		if(asik[0].contentEquals("december")) {
			asik[0]="12";
		}

		YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(asik[1]),Integer.parseInt(asik[0]));
		int daysInMonth = yearMonthObject.lengthOfMonth();  
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String dt = "01"+"/"+asik[0]+"/"+asik[1];
String dt2=String.valueOf(daysInMonth)+"/"+asik[0]+"/"+asik[1];
Date d = sdf.parse(dt);
Date d2 = sdf.parse(dt2);

List<Sell> lst=slr.findByShopidAndSelldateBetween(shopid,d,d2);
Masiksell ms=new Masiksell();
float totalsell=0;
float totaldue=0;
for(Sell s:lst){
	totalsell=totalsell+s.getPayment();
	totaldue=totaldue+s.getDue();
	
}
ms.setTotalsell(totalsell);ms.setTotaldue(totaldue);ms.setSells(filtersell(lst));
return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);

}


@GetMapping("/todayssell")
public ResponseEntity<Masiksell> todayssell(HttpSession session) throws ParseException{
int shopid=(int) session.getAttribute("shopid");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date d =sdf.parse(sdf.format(new Date()));
List<Sell> lst=slr.findByShopidAndSelldate(shopid,d);
Masiksell ms=new Masiksell();
float totalsell=0;
float totaldue=0;
for(Sell s:lst){
	totalsell=totalsell+s.getPayment();
	totaldue=totaldue+s.getDue();
	
}

ms.setTotalsell(totalsell);ms.setTotaldue(totaldue);
ms.setSells(filtersell(lst));
return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);

}

public List<Sell> filtersell(List<Sell> sls){
	List<Sell> sls2=new ArrayList<Sell>();
		for(Sell s : sls) {
		int t=0;
		for(Sell s2:sls2) {
		if(s2.getMemokey().contentEquals(s.getMemokey())) {
			t++;
		}
			
		}
		if(t<1) {
			sls2.add(s);
		}
	    }
	return sls2;
}


@PostMapping("/customerbyname")
public ResponseEntity<Masiksell> bycustomername(@RequestBody String asik,HttpSession session){
	int shopid=(int) session.getAttribute("shopid");
	List<Sell> lst=slr.findByShopidAndCustomernameContainingIgnoreCase(shopid,asik);
	
	Masiksell ms=new Masiksell();
	float totalsell=0;
	float payment=0;
	for(Sell s:lst){
		totalsell=totalsell+s.getTotalprice();
		payment=payment+s.getPayment();
		}
	
	ms.setTotalsell(totalsell);
	ms.setTotaldue(totalsell-payment);
	ms.setSells(filtersell(lst));
	return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);
}

	
	@PostMapping("/customerbyphone")
	public ResponseEntity<Masiksell> bycustomerphone(@RequestBody String asik,HttpSession session){
		int shopid=(int) session.getAttribute("shopid");
		List<Sell> lst=slr.findByShopidAndCustomerphone(shopid,asik);
		Masiksell ms=new Masiksell();
		float totalsell=0;
		float totaldue=0;
		for(Sell s:lst){
			totalsell=totalsell+s.getPayment();
			totaldue=totaldue+s.getDue();
					}
		
		ms.setTotalsell(totalsell);ms.setTotaldue(totaldue);
		ms.setSells(filtersell(lst));
		return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);
	}
	

	@PostMapping("/customerbydate")
	public ResponseEntity<Masiksell> customerbyphone(@RequestBody String asik,HttpSession session) throws ParseException{
		int shopid=(int) session.getAttribute("shopid");
		Masiksell ms=new Masiksell();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(asik);
		List<Sell> lst=  slr.findByShopidAndSelldate(shopid,d);
		if(lst.isEmpty()) {
			lst.add(new Sell());lst.add(new Sell());
		}
		float totalsell=0;
		float totaldue=0;
		for(Sell s:lst){
			totalsell=totalsell+s.getTotalprice();
			totaldue=totaldue+s.getDue();
					}
		ms.setTotaldue(totaldue);ms.setTotalsell(totalsell);
		ms.setSells(filtersell(lst));
		return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);
		
	}
	
	@GetMapping("/memo")
	public ModelAndView sellmemo(@RequestParam int sid) throws ParseException{
		ModelAndView mv = new ModelAndView("sellmemo");
		Sell om=slr.findById(sid).get();
		List<Sell> lst=slr.findByMemokey(om.getMemokey());
		Masiksell ms=new Masiksell();
	float totalsell=0;
	float totaldue=0;
	for(Sell s:lst){
		totalsell=totalsell+s.getTotalprice();
		totaldue=totaldue+s.getDue();
	}
	ms.setTotalsell(totalsell);
	ms.setTotaldue(totaldue);
	ms.setSells(lst);
	mv.addObject("sellm",ms);
	return mv;

	}			

}
