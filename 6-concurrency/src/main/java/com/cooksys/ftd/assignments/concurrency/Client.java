package com.cooksys.ftd.assignments.concurrency;

import com.cooksys.ftd.assignments.concurrency.model.config.ClientConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Client implements Runnable {
	private ClientConfig clientCon;

    public Client(ClientConfig config) {
    	this.clientCon = config;
   
    }

    @Override
    public void run() {
    	Runnable clientRunner = () -> {/* PLACE CODE HERE */};
    	Thread clientThread = new Thread(clientRunner);
    	clientThread.start();
    }
}
