package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List<String> listaParole; 
		
	
	public Parole() {
		listaParole = new LinkedList<String>();	
	}
	
	public void addParola(String p) {
		listaParole.add(p);	
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void eliminate(String s) {
		listaParole.remove(s);
	}

}
