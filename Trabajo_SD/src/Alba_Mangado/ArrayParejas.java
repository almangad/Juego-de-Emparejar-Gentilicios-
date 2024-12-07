package Alba_Mangado;

import java.util.Random;

public class ArrayParejas {
	public int length;
	public Pareja [] par;

	public ArrayParejas(){
		this.par[0] = new Pareja("Sesma", "Sesmero/a");
		this.par[1] = new Pareja("Allo", "Gato/a");
		this.par[2] = new Pareja("Arroyo de la Mel", "Chichilindri");
		this.par[3] = new Pareja("Dueñas", "Botijero/a");
		this.par[4] = new Pareja("Arraya de Oca", "Jabali/ina");
		this.par[5] = new Pareja("Dos Hermanas", "Nazareno/a");
		this.par[6] = new Pareja("Almuñecar", "Sexitano/a");
		this.par[7] = new Pareja("Millana", "Albardero/a");
		this.par[8] = new Pareja("Haro", "Jarrero/a");
		this.par[9] = new Pareja("Leiva", "Olivense/a");
		this.par[10] = new Pareja("Santurdejo", "Galocho/a");
		this.par[11] = new Pareja("Villanueva de Cameros", "Pirino/a");
		this.par[12] = new Pareja("Huarte", "Cebollero/a");
		this.par[13] = new Pareja("Laraga", "Ragues/a");
		this.par[14]  = new Pareja("Marañon", "Puchejero/a");
		this.length=15;
	}
	public void vaciar() {
		this.length=0;
		}
	public void remove(int i) {
		this.par[i] = this.par[this.length];
		this.length--;
	}
	public ArrayParejas copy(){
		ArrayParejas c = new ArrayParejas();
		
		for(int i = 0; i<this.length;i++) {
			c.par[i]=this.par[i];
		}
		c.length=this.length;
		
		return c;
	}
	public String Emparejados() {
		String s="\nEmparejados:";
		for(int i=0; i<this.par.length; i++) {
			if(this.par[i].getEmparejados()) {
				s = s + "\n" + this.par[i].getPueblo() + ", " + this.par[i].getGentilicio();
			}
		}
		return s;
	}
	public String SinEmparejar() {
		ArrayParejas auxp = this.copy();
		Random r =  new Random();
		int j=0;
		for(int i=0; i<auxp.length; i++) {
			if(auxp.par[i].getEmparejados()) {
				auxp.remove(i);
			}
		}
		ArrayParejas auxg = this.copy();
		
		String s="\nPueblos:";
		while(auxp.length!=0) {
			j=r.nextInt(auxp.length);
			s = s + "\n" + auxp.par[j].getPueblo();
			auxp.remove(j);
		}
		s = s +"\nGentilicios:";
		while(auxg.length!=0) {
			j=r.nextInt(auxg.length);
			s = s + "\n" + auxg.par[j].getPueblo();
			auxg.remove(j);
		}	
		return s;
	}
	public boolean ParejaCorrecta(String pue, String gen) {
		boolean b=false;
		for(int i=0; i<this.length; i++) {
			if(this.par[i].getPueblo().equals(pue)) {
				b = this.par[i].getGentilicio().equals(gen);
				if(b) {
					this.remove(i);
				}
			}
		}
		return b;
	}
}
