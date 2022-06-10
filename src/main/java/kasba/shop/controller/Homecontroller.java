package kasba.shop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kasba.shop.model.Adminmail;
import kasba.shop.model.Fee;
import kasba.shop.model.Userreg;
import kasba.shop.repo.Adminmailrepo;
import kasba.shop.repo.Emaillistrepo;
import kasba.shop.repo.Feerepo;
import kasba.shop.repo.Userregrepo;



@Controller

public class Homecontroller {
@Autowired
private Userregrepo urr;
@Autowired
private Adminmailrepo adr;
@Autowired
private Feerepo frr;
@Autowired
private Emaillistrepo listr;

	@RequestMapping("/")
	public String admin() {
		
		return "register";
	}
	
	
	public boolean checknumeric(String str) {
		boolean x=true;
		 
		try {
			    int Value = Integer.parseInt(str);
			    
			} catch (NumberFormatException e) {
				
			  x=false;
			  
			}
		return x;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Userreg> admnlogin(@RequestBody Userreg user,HttpSession session){
		
	 if(user.getDistrict().length()<1) {
		 user.setCode("write the shop address including district , thana , road");
			
		 return new ResponseEntity<Userreg>(user,HttpStatus.OK);	
		}
	 if(user.getThana().length()<1) {
		 user.setCode("write the shop address including district , thana , road");
			
		 return new ResponseEntity<Userreg>(user,HttpStatus.OK);	
		}
	 if(user.getThana().length()<1) {
		 user.setCode("write the shop address including district , thana , road");
			
		 return new ResponseEntity<Userreg>(user,HttpStatus.OK);	
		}
	 
	  if(user.getPhone().length()!=11 || !checknumeric(user.getPhone()) ) {
		 
	
		 user.setCode("wrong phone number");
			
		 return new ResponseEntity<Userreg>(user,HttpStatus.OK);	 
	 }
	 
	 if(user.getCatagory().length()<1) {
		 
			
		 user.setCode("shop catagory not selected , please select");
			
		 return new ResponseEntity<Userreg>(user,HttpStatus.OK);	 
	 } 
		
	
	if(!urr.existsByEmail(user.getEmail()) && listr.existsByEmail(user.getEmail())) {
	String adminmail=adr.findAll().get(0).getEmail();
 String adminpass=adr.findAll().get(0).getPassword();
	String codertu = getrandom();
	if(new Sendotp().sendotp(codertu, user.getEmail(),"email verification code",adminmail,adminpass)) {
		session.setAttribute("codertu",codertu);
		user.setCode("ok");
	}
	else {
		user.setCode("wrong email, or email not sent");	
		
	}
	return new ResponseEntity<Userreg>(user,HttpStatus.OK);	
	
}
		

user.setCode("wrong email, or email already exists, or user number exceded");
return new ResponseEntity<Userreg>(user,HttpStatus.OK);
	
	}
	
	
	public  String getrandom() {
		String chars = "123456789abcdefgh"
          +"ijkmnpqrstuvwxyz#";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < 4; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	

@PostMapping("/regfinal")
public ResponseEntity<Userreg> finalreg(@RequestBody Userreg user,HttpSession session) throws ParseException{
	
	Adminmail adm = adr.findAll().get(0);
String rancode = (String) session.getAttribute("codertu");

if(user.getCode().contentEquals(rancode)){
	
    if(!urr.existsByEmail(user.getEmail())){
    	urr.save(user);
    	user.setCode("ok");
        
        Userreg u= urr.findByEmail(user.getEmail()).get(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Fee f=new Fee();
        f.setShopid(u.getUid());
        f.setDate(sdf.parse(sdf.format(new Date())));
        f.setDistrict(user.getDistrict());
        f.setThana(user.getThana());
        f.setShopname(user.getShopname());
        f.setPaystatus("unpaid");
        frr.save(f);
        
    	String sms="successfully registered , your email:"+user.getEmail()+"login password: "+user.getPassword()+" shop id is: "+f.getShopid()+" pay bill before "+
    	"8/"+(1+f.getDate().getMonth())+"/"+f.getDate().getYear();
    	   new Sendotp().sendotp(sms, user.getEmail(),"registration successfull", adm.getEmail(), adm.getPassword());
    }
	
}



else {
user.setCode("no");	
	
}

return new ResponseEntity<Userreg>(user,HttpStatus.OK);
	
	}	
	
	
	@PostMapping("/recover")
	public ResponseEntity<Userreg> recover(@RequestBody Userreg forgot,HttpSession session){
		
	
	if(!urr.existsByEmail(forgot.getEmail()) ) {
		forgot.setCode("not registered yet");

	}
	
	else if(urr.existsByEmail(forgot.getEmail())) {
				String code = getrandom();
		session.setAttribute("rechujuw",code);
			if(new Sendotp().sendotp(code, forgot.getEmail(),"password recover code",adr.findAll().get(0).getEmail(),
					
			adr.findAll().get(0).getPassword())) {
				forgot.setCode("ok");
			           }
			                   else {
				    forgot.setCode("sorry ,wrong email address");
			                         }
	
		
	}
	
else {
		
		forgot.setCode("this is not your email");
	}
		
	return new ResponseEntity<Userreg>(forgot,HttpStatus.OK);
	
	}	
	
	
	
	@PostMapping("/finalrec")
	public ResponseEntity<Userreg> finalrec(@RequestBody Userreg forgot,HttpSession session){
String rec = (String) session.getAttribute("rechujuw");


if(forgot.getPassword().length()<4) {
	forgot.setCode("minimum password length is 4");	
	return new ResponseEntity<Userreg>(forgot,HttpStatus.OK);
}


if(!rec.contentEquals(forgot.getCode())) {
	forgot.setCode("the code is not matched try again");	
	return new ResponseEntity<Userreg>(forgot,HttpStatus.OK);
}


if(rec.contentEquals(forgot.getCode())) {
	Userreg fa =urr.findByEmail(forgot.getEmail()).get(0);
	fa.setPassword(forgot.getPassword());
	urr.save(fa);	
	String sms="you recovered password, email:"+fa.getEmail()+"new password is: "+fa.getPassword();
    new Sendotp().sendotp(sms, fa.getEmail(),"pasword recovery",adr.findAll().get(0).getEmail(),
    		adr.findAll().get(0).getPassword());
 	forgot.setCode("successfull");
 	return new ResponseEntity<Userreg>(forgot,HttpStatus.OK);
}

return new ResponseEntity<Userreg>(forgot,HttpStatus.OK);
	
	}		
	
	
	
	
	@PostMapping("/userlogin")
	public ModelAndView login(@RequestParam String email, @RequestParam String password ,HttpSession session) {
		ModelAndView mv = new ModelAndView();
	
if(!urr.existsByEmail(email)) {
	mv.addObject("sms","you have not registred yet,regster now");
	mv.setViewName("register");
	return mv;
}
		
else if(urr.existsByEmailAndPassword(email,password)) {
			mv.setViewName("index");
		session.setAttribute("adminuser",email);
		session.setAttribute("adminpass",password);
		Userreg ur = urr.findByEmailAndPassword(email,password);
		
		int shopid=ur.getUid();
		session.setAttribute("shopid",shopid);
		
		}

		else {
			mv.addObject("sms","email or password error");
			mv.setViewName("register");
			
		}
	
		
		return mv;
	}	
	
	
	@PostMapping("/checkpass")
	public ResponseEntity<Checkp> checkpass(@RequestBody String p) {


Checkp t = new Checkp();

		if(urr.existsByPassword(p)) {
		t.setSms("yes");
		System.out.println("the password exist"+p);
		System.out.println("the password exist"+p);
		System.out.println("the password exist"+p);
		return new ResponseEntity<Checkp>(t,HttpStatus.OK); 
	}		
	
		
		System.out.println("not exist"+p);
		System.out.println("not exist"+p);
		System.out.println("not exist"+p);
		System.out.println("not exist"+p);
		System.out.println("not exist"+p);
	
		t.setSms("no");
		return new ResponseEntity<Checkp>(t,HttpStatus.OK); 	
	}
	
@RequestMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.removeAttribute("adminpass");	sesion.removeAttribute("adminuser");
		return "register";
	}
	
	


@PostMapping("/shopbyid")
public ResponseEntity <Userreg> byshopid(@RequestBody String shopid){
	Userreg u=null;
	try {
	 u=urr.findById(Integer.valueOf(shopid)).get();
		
	}catch(NoSuchElementException e){
		
u=new Userreg();u.setDistrict("not");
return new ResponseEntity<Userreg>(u,HttpStatus.OK);
	}

return new ResponseEntity<Userreg>(u,HttpStatus.OK);
}


@PostMapping("/shopbyemail")
public ResponseEntity <Userreg> byshopemail(@RequestBody String email) {
	Userreg u=null;
	try {
	 u=urr.findByEmail(email).get(0);
			
		}catch(Exception e){
			
	u=new Userreg();u.setDistrict("not");
	return new ResponseEntity<Userreg>(u,HttpStatus.OK);
		}

	
	return new ResponseEntity<Userreg>(u,HttpStatus.OK);
}




}
