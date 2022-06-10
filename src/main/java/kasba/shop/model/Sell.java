package kasba.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Sell{

	private int sid;
	private String stringselldate;
	private Date selldate;
	private String customername;
	private String customerphone;
	private String code;
	private String company; 
	private float due;
	private float payment;
	private String name;
	private float amount;
	private float unitprice; // selling price is equal to=last unitprice+5%*last unitprice;
	private float totalprice;
	private int shopid;
	private String sellto; // shop keeper // individual person
	private float sellshopid; // if not sell to individual person then need shop id to whom the product will be should
	private String memokey;
	
public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Id
	@GeneratedValue
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStringselldate() {
		return stringselldate;
	}
	public void setStringselldate(String stringselldate) {
		this.stringselldate = stringselldate;
	}
	public Date getSelldate() {
		return selldate;
	}
	public void setSelldate(Date selldate) {
		this.selldate = selldate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getDue() {
		return due;
	}
	public void setDue(float due) {
		this.due = due;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getSellto() {
		return sellto;
	}
	public void setSellto(String sellto) {
		this.sellto = sellto;
	}
	public float getSellshopid() {
		return sellshopid;
	}
	public void setSellshopid(float sellshopid) {
		this.sellshopid = sellshopid;
	}


	public Sell(String stringselldate, Date selldate, String customername, String customerphone, String code,
			String company, float due, String name, float amount, float unitprice, float totalprice, int shopid,
			String sellto, float sellshopid,String memokey,float payment) {
		super();
		this.stringselldate = stringselldate;
		this.selldate = selldate;
		this.customername = customername;
		this.customerphone = customerphone;
		this.code = code;
		this.company = company;
		this.due = due;
		this.name = name;
		this.amount = amount;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.shopid = shopid;
		this.sellto = sellto;
		this.sellshopid = sellshopid;
		this.memokey = memokey;
		this.payment=payment;
	}
	
	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMemokey() {
		return memokey;
	}
	public void setMemokey(String memokey) {
		this.memokey = memokey;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
		
}
