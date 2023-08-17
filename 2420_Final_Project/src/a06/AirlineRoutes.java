
package a06;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.DepthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolDigraph;

/**
 * @author Cristian Tapiero + kevin Pineda + Tommy Xa
 *
 */
public class AirlineRoutes {
	private static final double airplaneSpeed = 500; // mph
	private static ArrayList<Airport> airportPaths = new ArrayList<>();

	private static void routeChecker(SymbolDigraph routes, Digraph myDigraph, String departure, String destination) {
		if (!routes.contains(departure)) {
			StdOut.println(departure + " is not an airport that is available");
			destination = StdIn.readLine();
		}else {
			StdOut.println("Your itenaray from " + departure + " is: ");
			int a = routes.indexOf(departure);
			int b = routes.indexOf(destination);
			BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(myDigraph, a);

			if (bfs.hasPathTo(b)) {
				StdOut.print("Your itenaray from " + routes.nameOf(b) + " is: ");
				for (int x : bfs.pathTo(b)) {

					StdOut.print(routes.nameOf(x) + "   ");
					airportPaths.add(new Airport(routes.nameOf(x)));
				}
			}
		}
	}

	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			return (dist);
		}
	}

	private static double totalDistance(ArrayList<Airport> airportPaths) {
		Queue<Double> dist = new Queue<>();
		double total = 0.0;
		for (int i = 0; i < airportPaths.size(); i++) {
			if (i == airportPaths.size() - 1) {
				break;
			} else {
				dist.enqueue(distance(airportPaths.get(i).getLatitude(), airportPaths.get(i).getLongitude(),
						airportPaths.get(i + 1).getLatitude(), airportPaths.get(i + 1).getLongitude()));
			}
		}
		while (!dist.isEmpty()) {
			total += dist.dequeue();
		}
		return total;
	}

	private static Date calculateTime(double distance) throws ParseException {
		double totalDistance = totalDistance(airportPaths);
		double x = totalDistance / airplaneSpeed;
		String s = String.format("%06d", (int) x);
		DateFormat format = new SimpleDateFormat("HHmmss");
		Date date = format.parse(s);
		return date;
	}

	public static void main(String[] args) {
		String routesFile = "src/a06/Resources/newroutes.txt";
		SymbolDigraph routes = new SymbolDigraph(routesFile, "	");
		Digraph myDigraph = routes.digraph();

		StdOut.print("Departure: ");
		StdOut.println();
		String departure = StdIn.readLine();
		StdOut.print("Destination: ");
		String destination = StdIn.readLine();

		// route test
		routeChecker(routes, myDigraph, departure, destination);
		System.out.println();
		System.out.println("test" + airportPaths.toString());
		System.out.println();

		// size test
		int size = airportPaths.size() - 1;
		System.out.println("up to index " + size);

		// distance test
		// need to adjust per the amount of edges
		System.out.println("new method " + totalDistance(airportPaths));
//		double edge1 = distance(airportPaths.get(0).getLatitude(), airportPaths.get(0).getLongitude(),
//				airportPaths.get(1).getLatitude(), airportPaths.get(1).getLongitude());
//		double edge2 = distance(airportPaths.get(1).getLatitude(), airportPaths.get(1).getLongitude(),
//				airportPaths.get(2).getLatitude(), airportPaths.get(2).getLongitude());
//		double edge3 = distance(airportPaths.get(2).getLatitude(), airportPaths.get(2).getLongitude(),
//				airportPaths.get(3).getLatitude(), airportPaths.get(3).getLongitude());
//		System.out.println(edge1 + " + " + edge2 + " + " + edge3 + " = " + (edge1 + edge2 + edge3));
		System.out.println();

		// time test
		try {
			System.out.println("time is: " + calculateTime(totalDistance(airportPaths)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//getname test
		StdOut.print("names of airports: ");
		for(Airport airport: airportPaths) {
			StdOut.print(airport.getName() + ", ");
		}
		StdOut.println();
		
		

	}

}
