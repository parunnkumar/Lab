import java.rmi.*; 
import java.util.Scanner;
public class AirTicketClient 
{
	public static void main(String args[]) throws Exception
	{
		AirTicket t = (AirTicket) Naming.lookup("//localhost:1099/AirTicketDetails");
		Scanner scan = new Scanner(System.in);
		System.out.println("Air Ticket Details Application Using RMI\n\n"); 
		System.out.println("\nFlights:\n1.Chennai -> Frankfurt\n2.Chennai -> London\n3.Chennai -> Dubai\n4.Chennai -> Toronto\n5.Chennai -> Quebec");
		System.out.print("Choose a flight: "); 
		int flightop = scan.nextInt();
		System.out.println("\nFlight Times:\n 0000 \n 0300 \n 0900 \n 1400\n 1700");
		System.out.print("Choose a flight time: ");
		int timeop = scan.nextInt();
		System.out.println("\nEnter the no. of tickets desired: "); 
		int n = scan.nextInt();
		double ticketCost = t.getTicketCost(flightop); 	
		double totalCost = t.getTotalCost(ticketCost,n);
		int arrivalTime = t.getArrivalTime(flightop, timeop);
		if(ticketCost<0 || totalCost<0 || arrivalTime<0)
		{
			System.out.println("Error in processing. Program exiting."); 
			System.exit(0);
		}		
		System.out.println("\n\nYOUR TICKET DETAILS:");
		System.out.println("Flight: AirIndia");
		System.out.println("Source: Chennai");
		System.out.print("Destination: "); switch(flightop)
		{
			case 1:
			System.out.println("Frankfurt");
			break;
			case 2:
			System.out.println("London");
			break;
			case 3:
			System.out.println("Dubai");
			break;
			case 4:
			System.out.println("Toronto");
			break;
			case 5:
			System.out.println("Quebec");
			break;
		}
		System.out.println("Departure Time: "+timeop); 
		System.out.println("Arrival Time: "+arrivalTime);	
		System.out.println("No. of Tickets Reserved: "+n);
		System.out.println("Cost per Ticket: "+ticketCost);
		System.out.println("Total Cost: "+totalCost);	
	}
}