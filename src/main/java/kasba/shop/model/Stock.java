package kasba.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Stock {

private int sid;
private int shopid;
private String company;
private String code;
private String name;
private float amount;
private float totalprice;
private float unitprice;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
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
public float getTotalprice() {
	return totalprice;
}
public void setTotalprice(float totalprice) {
	this.totalprice = totalprice;
}
public float getUnitprice() {
	return unitprice;
}
public void setUnitprice(float unitprice) {
	this.unitprice = unitprice;
}
public Stock(int shopid, String company, String code, String name, float amount, float totalprice, float unitprice) {
	super();
	this.shopid = shopid;
	this.company = company;
	this.code = code;
	this.name = name;
	this.amount = amount;
	this.totalprice = totalprice;
	this.unitprice = unitprice;
}

public Stock() {
	super();
	// TODO Auto-generated constructor stub
}
	
}
