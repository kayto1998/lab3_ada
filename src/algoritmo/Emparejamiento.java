package algoritmo;

public class Emparejamiento {

	public static void main(String[] args) {
		
		Persona[] hombres = new Persona[5];
		Persona[] mujeres = new Persona[5];
		
		//hombres
		String[] h1 = {"Bertha","Amy","Diane","Erika","Claire"};
		Persona h11 = new Persona("Victor", h1);
		hombres[0] = h11;
		String[] h2 = {"Diane","Bertha","Amy","Claire","Erika"};
		Persona h22 = new Persona("Willian", h2);
		hombres[1] = h22;
		String[] h3 = {"Bertha","Erika","Claire","Diane","Amy"};
		Persona h33 = new Persona("Xavier", h3);
		hombres[2] = h33;
		String[] h4 = {"Amy","Diane","Claire","Bertha","Erika"};
		Persona h44 = new Persona("Yancey", h4);
		hombres[3] = h44;
		String[] h5 = {"Bertha","Diane","Amy","Erika","Claire"};
		Persona h55 = new Persona("Zeus", h5);
		hombres[4] = h55;
		
		//mujeres
		String[] m1 = {"Zeus","Victor","William","Yancey","Xavier"};
		Persona m11 = new Persona("Amy", m1);
		mujeres[0] = m11;
		String[] m2 = {"Xavier","William","Yancey","Victor","Zeus"};
		Persona m22 = new Persona("Bertha", m2);
		mujeres[1] = m22;
		String[] m3 = {"William","Xavier","Yancey","Zeus","Victor"};
		Persona m33 = new Persona("Claire", m3);
		mujeres[2] = m33;
		String[] m4 = {"Victor","Zeus","Yancey","Xavier","William"};
		Persona m44 = new Persona("Diane", m4);
		mujeres[3] = m44;
		String[] m5 = {"Yancey","William","Zeus","Xavier","Victor"};
		Persona m55 = new Persona("Erica", m5);
		mujeres[4] = m55;
		
		PropuestasH(hombres,mujeres);
		
		for(int i=0; i<hombres.length; i++) {
			System.out.println(hombres[i].getNombre()+"+"+hombres[i].getPareja());
		}

	}

	
	public static void PropuestasH(Persona[] hombres, Persona[] mujeres) {
		int positivo = 0;
		while(positivo<5) {
			positivo=0;
			for(int i=0; i<hombres.length; i++) {
				if(hombres[i].isRelacion()==true) {
					positivo++;
				} else {
					for(int j=0; j<mujeres.length; j++) {
						if(mujeres[j].isRelacion()==false) {
							hombres[i].setPareja(mujeres[j].getNombre());
							mujeres[j].setPareja(hombres[i].getNombre());
							hombres[i].setRelacion(true);
							mujeres[j].setRelacion(true);
							break;
						} else {
							for(int x=0; x<mujeres[j].preferencias.length; x++) {
								if(hombres[i].getNombre().equals(mujeres[j].getPreferencias()[x])) {
									for(int z=0; z<mujeres[j].preferencias.length; z++) {
										if(mujeres[j].getPareja().equals(mujeres[j].getPreferencias()[z])) {
											if(x<z) {
												String ex = mujeres[j].getPareja();
												mujeres[j].setPareja(hombres[i].getNombre());
												hombres[i].setRelacion(true);
												hombres[i].setPareja(mujeres[j].getNombre());
												for(int q=0; q<hombres.length; q++) {
													if(ex.equals(hombres[q].getNombre())) {
														hombres[q].setRelacion(false);
														hombres[q].setPareja("");
														break;
													}
												}
											}
											break;
										}
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
	}

}
