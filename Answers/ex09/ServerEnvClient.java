import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerEnvClient {

    public static void main(String args[]) {
	String message = "ServerEnv: This is my text message";
	
	ServerEnv obj = null;

	try{
	    obj = (ServerEnv)Naming.lookup("//localhost:4234" + "/ServerEnvServer");
	    message = obj.showComputer();
	}catch(Exception e){
	    System.out.println("ServerEnvClient exception: " + e.getMessage());
	    e.printStackTrace();
	}
	System.out.println("Server Env: " + message);
    }
}
