package be.iris.utilities;

import java.io.Serializable;
import java.util.Comparator;

import be.iris.entities.Tutperson;

@SuppressWarnings("serial")
public class PrenomComparator implements Comparator<Tutperson>,Serializable  {

	public int compare(Tutperson c1, Tutperson c2) {
		int prenomComp = c1.getPfname().compareToIgnoreCase(c2.getPfname());
		if (prenomComp != 0)
			return prenomComp;
		else
			return c1.getPlname().compareToIgnoreCase(c2.getPlname());
		}
}
