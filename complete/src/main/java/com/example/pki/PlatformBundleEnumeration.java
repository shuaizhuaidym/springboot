package com.example.pki;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class PlatformBundleEnumeration implements Enumeration<String> {

	private Set<String> set;
	private Iterator<String> iterator;
	private Enumeration<String> enumeration;
	private String next = null;

	public PlatformBundleEnumeration(Set<String> paramSet,
			Enumeration<String> paramEnumeration) {
		this.set = paramSet;
		this.iterator = paramSet.iterator();
		this.enumeration = paramEnumeration;
	}

	
	public boolean hasMoreElements() {
		if (this.next == null) {
			if (this.iterator.hasNext())
				this.next = ((String) this.iterator.next());
			else
				while ((this.enumeration != null) && (this.next == null)
						&& (this.enumeration.hasMoreElements())) {
					this.next = ((String) this.enumeration.nextElement());
					if (this.set.contains(this.next))
						;
					this.next = null;
				}

		}

		return (this.next != null);
	}

	
	public String nextElement() {
		if (hasMoreElements()) {
			String str = this.next;
			this.next = null;
			return str;
		}
		throw new NoSuchElementException();
	}

}
