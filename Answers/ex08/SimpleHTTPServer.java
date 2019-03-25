import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class SimpleHTTPServer {

	  private final int port;
	  
	  /* Constructor */
	  public SimpleHTTPServer(int port)
	  {    
	    this.port = port; 
	  }
	  
	  /* Method to start the web server */
	  public void start() {
	    // Start a ServerSocker
	    // wait for connection
	    // then send the corresponding socket to an instance of Handler
	    // and let it handle the request
	    
		// Create a ServerSocket and wait for client to connect
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Create Infinite Loop
		while(true) {
		  // Accept Incoming Requests
		  try {
			Socket s  = ss.accept();
			// Make a handler with the accepted Socket object and throw all the processes to that
			Handler handler = new Handler(s);
			handler.start();
		  } catch (IOException e) {
			  e.printStackTrace();
			  break;
		  }
		  
		}
	  }

	  /* Subclass Handler to execute the server process */
	  private class Handler {
		  private final Socket connection;

		  /* Constructor */
		  Handler(Socket connection) {
			  this.connection = connection;
		  }
		  
		  /* Start method that execute the server process by using given socket */
		  public void start() throws IOException {
			  // Get InputStream and OutputStream from the socket.
			  InputStream is = connection.getInputStream();
			  // 1. read the request from the client.
			  BufferedReader stringStream = new BufferedReader(new InputStreamReader(is));
			  // 2. if it is not starting by "GET" then ignore
			  // 3. otherwise, extract the file name from the request.
			  // It will look like: "GET /filename.html HTTP/1.1"
			  // You can split the string by whitespaces.
			  String[] requests = stringStream.readLine().split(" ");
			  if(requests[0].equals("GET")) {
				  // 4. open the file and reads its content
				  if(requests[1].equals("/")) requests[1] = "/index.html";
				  String url = "/Network/Servers/stdfsv2/vol/vol8/home2/s1240234/java2/ex08" + requests[1];
				  File file = new File(url);
				  byte[] content = null;
				  try {
					content = Files.readAllBytes(file.toPath());
					// 5. create an HTTP header
					String headerStr = "HTTP/1.0 200 OK\r\n"
							+ "Server: SimpleHTTPServer\r\n"
							+ "Content-length: " + content.length + "\r\n"
							+ "Content-type: text/html"
							+ "; charset=utf-8" + "\r\n\r\n";
					byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
					// 6. send the header then the content via the OutputStream
					OutputStream os = connection.getOutputStream();
					os.write(header);
					os.write(content);
					os.flush();
					os.close();
				  } catch (IOException e) {
					OutputStream os = connection.getOutputStream();
					File notFound = new File("/Network/Servers/stdfsv2/vol/vol8/home2/s1240234/java2/ex08/404NotFound.html");
					byte[] notFoundContent = Files.readAllBytes(notFound.toPath());
					String header404String = "HTTP/1.0 404 Not Found\r\n"
						    + "Server: SimpleHTTPServer\r\n"
						    + "Content-length: " + notFoundContent.length + "\r\n"
						    + "Content-type: text/html"
						    + "; charset=utf-8" + "\r\n\r\n";
					byte[] header404 = header404String.getBytes(Charset.forName("UTF-8"));
					os.write(header404);
					os.write(notFoundContent);
					os.flush();
					os.close();
				  }
				  
			  }
			  is.close();
			  
			  return;
		  }
	  }


	  public static void main(String[] args) {
		  int port;	
		  try {
			  port = Integer.parseInt(args[0]);
			  if (port < 1024 || port > 65535) port = 8080;
		  } catch (RuntimeException ex) {
			  port = 8080;
		  }	

		  try {
			  SimpleHTTPServer server = new SimpleHTTPServer(port);
			  server.start();
	      
		  } catch (ArrayIndexOutOfBoundsException ex) {
			  System.out.println("Usage: java SimpleHTTPServer [port]");
		  }	
	  }	
	  	
}	
