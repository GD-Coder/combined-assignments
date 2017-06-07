package com.cooksys.ftd.assignments.socket;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.cooksys.ftd.assignments.socket.model.LocalConfig;
import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.RemoteConfig;
import com.cooksys.ftd.assignments.socket.model.Student;

public class Client {
	private static final String  CONFIG_FILE_PATH = "C:/Users/ftd-5/code/combined-assignments/5-socket-io-serialization/config/config.xml";
	    
    /**
     * The client should load a {@link com.cooksys.ftd.assignments.socket.model.Config} object from the
     * <project-root>/config/config.xml path, using the "port" and "host" properties of the embedded
     * {@link com.cooksys.ftd.assignments.socket.model.RemoteConfig} object to create a socket that connects to
     * a {@link Server} listening on the given host and port.
     *
     * The client should expect the server to send a {@link com.cooksys.ftd.assignments.socket.model.Student} object
     * over the socket as xml, and should unmarshal that object before printing its details to the console.
     * @throws JAXBException 
     * @throws FileNotFoundException 
     */
	

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
    	Config config = null;
    	
    	try
    	{
    		config = Utils.loadConfig(CONFIG_FILE_PATH, Utils.createJAXBContext());
    		
    	}
    	catch(Exception ex)
    	{
    		ex.toString();
    	}
    	
    	try
    	{
    		Socket clientSock = new Socket(config.getRemote().getHost(), config.getRemote().getPort());
    		InputStreamReader clientReader = new InputStreamReader(clientSock.getInputStream());
    		Unmarshaller unmarshallClient = Utils.createJAXBContext().createUnmarshaller();
    		Student student = (Student) unmarshallClient.unmarshal(clientReader);
    		System.out.println(student);
    		
		} 
    	catch (Exception ex) {

    		ex.toString();
		}
    	
			

    }
}
