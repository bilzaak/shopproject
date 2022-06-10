package kasba.shop.helper;

import java.util.List;

import kasba.shop.model.Odar;

public class Masikodar {

	List<Odar> odars;
	
	private float totalodar;

	public float getTotalodar() {
		return totalodar;
	}

	public List<Odar> getOdars() {
		return odars;
	}

	public void setOdars(List<Odar> odars) {
		this.odars = odars;
	}

	public void setTotalodar(float totalodar) {
		this.totalodar = totalodar;
	}
	
	
}
