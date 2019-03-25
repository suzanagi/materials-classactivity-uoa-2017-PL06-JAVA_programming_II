import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;

public class ServerEnvImpl extends UnicastRemoteObject
    implements ServerEnv {

    public ServerEnvImpl() throws RemoteException {
        super();
    }

    public String showComputer() {
	String hostName = ServerEnvImpl.getHostName();
	String osName = System.getProperty("os.name");
        return  "OS of " + hostName + " is " + osName + ".";
    }

    public static String getHostName(){
	try{
	    return InetAddress.getLocalHost().getHostName();
	}catch(Exception e){
	    e.printStackTrace();
	}
	return "UnknownHost";
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        if (System.getSecurityManager() == null) { 
	    System.setSecurityManager(new RMISecurityManager()); 
        } 
        try { 
	    ServerEnvImpl obj = new ServerEnvImpl(); 
	    // Bind this object instance to the name "HelloServer" 
            // RMI uses 1099 as a default port
            Naming.rebind("//localhost:4234/ServerEnvServer", obj); 
	    System.out.println("ServerEnv Server bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("ServerEnv err: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
