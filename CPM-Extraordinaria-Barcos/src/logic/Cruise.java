package logic;

import java.util.Date;
import java.util.List;

public class Cruise {

	private String code;
	private String area;
	private String denomination;
	private String departurePort;
	private String[] cities;
	private String description;
	private boolean underage;
	private int duration;
	private List<Date> dates;
	private String codeBoat;

	public Cruise(String code, String area, String denomination, String departurePort, String[] cities,
			String description, boolean underage, int duration, List<Date> dates, String codeBoat) {

		this.code = code;
		this.area = area;
		this.denomination = denomination;
		this.departurePort = departurePort;
		this.cities = cities;
		this.description = description;
		this.underage = underage;
		this.duration = duration;
		this.dates = dates;
		this.codeBoat = codeBoat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isUnderage() {
		return underage;
	}

	public void setUnderage(boolean underage) {
		this.underage = underage;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public String getCodeBoat() {
		return codeBoat;
	}

	public void setCodeBoat(String codeBoat) {
		this.codeBoat = codeBoat;
	}

}
