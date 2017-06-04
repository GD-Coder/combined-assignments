package com.cooksys.ftd.assignments.collections.model;

public class WageSlave implements Capitalist {
	private int sal;
	private String nam;
	private FatCat owner;
	
    public WageSlave(String name, int salary) {
    	this.nam = name;
    	this.sal = salary;
        //throw new NotImplementedException();
    }

    public WageSlave(String name, int salary, FatCat owner) {
    	nam = name;
    	sal = salary;
    	this.owner = owner;
        //throw new NotImplementedException();
    }

    /**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
    	return this.nam;
        //throw new NotImplementedException();
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
    	return this.sal;
        //throw new NotImplementedException();
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
		if(this.owner != null){
			return true;
			
		}
		else return false;
		//throw new NotImplementedException();
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
    	if(this.owner != null)
		{
			//System.out.println(owner);
			return owner;
			
		}
		else return null;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nam == null) ? 0 : nam.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + sal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WageSlave other = (WageSlave) obj;
		if (nam == null) {
			if (other.nam != null)
				return false;
		} else if (!nam.equals(other.nam))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}

    
    
}
