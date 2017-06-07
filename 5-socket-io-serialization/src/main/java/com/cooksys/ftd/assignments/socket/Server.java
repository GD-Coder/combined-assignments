package com.cooksys.ftd.assignments.socket;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Server extends Utils {
	 private static final String  CONFIG_FILE_PATH = "C:/Users/ftd-5/code/combined-assignments/5-socket-io-serialization/config/config.xml";
	/**
     * Reads a {@link Student} object from the given file path
     *
     * @param studentFilePath the file path from which to read the student config file
     * @param jaxb the JAXB context to use during unmarshalling
     * @return a {@link Student} object unmarshalled from the given file path
     * @throws JAXBException 
     */
    public static Student loadStudent(String studentFilePath, JAXBContext jaxb) throws JAXBException {
    	  Unmarshaller serverUnmarshall = jaxb.createUnmarshaller();
          Student student = null;
          
          try (FileInputStream fileInStream = new FileInputStream(studentFilePath)) {
  			student = (Student) serverUnmarshall.unmarshal(fileInStream);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.toString();
  		}         
          
      	return student;
    }


    /**
     * The server should load a {@link com.cooksys.ftd.assignments.socket.model.Config} object from the
     * <project-root>/config/config.xml path, using the "port" property of the embedded
     * {@link com.cooksys.ftd.assignments.socket.model.LocalConfig} object to create a server socket that
     * listens for connections on the configured port.
     *
     * Upon receiving a connection, the server should unmarshal a {@link Student} object from a file location
     * specified by the config's "studentFilePath" property. It should then re-marshal the object to xml over the
     * socket's output stream, sending the object to the client.
     *
     * Following this transaction, the server may shut down or listen for more connections.
     * @throws IOException 
     * @throws JAXBException 
     */
    public static void main(String[] args) throws IOException {
    	Config config = null;
    	
    	try {
			config = Utils.loadConfig(CONFIG_FILE_PATH, createJAXBContext());
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	try (ServerSocket serverSock = new ServerSocket(config.getLocal().getPort());
	    	Socket clientSock = serverSock.accept();
	    	PrintWriter printer = new PrintWriter(clientSock.getOutputStream());)
    	{    		
			

	    	Student  student = loadStudent(config.getStudentFilePath(), createJAXBContext());
	    	System.out.println("Unmarshalling, please wait...");
	    	Marshaller marshal = createJAXBContext().createMarshaller();
	    	serverSock.close();
	    	marshal.marshal(student, printer);
	    	
	    	
	    	} 
					catch (IOException | JAXBException e) {
			
			e.printStackTrace();			
		}
    	
    	
		
    }
}
