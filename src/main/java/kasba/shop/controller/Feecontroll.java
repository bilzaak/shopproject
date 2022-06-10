package kasba.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kasba.shop.model.Fee;
import kasba.shop.repo.Feerepo;
import kasba.shop.repo.Userregrepo;

@Controller
@RequestMapping("/fee")
public class Feecontroll {
	
	@Autowired
	private Feerepo frr;
	
	@RequestMapping("/f")
	public String fee() {
		
		return "fee";
	}
	
	
	
	@PostMapping("/findbyshopid")
	public ResponseEntity<List<Fee>> findbyshopid(@RequestBody int shopid) {
		List<Fee> lst=frr.findByShopid(shopid);
		return new  ResponseEntity<List<Fee>>(lst,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/seeall")
	public ResponseEntity<List<Fee>> seeall() {

	    List<Fee> lst=frr.findAll();
		return new  ResponseEntity<List<Fee>>(lst,HttpStatus.OK);
		
		
	}
	
	
	
	@PostMapping("/finduser")
	public ResponseEntity<List<Fee>> findusers(@RequestBody Fee ser) {
		List<Fee> lst=null;
		if(!ser.getDistrict().contentEquals("any") && ser.getThana().contentEquals("any")) {
		lst=frr.findByDistrictOrderByShopnameAsc(ser.getDistrict());	
	
		}
	
		if(ser.getDistrict().contentEquals("any") && !ser.getThana().contentEquals("any") ) {
		lst=frr.findByThanaOrderByShopnameAsc(ser.getThana());	

		}
		
		if(!ser.getDistrict().contentEquals("any") &&  !ser.getThana().contentEquals("any") ){
		
			lst=frr.findByDistrictAndThanaOrderByShopnameAsc(ser.getDistrict(),ser.getThana());	

		}	
		
		if(ser.getDistrict().contentEquals("any") &&  ser.getThana().contentEquals("any") ){
			
			lst=frr.findAll();	

		}	
		
	
		return new  ResponseEntity<List<Fee>>(lst,HttpStatus.OK);
		
		
	}	
	
	
	@PostMapping("/findbyshopname")
	public ResponseEntity<List<Fee>> findbyshopname(@RequestBody Fee ser) {
		List<Fee> lst=frr.findByDistrictAndThanaAndShopname(ser.getDistrict(),ser.getThana(),ser.getShopname());
		return new  ResponseEntity<List<Fee>>(lst,HttpStatus.OK);
		
		}	
	
	@RequestMapping("/dataentry")
	public String dataentry(){
	
		return "dataentry";
		
		}		
	
	
	
	
	@PostMapping("/update")
	public ResponseEntity<Fee> update(@RequestBody Fee x) {

		try {
			int t=Integer.parseInt(x.getPhone());
			
		}catch(NumberFormatException ne) {
			
		
			x.setDistrict("number is not correct");
			return new  ResponseEntity<Fee>(x,HttpStatus.OK);	
		}
		
    
		if(x.getPhone().length()<11) {
			x.setDistrict("number length should be 11");
			return new  ResponseEntity<Fee>(x,HttpStatus.OK);	
			
		}
		
		if(x.getPaystatus().contentEquals("unipaid") || x.getPaystatus().contentEquals("paid") || x.getPaystatus().contentEquals("unpaid")) {
			frr.save(x);
			x.setDistrict("successfully updated");
			return new  ResponseEntity<Fee>(x,HttpStatus.OK);	
			
		}	
		
		
		x.setDistrict("payment status should be unpaid or uni-paid or paid");	

	
	return new  ResponseEntity<Fee>(x,HttpStatus.OK);
	
		
		}	
		
}
