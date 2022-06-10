package kasba.shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class ShopApplication {

	public static void main(String[] args) {
	TimeZone.setDefault(TimeZone.getTimeZone("Asia/Dhaka"));
	SpringApplication.run(ShopApplication.class, args);
	System.out.println(new Date());
	
	}
	
}
