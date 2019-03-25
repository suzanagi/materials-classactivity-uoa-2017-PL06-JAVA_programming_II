import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerEnv extends Remote {
    String showComputer() throws RemoteException;
}
