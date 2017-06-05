package com.cooksys.ftd.assignments.concurrency;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ClientHandler implements Runnable {

    @Override
    public void run() {
    	Runnable clientHandler = () -> {/* PLACE CODE HERE */};
    	Thread clientHandlerThread = new Thread(clientHandler);
    	clientHandlerThread.start();
    }
}
