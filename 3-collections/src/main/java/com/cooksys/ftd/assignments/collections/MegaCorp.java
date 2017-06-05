package com.cooksys.ftd.assignments.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {
	Set<Capitalist> capitol = new HashSet<>();
	/**
	 * Adds a given element to the hierarchy.
	 * <p>
	 * -----* If the given element is already present in the hierarchy, do not
	 * add it and return false
	 * <p>
	 * -----* If the given element has a parent and the parent is not part of
	 * the hierarchy, add the parent and then add the given element
	 * <p>
	 * -----* If the given element has no parent but is a Parent itself, add it
	 * to the hierarchy
	 * <p>
	 * ----- * If the given element has no parent and is not a Parent itself, do
	 * not add it and return false
	 *
	 * @param capitalist
	 *            the element to add to the hierarchy
	 * @return true if the element was added successfully, false otherwise
	 */
	@Override
	public boolean add(Capitalist capitalist) {
		
		/* Check the passed variable to ensure it isn't null or already in the list. 
		 * If so, the method returns false */
		if (capitalist == null || capitol.contains(capitalist)) {
			
			return false;
		}
		
		if (!(capitalist instanceof FatCat) && !capitalist.hasParent()) {
			return false;
		}
		
		/* Check the passed variable see if it has a parent and if the parent has been added to the hierarchy,
		 * if both conditions are not met, the element and its parent are added and the method returns true. */
		if (capitalist.hasParent() && !capitol.contains(capitalist.getParent())) {
			
			add(capitalist.getParent());
			return capitol.add(capitalist);
		} else if (capitalist.hasParent() && this.has(capitalist.getParent())) {
			return capitol.add(capitalist);
		}
		
		/* Check if the passed variable is an instance(child element) of the class FatCat and if it hasn't been added
		 * If both conditions are met, the variable is added and the method returns true. */
		if (capitalist instanceof FatCat && !has(capitalist)) {
			return capitol.add(capitalist);
		}
		
		/* By default, this method passes false */
		return false;
	}

	/**
	 * @param capitalist
	 *            the element to search for
	 * @return true if the element has been added to the hierarchy, false
	 *         otherwise
	 */
	@Override
	public boolean has(Capitalist capitalist) {
		 return capitol.contains(capitalist);
		// throw new NotImplementedException();
	}

	/**
	 * @return all elements in the hierarchy, or an empty set if no elements
	 *         have been added to the hierarchy
	 */
	@Override
	public Set<Capitalist> getElements() {
		return new HashSet<>(capitol);
	}

	/**
	 * @return all parent elements in the hierarchy, or an empty set if no
	 *         parents have been added to the hierarchy
	 */
	@Override
	public Set<FatCat> getParents() {
		Set<FatCat> fc = new HashSet<>();
		Iterator<Capitalist> cap = capitol.iterator();
		while (cap.hasNext()) {
			Capitalist capitalist = (Capitalist) cap.next();
			if (capitalist instanceof FatCat) {
				fc.add((FatCat) capitalist);
			}
		}
		return fc;
		

	}

	/**
	 * @param fatCat
	 *            the parent whose children need to be returned
	 * @return all elements in the hierarchy that have the given parent as a
	 *         direct parent, or an empty set if the parent is not present in
	 *         the hierarchy or if there are no children for the given parent
	 */
	@Override
	public Set<Capitalist> getChildren(FatCat fatCat) {
		Set<Capitalist> comp = new HashSet<>();
		Iterator<Capitalist> icomp = capitol.iterator();
		if(!capitol.contains(fatCat))
		{
			return comp;
		}
		while (icomp.hasNext()) {
			Capitalist capitalist = (Capitalist) icomp.next();
			
			if(fatCat == capitalist.getParent())
			{
				comp.add(capitalist);
			
			}
		}
		
		return comp;

//		return capitol.stream().filter(cap -> fatCat.equals(cap.getParent())).collect(Collectors.toSet());
		//throw new NotImplementedException();
	}

	/**
	 * @return a map in which the keys represent the parent elements in the
	 *         hierarchy, and the each value is a set of the direct children of
	 *         the associate parent, or an empty map if the hierarchy is empty.
	 */
	@Override
	public Map<FatCat, Set<Capitalist>> getHierarchy() {
		Map<FatCat, Set<Capitalist>> hmap = new HashMap<>();
		Iterator<FatCat> ifat = getParents().iterator();
		while (ifat.hasNext()) {
			FatCat fatCat = (FatCat) ifat.next();
			hmap.put(fatCat, getChildren(fatCat));
			
		}
		
		return hmap;
		//throw new NotImplementedException();
	}

	/**
	 * @param capitalist
	 * @return the parent chain of the given element, starting with its direct
	 *         parent, then its parent's parent, etc, or an empty list if the
	 *         given element has no parent or if its parent is not in the
	 *         hierarchy
	 */
	@Override
	public List<FatCat> getParentChain(Capitalist capitalist) {		
		List<FatCat> llFatCats = new LinkedList<>();
		if (!has(capitalist))
		{
			return llFatCats;
		} 
		else if (capitalist.hasParent())
		{
			
			FatCat fccheck = capitalist.getParent();
			llFatCats.add(fccheck);
			while (fccheck != null && has(fccheck.getParent())) {
				fccheck = fccheck.getParent();
				llFatCats.add(fccheck);
				
				
			}
		}
		
		
		return llFatCats;
		//throw new NotImplementedException();
	
	}
}
