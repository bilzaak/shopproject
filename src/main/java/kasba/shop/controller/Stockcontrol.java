package kasba.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kasba.shop.helper.Stockreport;
import kasba.shop.model.Makeprice;
import kasba.shop.model.Stock;
import kasba.shop.repo.Makepricerepo;
import kasba.shop.repo.Stockrepo;

@RequestMapping("/stock")
@Controller
public class Stockcontrol {
    @Autowired
	private Stockrepo str;
	@Autowired
	private Makepricerepo mpr;

	@PostMapping("/getmystock")
public ResponseEntity<Stockreport> stockreport(@RequestBody String price,HttpSession session){
	int shopid=(int) session.getAttribute("shopid");

	
List<Stock> lst=str.findByShopid(shopid);
		
			float totaltaka=0;
			
			for(Stock s : lst) {
		Makeprice mp=mpr.findByShopidAndCompanyAndCode(shopid,s.getCompany(),s.getCode()).get(0);
		
		
		if(price.contentEquals("avg")) {
		totaltaka=totaltaka+mp.getAvg()*s.getAmount();	
		}
		if(price.contentEquals("max")) {
			totaltaka=totaltaka+mp.getMax()*s.getAmount();	
					}	
		if(price.contentEquals("min")) {
			totaltaka=totaltaka+mp.getMin()*s.getAmount();	
					}
		
		if(price.contentEquals("last")) {
			totaltaka=totaltaka+mp.getLast()*s.getAmount();	
					}
		}
			
	Stockreport sr=new Stockreport();
	sr.setTotaltaka(totaltaka);
sr.setSts(lst);
return new ResponseEntity<Stockreport>(sr,HttpStatus.OK);	
	
}
	
	
	
	
	
	
}
