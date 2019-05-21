package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Files {
		
	public List<String> readFile(String fileName) {
		String linea="";
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(fileName));

			//Mientras quede información
		    while (fichero.ready()) {
		    	linea = fichero.readLine();
		        list.add(linea);
		    }
		    fichero.close();
		}
		catch (FileNotFoundException fnfe){
			System.out.println("El archivo no se ha encontrado.");
		}
		catch(IOException ioe){
		    new RuntimeException("Error de entrada/salida.");
		}
		return list;
	}
		
	public List<Cruise> parseCruise(String fileName){
			
		List<String> stringList = readFile(fileName);
		List<Cruise> cruises = new ArrayList<Cruise>();
			
		for(String str : stringList) {
				
			String[] trozos = str.split(";");
			String[] cities;
			String[] dates;
			
			String code = trozos[0];
			String area = trozos[1];
			String denomination = trozos[2];
			String departurePort = trozos[3];
			cities = trozos[4].split("-");
			String description = trozos[5];
			String underage = trozos[6];
			int duration = Integer.parseInt(trozos[7]);
			dates = trozos[8].split("%");
			String codeBoat = trozos[9];
				
			boolean underagebool = false;
			if(underage.equals("S")) {
				underagebool = true;
			}
				
			cruises.add(new Cruise(code,area,denomination,departurePort,cities,description,underagebool,duration,date(dates),codeBoat));
			}
			return cruises;
		}
	
	public List<Boat> parseBoat(String filename){
		
		List<String> stringList = readFile(filename);
		List<Boat> boats = new ArrayList<Boat>();
		
		for(String str : stringList) {
			String[] trozos = str.split(";");
			
			String code = trozos[0];
			String denomination = trozos[1];
			String description = trozos[2];
			
			int numCamarotesDoblesInterior = Integer.parseInt(trozos[3]);
			int numCamarotesDoblesExterior = Integer.parseInt(trozos[4]);
			int numCamarotesFamiliaresInterior = Integer.parseInt(trozos[5]);
			int numCamarotesFamiliaresExterior = Integer.parseInt(trozos[6]);

			double precioCamaroteDobleInterior = Double.parseDouble(trozos[7]);
			double precioCamaroteDobleExterior = Double.parseDouble(trozos[8]);
			double precioCamaroteFamiliarInterior = Double.parseDouble(trozos[9]);
			double precioCamaroteFamiliarExterior = Double.parseDouble(trozos[10]);
		
			boats.add(new Boat(code, denomination, description, numCamarotesDoblesInterior, numCamarotesDoblesExterior, numCamarotesFamiliaresInterior, numCamarotesFamiliaresExterior, precioCamaroteDobleInterior, precioCamaroteDobleExterior, precioCamaroteFamiliarInterior, precioCamaroteFamiliarExterior));
		}
		
		return boats;
	}
	
	private List<Extra> parseExtra(String filename){
		
		List<String> stringList = readFile(filename);
		List<Extra> extras = new ArrayList<Extra>();
		
		for(String str : stringList) {
			String[] trozos = str.split(";");
			
			String extraCode = trozos[0];
			String denomination = trozos[1];
			double price = Double.parseDouble(trozos[2]);
			
			extras.add(new Extra(extraCode, denomination, price));
		}
		
		return extras;
	}

	private List<Date> date(String[] dates) {
		List<Date> finalDates = null;
		for (String each : dates) {
			//String[] d = each.split("/");
			Date date = new Date(each);
			finalDates.add(date);
		}
		return finalDates;
	}
}
