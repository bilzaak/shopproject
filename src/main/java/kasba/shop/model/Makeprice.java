package kasba.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Makeprice {

	private int pid;
	private int shopid;
	private String company;
	private String name;
	private String code;
	private float avg;
	private float max;
	private float min;
	private float last;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public Makeprice(int shopid, String company, String name, String code, float avg, float max, float min) {
		super();
		this.shopid = shopid;
		this.company = company;
		this.name = name;
		this.code = code;
		this.avg = avg;
		this.max = max;
		this.min = min;
	}
	public Makeprice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getLast() {
		return last;
	}
	public void setLast(float last) {
		this.last = last;
	}
		
}
