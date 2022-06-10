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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import kasba.shop.helper.Masiksell;
import kasba.shop.model.Sell;
import kasba.shop.repo.Odarrepo;
import kasba.shop.repo.Sellingrepo;

@RequestMapping("/duequery")
@Controller
public class Duequery {
	@Autowired
	private Sellingrepo slr;
	@Autowired
	private Odarrepo orr;
	public List<Sell> filtersell(List<Sell> sls){
		List<Sell> sls2=new ArrayList<Sell>();
		for(Sell s : sls) {
			int t=0;
			for(Sell s2:sls2) {
			if(s2.getMemokey().contentEquals(s.getMemokey())) {
				t++;
			}	}
			
			if(t<1) {
				sls2.add(s);
			}
		    }
;
		return sls2;
	}
	
	
	@PostMapping("/dueinamonth")
public ResponseEntity<Masiksell> mdydue(@RequestBody String[] dy, HttpSession session) throws ParseException{
		int shopid=(int) session.getAttribute("shopid");
		if(dy[0].contentEquals("january")) {
			dy[0]="01";
		}
		if(dy[0].contentEquals("february")) {
			dy[0]="02";
		}
		if(dy[0].contentEquals("march")) {
			dy[0]="03";
		}
		if(dy[0].contentEquals("april")) {
			dy[0]="04";
		}
		if(dy[0].contentEquals("may")) {
			dy[0]="05";
		}
		if(dy[0].contentEquals("june")) {
			dy[0]="06";
		}
		if(dy[0].contentEquals("july")) {
			dy[0]="07";
		}
		if(dy[0].contentEquals("august")) {
			dy[0]="08";
		}
		if(dy[0].contentEquals("september")) {
			dy[0]="09";
		}
		if(dy[0].contentEquals("october")) {
			dy[0]="10";
		}
		if(dy[0].contentEquals("november")) {
			dy[0]="11";
		}
		if(dy[0].contentEquals("december")) {
			dy[0]="12";
		}

		YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(dy[1]),Integer.parseInt(dy[0]));
		int daysInMonth = yearMonthObject.lengthOfMonth();  
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String dt = "01"+"/"+dy[0]+"/"+dy[1];
String dt2=String.valueOf(daysInMonth)+"/"+dy[0]+"/"+dy[1];
Date d = sdf.parse(dt);
Date d2 = sdf.parse(dt2);
List<Sell> lst=slr.findByShopidAndDueGreaterThanAndSelldateBetween(shopid,0,d,d2);
Masiksell ms=new Masiksell();
float totalsell=0;
float totaldue=0;

for(Sell s:lst){
	totalsell=totalsell+s.getPayment();
	totaldue=totaldue+s.getDue();
	}
ms.setTotalsell(totalsell);
ms.setTotaldue(totaldue);
ms.setSells(filtersell(lst));
return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);
	
}




@GetMapping("/todaysdue")
public ResponseEntity<Masiksell> todaysdue(HttpSession session)throws ParseException{
	int shopid=(int) session.getAttribute("shopd");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d =sdf.parse(sdf.format(new Date()));
	List<Sell> lst=slr.findByShopidAndSelldateAndDueGreaterThan(shopid,d,0);
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


@PostMapping("/dueinadate")
public ResponseEntity<Masiksell>dueofadate(@RequestBody String dt,HttpSession session)throws ParseException{
	int shopid=(int) session.getAttribute("shopid");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date d =sdf.parse(dt);
	List<Sell> lst=slr.findByShopidAndSelldateAndDueGreaterThan(shopid,d,0);
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



@GetMapping("/totaldue")
public ResponseEntity<Masiksell> totalsdue(HttpSession session)throws ParseException{
	int shopid=(int) session.getAttribute("shopid");
	List<Sell> lst=slr.findByShopidAndDueGreaterThan(shopid,0);
	Masiksell ms=new Masiksell();
	float totalsell=0;
	float totaldue=0;
	for(Sell s:lst){
		totalsell=totalsell+s.getTotalprice();
		totaldue=totaldue+s.getDue();
	}
	ms.setTotalsell(totalsell);
	ms.setTotaldue(totaldue);
	ms.setSells(filtersell(lst));
	return new ResponseEntity<Masiksell>(ms,HttpStatus.OK);
}


	
}
