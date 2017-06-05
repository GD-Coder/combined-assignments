package com.cooksys.ftd.assignments.concurrency;

import com.cooksys.ftd.assignments.concurrency.model.config.ServerConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Server implements Runnable {
	private ServerConfig serverCon;
	
    public Server(ServerConfig config) {
    	this.serverCon = config;
    }

    @Override
    public void run() {
    	Runnable serverRunner = () -> {/* PLACE CODE HERE */};
    	Thread serverThread = new Thread(serverRunner);
    	serverThread.start();
    }
}
