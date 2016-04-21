package it.polito.tdp.ruzzle.model;

import java.util.Arrays;

public class CharList implements Comparable {
	char[] lett = new char[16];

	public CharList(char[] lett) {
		this.lett = lett;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(lett);
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
		CharList other = (CharList) obj;
		if (!Arrays.equals(lett, other.lett))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		CharList c = (CharList) arg0;
		if(this.equals(arg0)==true)
		return 0;
		else
			return 1;
	}

	
}
