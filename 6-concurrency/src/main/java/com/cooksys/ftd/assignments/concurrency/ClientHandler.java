package com.cooksys.ftd.assignments.concurrency;

import java.io.File;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cooksys.ftd.assignments.concurrency.model.config.Config;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ClientHandler implements Runnable {
	private Socket clientSock;
	
   
	@Override
    public void run() { 
		
    	clientHandlerThread.start();
    }
}
