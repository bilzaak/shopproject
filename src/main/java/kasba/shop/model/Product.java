package kasba.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
private int pid;
private String code;
private String name;
private String company;
private float unitprice;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getPid() {
	return pid;
}


public void setPid(int pid) {
	this.pid = pid;
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
public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public float getUnitprice() {
	return unitprice;
}

public void setUnitprice(float unitprice) {
	this.unitprice = unitprice;
}



public Product(String code, String name, String company, float unitprice) {
	super();
	this.code = code;
	this.name = name;
	this.company = company;
	this.unitprice = unitprice;

}


public Product() {
	super();

}
		
}
