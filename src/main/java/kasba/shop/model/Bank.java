package kasba.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {
private int bid;
private long fromcustom;
private int shopid;
private long  balance;
private long fromsell;
public int getShopid() {
	return shopid;
}
public void setShopid(int shopid) {
	this.shopid = shopid;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
public long getFromsell() {
	return fromsell;
}
public void setFromsell(long fromsell) {
	this.fromsell = fromsell;
}
public long getFromcustom() {
	return fromcustom;
}
public void setFromcustom(long fromcustom) {
	this.fromcustom = fromcustom;
}

@Id
@GeneratedValue
public int getBid() {
	return bid;
}

public void setBid(int bid) {
	this.bid = bid;
}

}
