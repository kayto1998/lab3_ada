package Lab3;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.panayotis.gnuplot.JavaPlot;

public class Recorridos {
		
	public static void main(String[] args) throws IOException{
		
		ArrayList<Integer> principal = new ArrayList<Integer>();
		
		Scanner scan = new Scanner(System.in);

		File gnu = new File ("bfs.txt");
		gnu.createNewFile();
    	BufferedWriter bw = new BufferedWriter(new FileWriter(gnu));
    	
	    File gnu2 = new File ("dfs.txt");
	    gnu2.createNewFile();
    	BufferedWriter bw2 = new BufferedWriter(new FileWriter(gnu2));

		System.out.println("Ingrese tamaño de arreglos maximo:");
		int tamaño = scan.nextInt();
		long Tinicio1, Tfinal1,Tinicio2, Tfinal2;
		long tiempo;
		
		ArrayList<avl<Integer>> a = new ArrayList<avl<Integer>>();
		
		for(int x=2; x<=tamaño; x++) {
			//crear arreglos en peor caso
			a.add(crearArreglo(x));
			
			Tinicio1 = System.nanoTime();
			a.get(x-2).bfs(a.get(x-2).root, principal);
			Tfinal1 = System.nanoTime();
			tiempo = Tfinal1-Tinicio1;
				
			principal = new ArrayList<Integer>();
			bw.write(x+"\t"+tiempo+"\n");
					
			Tinicio2 = System.nanoTime();
			a.get(x-2).dfs(a.get(x-2).root, principal);
			Tfinal2 = System.nanoTime();
			tiempo = Tfinal2-Tinicio2;
			//
			principal = new ArrayList<Integer>();
			bw2.write(x+"\t"+tiempo+"\n");
				
		}
		
		bw.close();
		bw2.close();
		scan.close();
		Desktop.getDesktop().open(gnu);
		Desktop.getDesktop().open(gnu2);
	 	
	 	JavaPlot p = new JavaPlot();
	 	p.addPlot("\"bfs.txt\" with lines");
	 	p.addPlot("\"dfs.txt\" with lines");
	 	p.plot();
 	
	}
	
	public static avl<Integer> crearArreglo(int x) {
		avl<Integer> b = new avl<Integer>();
		for(int i=0; i<x; i++) {
			b.insert(i);
		}
		
		return b;
	}
}
