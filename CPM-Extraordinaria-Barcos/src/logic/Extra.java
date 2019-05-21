package logic;

public class Extra {
	
	private String extraCode;
	private String denomination;
	private double price;
	
	public Extra(String extraCode, String denomination, double price) {
		
		this.extraCode = extraCode;
		this.denomination = denomination;
		this.price = price;
	}

	public String getExtraCode() {
		return extraCode;
	}

	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
