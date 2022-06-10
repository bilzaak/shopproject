package kasba.shop.helper;

import java.util.List;

import kasba.shop.model.Sell;

public class Masiksell {

 List<Sell> sells;
private float totalsell;
private float totaldue;
public List<Sell> getSells() {
	return sells;
}
public void setSells(List<Sell> sells) {
	this.sells = sells;
}
public float getTotalsell() {
	return totalsell;
}
public void setTotalsell(float totalsell) {
	this.totalsell = totalsell;
}
public float getTotaldue() {
	return totaldue;
}
public void setTotaldue(float totaldue) {
	this.totaldue = totaldue;
}

	
}
