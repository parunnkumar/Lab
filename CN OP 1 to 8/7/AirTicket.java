import java.rmi.*;
public interface AirTicket extends Remote
{
	public double getTicketCost(int op) throws RemoteException;
	public double getTotalCost(double cost, int n) throws RemoteException;
	public int getArrivalTime(int op, int departTime) throws RemoteException;
}
