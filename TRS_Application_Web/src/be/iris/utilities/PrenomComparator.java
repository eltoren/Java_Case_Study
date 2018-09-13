package be.iris.utilities;

import java.io.Serializable;
import java.util.Comparator;

import be.iris.entities.Tutperson;

public class PrenomComparator implements Comparator,Serializable  {

	public int compare(Object o1, Object o2) {
		
		
		Tutperson c1 = (Tutperson) o1;
		Tutperson c2 = (Tutperson) o2;
		
		int prenomComp = c1.getPfname().compareToIgnoreCase(c2.getPfname());
		if (prenomComp != 0)
		return prenomComp;
		else
		return c1.getPlname().compareToIgnoreCase(c2.getPlname());
		}
}
