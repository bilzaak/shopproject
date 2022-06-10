package kasba.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fee{
    private int fid;
	private int shopid;
	private String paystatus;
	private Date date;
     private String district;
	 private String phone;
	 private String thana;
	 private String shopname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getThana() {
		return thana;
	}

	public void setThana(String thana) {
		this.thana = thana;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public Fee(int shopid, String paystatus, Date date, String district, String phone, String thana, String shopname) {
		super();
		this.shopid = shopid;
		this.paystatus = paystatus;
		this.date = date;
		this.district = district;
		this.phone = phone;
		this.thana = thana;
		this.shopname = shopname;
	}
	
	
	
}
