package kasba.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Odar {

	private int shopid;
	private String trid;
	private int oid;
	private String stringorderdate;
	private Date orderdate;
	private String code;
	private String company;
	private String name;
	private float unitprice;
	private float totalprice;
	private float amount;
	private float due;
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getTrid() {
		return trid;
	}
	public void setTrid(String trid) {
		this.trid = trid;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOid() {
		return oid;
	}
	
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getStringorderdate() {
		return stringorderdate;
	}
	public void setStringorderdate(String stringorderdate) {
		this.stringorderdate = stringorderdate;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Odar(int shopid, String trid, String stringorderdate, Date orderdate, String code, String company,
			String name, float unitprice, float totalprice,float amount,float due) {
		super();
		this.shopid = shopid;
		this.trid = trid;
		this.stringorderdate = stringorderdate;
		this.orderdate = orderdate;
		this.code = code;
		this.company = company;
		this.name = name;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.amount = amount;
		this.due = due;
	}
	
	public Odar() {
		super();
	
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getDue() {
		return due;
	}
	public void setDue(float due) {
		this.due = due;
	}
		
	
	
}
