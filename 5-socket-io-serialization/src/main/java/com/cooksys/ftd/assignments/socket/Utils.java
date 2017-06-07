package com.cooksys.ftd.assignments.socket;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.LocalConfig;
import com.cooksys.ftd.assignments.socket.model.RemoteConfig;
import com.cooksys.ftd.assignments.socket.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Shared static methods to be used by both the {@link Client} and
 * {@link Server} classes.
 */

public class Utils {
	

	/**
	 * @return a {@link JAXBContext} initialized with the classes in the
	 *         com.cooksys.socket.assignment.model package
	 * @throws FileNotFoundException 
	 */
	public static JAXBContext createJAXBContext() throws JAXBException {
		return JAXBContext.newInstance(Config.class, Student.class, LocalConfig.class, RemoteConfig.class);
	}

	/**
	 * Reads a {@link Config} object from the given file path.
	 *
	 * @param configFilePath
	 *            the file path to the config.xml file
	 * @param jaxb
	 *            the JAXBContext to use
	 * @return a {@link Config} object that was read from the config.xml file
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static Config loadConfig(String configFilePath, JAXBContext jaxb) throws JAXBException {
		Unmarshaller configUnmarshall = jaxb.createUnmarshaller();
		Config config = null;
			
			try (FileInputStream filepath = new FileInputStream(configFilePath);)
			{
				config = (Config) configUnmarshall.unmarshal(filepath);
				
			}
			catch(FileNotFoundException ex)
			{
				ex.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return config;
	}
}
