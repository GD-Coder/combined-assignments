package com.cooksys.ftd.assignments.concurrency;

import com.cooksys.ftd.assignments.concurrency.model.config.ClientInstanceConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ClientInstance implements Runnable {
	private ClientInstanceConfig clientInstanceConfig;
	
	
	
    public ClientInstance(ClientInstanceConfig config) {
    	this.clientInstanceConfig = config;
    	
    }

    @Override
    public void run() {
    	
    	Runnable clientInstance = () -> {/* PLACE CODE HERE */};
    	Thread clientInstanceThread = new Thread(clientInstance);
    	clientInstanceThread.start();
    }
}
