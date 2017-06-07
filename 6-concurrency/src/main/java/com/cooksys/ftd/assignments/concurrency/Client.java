package com.cooksys.ftd.assignments.concurrency;

import com.cooksys.ftd.assignments.concurrency.model.config.ClientConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Client implements Runnable {
	Runnable clientHandler = new ClientHandler();
	Thread clientHandlerThread = new Thread(clientHandler);

    public Client(ClientConfig config) {
    	
   
    }

    @Override
    public void run() {
    	Runnable clientRunner = () -> {/* PLACE CODE HERE */};
    	Thread clientThread = new Thread(clientRunner);
    	clientThread.start();
    }
}
