package Alba_Mangado;

public class Pareja {
	private String pueblo;
	private String gentilicio;
	private boolean enparejados;
	
	public Pareja(String pueblo, String gentilicio) {
		this.pueblo = pueblo;
		this.gentilicio = gentilicio;
		this.enparejados=false;
	}
	public void setEmparejados(boolean b) {
		this.enparejados=b;
	}
	public boolean getEmparejados(){
		return this.enparejados;
	}
	public String getPueblo(){
		return this.pueblo;
	}
	public String getGentilicio() {
		return this.gentilicio;
	}
}
