package kasba.shop.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kasba.shop.model.Bank;
import kasba.shop.model.Bankrecord;
import kasba.shop.repo.Bankrecordrepo;
import kasba.shop.repo.Bankrepo;

@Controller
@RequestMapping("/bank")
public class Bankcontrol {

@Autowired
Bankrecordrepo brr;
@Autowired
Bankrepo bkr;
	
@PostMapping("/addbank")
public ResponseEntity<Bankrecord> addbank(@RequestBody Bankrecord b,HttpSession session){
	int shopid=(int) session.getAttribute("shopid");
	Bankrecord br1=new Bankrecord();
	br1.setShopid(shopid);
	br1.setTrid(b.getTrid());
	br1.setDate(new Date());
	br1.setSource("fromcustom");
	brr.save(br1);
	
		Bank b2=null;
		b2=bkr.findByShopid(shopid).get(0);
if(b2==null) {
	 b2=new Bank();
	b2.setBalance((long) b.getAmount());
	b2.setFromcustom((long) b.getAmount());
	b2.setShopid(shopid);
	bkr.save(b2);
	brr.save(br1);
	return new ResponseEntity<Bankrecord>(b,HttpStatus.OK);
}

b2.setBalance((long) b.getAmount()+b2.getBalance());
b2.setFromcustom((long) b.getAmount()+b2.getFromcustom());
b2.setShopid(shopid);
bkr.save(b2);

return new ResponseEntity<Bankrecord>(b,HttpStatus.OK);
}



@PostMapping("/removebank")
public ResponseEntity<Bankrecord> removebank(@RequestBody Bankrecord b,HttpSession session){
	int shopid=(int) session.getAttribute("shopid");
		Bank b2=null;
		b2=bkr.findByShopid(shopid).get(0);
if(b2==null) {
return new ResponseEntity<Bankrecord>(b,HttpStatus.OK);
}

if(b.getAmount()<b2.getBalance()) {
	b2.setBalance(b2.getBalance()-(long) b.getAmount());
	bkr.save(b2);
	
}
return new ResponseEntity<Bankrecord>(b,HttpStatus.OK);
}


@GetMapping("/bankbalance")
public ResponseEntity<Bank> removebank(HttpSession session){
	int shopid=(int) session.getAttribute("shopid");
		Bank b2=null;
		b2=bkr.findByShopid(shopid).get(0);
		
if(b2==null) {
	b2=new Bank();
return new ResponseEntity<Bank>(b2,HttpStatus.OK);
}

return new ResponseEntity<Bank>(b2,HttpStatus.OK);
}


	
}
