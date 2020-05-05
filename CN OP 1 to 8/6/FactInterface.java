import java.rmi.*;
import java.rmi.server.*;
public interface FactInterface extends Remote
{
	public int fact(int n) throws RemoteException;
}
