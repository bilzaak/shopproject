package kasba.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Emaillist {

	private int eid;
	private String email;
	private String dupemail;
	private String stringdate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Emaillist(String email, String dupemail, String stringdate) {
		super();
		this.email = email;
		this.dupemail = dupemail;
		this.stringdate = stringdate;
	
	}
	public String getStringdate() {
		return stringdate;
	}
	public void setStringdate(String stringdate) {
		this.stringdate = stringdate;
	}
	public Emaillist() {
		super();
		
	}
	public String getDupemail() {
		return dupemail;
	}
	public void setDupemail(String dupemail) {
		this.dupemail = dupemail;
	}

	
	
	
}
