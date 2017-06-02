package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FatCat implements Capitalist {
	private Integer sal;
	private String nam;
	private FatCat own;

	public FatCat(String name, int salary) {
		this.nam = name;
		this.sal = salary;
		// throw new NotImplementedException();
	}

	public FatCat(String name, int salary, FatCat owner) {
		this.nam = name;
		this.sal = salary;
		// throw new NotImplementedException();
	}

	/**
	 * @return the name of the capitalist
	 */
	@Override
	public String getName() {
		return this.nam;
		// throw new NotImplementedException();
	}

	/**
	 * @return the salary of the capitalist, in dollars
	 */
	@Override
	public int getSalary() {
		return this.sal;
		// throw new NotImplementedException();
	}

	/**
	 * @return true if this element has a parent, or false otherwise
	 */
	@Override
	public boolean hasParent() {
		throw new NotImplementedException();
	}

	/**
	 * @return the parent of this element, or null if this represents the top of
	 *         a hierarchy
	 */
	@Override
	public FatCat getParent() {
		throw new NotImplementedException();
	}
}
