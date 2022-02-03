package Lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class Irvings_Algorithm { 
	
	public static void main(String[] args) {
		
		Persona[] p = new Persona[6];
		
		String[] prefer11 = {"Peter","Paul","Sam","Kelly","Elise"};
		ArrayList<String> prefer1 = new ArrayList<String>();
		addList(prefer1, prefer11);
		
		Persona a = new Persona("Charlie", prefer1);
		
		String[] prefer22 = {"Kelly","Elise","Sam","Paul","Charlie"};
		ArrayList<String> prefer2 = new ArrayList<String>();
		addList(prefer2, prefer22);
		
		Persona b = new Persona("Peter", prefer2);
		
		String[] prefer33 = {"Peter","Sam","Kelly","Charlie","Paul"};
		ArrayList<String> prefer3 = new ArrayList<String>();
		addList(prefer3, prefer33);
		
		Persona c = new Persona("Elise", prefer3);
		
		String[] prefer44 = {"Elise","Charlie","Sam","Peter","Kelly"};
		ArrayList<String> prefer4 = new ArrayList<String>();
		addList(prefer4, prefer44);
		
		Persona d = new Persona("Paul", prefer4);
		
		String[] prefer55 = {"Peter","Charlie","Sam","Elise","Paul"};
		ArrayList<String> prefer5 = new ArrayList<String>();
		addList(prefer5, prefer55);
		
		Persona e = new Persona("Kelly", prefer5);
		
		String[] prefer66 = {"Charlie","Paul","Kelly","Elise","Peter"};
		ArrayList<String> prefer6 = new ArrayList<String>();
		addList(prefer6, prefer66);
		
		Persona f = new Persona("Sam", prefer6);
		
		p[0] = a;
		p[1] = b;
		p[2] = c;
		p[3] = d;
		p[4] = e;
		p[5] = f;
		
		int x=0;
		while(x!=1) {
			for(int i=0; i<p.length; i++) {
				for(int pre=0; pre<p.length-1;pre++) {
					if(p[i].getPareja()==null) {
						p[i].setPareja(p[i].getPreferencias().get(pre));
					} 
					
					for(int j=0; j<p.length; j++) {
						if(i>j && p[i].getPareja().equals(p[j].getPareja())) {
							for(int z=0; z<p.length; z++) {
								if(p[z].getNombre().equals(p[j].getPareja())) {
									int rank1=0;
									int rank2=0;
									
									/*obtener lugares de los repetidos
									en las preferencias del propuesto*/
									for(int y=0; y<p[z].getPreferencias().size(); y++) {
										if(p[i].getNombre().equals(p[z].getPreferencias().get(y))) {
											rank1=y;
										}
										if(p[j].getNombre().equals(p[z].getPreferencias().get(y))) {
											rank2=y;
										}
									}
									
									if(rank1<rank2) {
										p[z].getPreferencias().remove(rank2);
										p[j].getPreferencias().remove(pre);
										p[j].setPareja(null);
										i=0;
									} else {
										p[z].getPreferencias().remove(rank1);
										p[i].getPreferencias().remove(pre);
										p[i].setPareja(null);
										i=0;
									}
								}
							}
						}
					}
				}
				
			}
			x++;
		}
		
		for(int i=0; i<p.length-3;i++) {
			System.out.println(p[i].nombre+" + "+p[i].getPareja());			
		}
		
		
	}
	
	private static void addList(ArrayList<String> prefer, String[] array){        
	     for (String elemento: array) {
	        prefer.add(elemento);
	    }
	}
	
	

}
