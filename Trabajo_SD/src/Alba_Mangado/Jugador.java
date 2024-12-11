package Alba_Mangado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Jugador extends Thread {
    private Socket s;
    private String nombre;
    public int contador;
    public ArrayParejas p;
    public boolean ganador;

    public Jugador(Socket socket, ArrayParejas parejas) {
        this.s = socket;
        this.nombre="";
        this.contador=0;
        this.p= parejas;
        this.ganador=false;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void add(int i) {
        this.contador++;
        this.p.par[i].setEmparejados(true);
    }

    public void run() {
        try(DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream())){
            String [] aspirante;
            String name;

            dout.writeBytes("Nombre?");
            dout.writeBoolean(true);
            dout.flush();
            name = din.readLine();
            this.setNombre(name);

            while(!(p.TodosPar())) {
                //Mostramos las parejas desordenadas
                dout.writeBytes(p.SinEmparejar());
                dout.writeBytes("\n" + "Propon una pareja de la forma: Pueblo,Gentilicio\n");
                dout.flush();

                //Leemos la pareja aspirante
                aspirante = din.readLine().split(",");
                System.out.println(aspirante[0] + " " + aspirante[1]);
                int parej=p.ParejaCorrecta(aspirante[0], aspirante[1]);

                //Vemos si la pareja es correcta
                if(parej>0) {
                    dout.writeBytes("\n" + "Pareja correcta\n");
                    this.add(parej);
                    dout.writeBytes(p.Emparejados());
                }else {
                    dout.writeBytes("\n" + "Pareja de " + aspirante[0] + ", " + aspirante[1] + " incorrecta \n");
                }
                dout.flush();
            }
            dout.writeBoolean(false);
            dout.flush();

            if (this.ganador){
                dout.writeBytes("\n" + "Enhorabuena has ganado con " + this.contador + " puntos\n" + p.Emparejados());
            }else {
                dout.writeBytes("\n" + "Has perdido con " + this.contador + " puntos\n");
            }
            dout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
