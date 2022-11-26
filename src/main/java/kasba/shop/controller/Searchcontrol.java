package kasba.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Searchcontrol {

	
	
@RequestMapping("/searchorder")	
public String searchorder() {
	
	return "searchorder";
}
	
@RequestMapping("/searchsell")	
public String searchsell() {
	System.out.println("trying to work in collaborating  work of git hub");
	
	return "searchsell";
	
}

}
