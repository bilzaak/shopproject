package kasba.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Userreg{
	
private int uid;	
private String email;
private String password;
private String code;
private String catagory;
private String district;
private String phone;
private String thana;
private String shopname;

@Id
@GeneratedValue
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}


public Userreg() {
	super();
	
}



public Userreg(String email, String password, String code, String catagory, String district, String phone, String thana,
		String shopname) {
	super();
	this.email = email;
	this.password = password;
	this.code = code;
	this.catagory = catagory;
	this.district = district;
	this.phone = phone;
	this.thana = thana;
	this.shopname = shopname;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
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




}
