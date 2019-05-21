package logic;

public class Boat {
	
	private String code;
	private String denomination;
	private String description;
	
	private int numDoubleCabinsInside;
	private int numDoubleCabinsOutside;
	private int numFamiliarCabinsInside;
	private int numFamiliarCabinsOutside;
	
	private double priceDoubleCabinInside; 
	private double priceDoubleCabinOutside; 
	private double priceFamiliarCabinInside; 
	private double priceFamiliarCabinOutside;
	
	public Boat(String code, String denomination, String description, int numDoubleCabinsInside,
			int numCamaroteDoblesExterior, int numCamarotesFamiliaresInterior, int numCamarotesFamiliaresExterior,
			double precioCamaroteDobleInterior, double precioCamaroteDobleExterior,
			double precioCamaroteFamiliarInterior, double precioCamaroteFamiliarExterior) {
	
		this.code = code;
		this.denomination = denomination;
		this.description = description;
		this.numDoubleCabinsInside = numDoubleCabinsInside;
		this.numDoubleCabinsOutside = numCamaroteDoblesExterior;
		this.numFamiliarCabinsInside = numCamarotesFamiliaresInterior;
		this.numFamiliarCabinsOutside = numCamarotesFamiliaresExterior;
		this.priceDoubleCabinInside = precioCamaroteDobleInterior;
		this.priceDoubleCabinOutside = precioCamaroteDobleExterior;
		this.priceFamiliarCabinInside = precioCamaroteFamiliarInterior;
		this.priceFamiliarCabinOutside = precioCamaroteFamiliarExterior;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumDoubleCabinsInside() {
		return numDoubleCabinsInside;
	}

	public void setNumDoubleCabinsInside(int numDoubleCabinsInside) {
		this.numDoubleCabinsInside = numDoubleCabinsInside;
	}

	public int getNumCamaroteDoblesExterior() {
		return numDoubleCabinsOutside;
	}

	public void setNumCamaroteDoblesExterior(int numCamaroteDoblesExterior) {
		this.numDoubleCabinsOutside = numCamaroteDoblesExterior;
	}

	public int getNumCamarotesFamiliaresInterior() {
		return numFamiliarCabinsInside;
	}

	public void setNumCamarotesFamiliaresInterior(int numCamarotesFamiliaresInterior) {
		this.numFamiliarCabinsInside = numCamarotesFamiliaresInterior;
	}

	public int getNumCamarotesFamiliaresExterior() {
		return numFamiliarCabinsOutside;
	}

	public void setNumCamarotesFamiliaresExterior(int numCamarotesFamiliaresExterior) {
		this.numFamiliarCabinsOutside = numCamarotesFamiliaresExterior;
	}

	public double getPrecioCamaroteDobleInterior() {
		return priceDoubleCabinInside;
	}

	public void setPrecioCamaroteDobleInterior(double precioCamaroteDobleInterior) {
		this.priceDoubleCabinInside = precioCamaroteDobleInterior;
	}

	public double getPrecioCamaroteDobleExterior() {
		return priceDoubleCabinOutside;
	}

	public void setPrecioCamaroteDobleExterior(double precioCamaroteDobleExterior) {
		this.priceDoubleCabinOutside = precioCamaroteDobleExterior;
	}

	public double getPrecioCamaroteFamiliarInterior() {
		return priceFamiliarCabinInside;
	}

	public void setPrecioCamaroteFamiliarInterior(double precioCamaroteFamiliarInterior) {
		this.priceFamiliarCabinInside = precioCamaroteFamiliarInterior;
	}

	public double getPrecioCamaroteFamiliarExterior() {
		return priceFamiliarCabinOutside;
	}

	public void setPrecioCamaroteFamiliarExterior(double precioCamaroteFamiliarExterior) {
		this.priceFamiliarCabinOutside = precioCamaroteFamiliarExterior;
	}

	
	
}
