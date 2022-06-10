package kasba.shop.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kasba.shop.model.Fee;
import kasba.shop.repo.Feerepo;

@Component
public class Feeschedule {
@Autowired
private Feerepo frr;


@Scheduled(cron="0 0 01 * * *")

public void feetask() throws ParseException {
	
List<Fee> lst = frr.findAll();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

Date d= sdf.parse(sdf.format(new Date()));
	

	if(d.getDate()==1) {
		
		for(Fee f : lst) {
			
		f.setDate(d);	f.setPaystatus("unpaid");
			
			
		}
	}
	
	

}





	
}
