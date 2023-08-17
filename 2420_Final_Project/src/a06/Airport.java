
package a06;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * @author Cristian Tapiero + Kevin Pineda
 *
 */
public class Airport {
	private ST<String, String> airportNameST;
	private ST<String, String> airportCountryST;
	private ST<String, Float> airportLatitudeST;
	private ST<String, Float> airportLongitudeST;
	private String name;
	private String country;
	private float latitude;
	private float longitude;

	/**
	 * @param airlines
	 */
	public Airport(String airportID) {

		readAirportName();
		readAirportCountry();
		readAirportLatitude();
		readAirportLongitude();
		name = airportNameST.get(airportID);
		country = airportCountryST.get(airportID);
		latitude = airportLatitudeST.get(airportID);
		longitude = airportLongitudeST.get(airportID);
	}

	public void readAirportName() {
		String fileName = "src/a06/Resources/airport.csv";
		In in = new In(fileName);
		String line;
		airportNameST = new ST<>();

		while (in.hasNextLine()) {
			line = in.readLine();
			String[] tokens = line.split(",");
			try {
				String airlineID = tokens[0];
				String name = tokens[1];
				airportNameST.put(airlineID, name);

			} catch (NumberFormatException ex) {
				System.err.println("Problem reading in " + "\"" + line + "\"");
				ex.printStackTrace();
			}
		}
	}

	public void readAirportCountry() {
		String fileName = "src/a06/Resources/airport.csv";
		In in = new In(fileName);
		String line;
		airportCountryST = new ST<>();

		while (in.hasNextLine()) {
			line = in.readLine();
			String[] tokens = line.split(",");
			try {
				String airlineID = tokens[0];
				String country = tokens[3];
				airportCountryST.put(airlineID, country);

			} catch (NumberFormatException ex) {
				System.err.println("Problem reading in " + "\"" + line + "\"");
				ex.printStackTrace();
			}
		}
	}

	public void readAirportLatitude() {
		String fileName = "src/a06/Resources/airport.csv";
		In in = new In(fileName);
		String line;
		airportLatitudeST = new ST<>();

		while (in.hasNextLine()) {
			line = in.readLine();
			String[] tokens = line.split(",");
			try {
				String airlineID = tokens[0];
				float latitude = Float.parseFloat(tokens[4]);
				airportLatitudeST.put(airlineID, latitude);

			} catch (NumberFormatException ex) {
				System.err.println("Problem reading in " + "\"" + line + "\"");
				ex.printStackTrace();
			}
		}
	}
				
	public void readAirportLongitude() {
		String fileName = "src/a06/Resources/airport.csv";
		In in = new In(fileName);
		String line;
		airportLongitudeST = new ST<>();

		while (in.hasNextLine()) {
			line = in.readLine();
			String[] tokens = line.split(",");
			try {
				String airlineID = tokens[0];
				float longitude = Float.parseFloat(tokens[5]);
				airportLongitudeST.put(airlineID, longitude);

			} catch (NumberFormatException ex) {
				System.err.println("Problem reading in " + "\"" + line + "\"");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the airlineID
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the airlineID
	 */
	public String getCountry() {
		return this.country;
	}

	@Override
	public String toString() {
		return String.format("Airport [name=%s, country=%s, latitude=%f, longitude=%f]", name, country, latitude,
				longitude);
	}
	
	public static void main(String[] args) {
		Airport myAirport =  new Airport("BOG");
		System.out.println(myAirport.toString());
	}

	
	
}
