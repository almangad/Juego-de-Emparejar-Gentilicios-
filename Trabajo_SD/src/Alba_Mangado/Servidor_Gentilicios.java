package Alba_Mangado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor_Gentilicios {
    public static void main(String[] args) {
        try(ServerSocket so = new ServerSocket(55555)){
            Socket s1 = null;
            Socket s2 = null;
            //Creamos el ArrayParejas en donde estarán las parejas
            ArrayParejas p = new ArrayParejas();
            while(!Thread.interrupted()) {
                try {
                    s1 = so.accept();
                    s2 = so.accept();
                    Jugador j1 = new Jugador(s1,p);
                    Jugador j2 = new Jugador(s2,p);

                    if (j1.contador>j2.contador) {
                        j1.ganador=true;
                        System.out.println(j1.getNombre() + " ganador\n");
                    } else if (j2.contador>j1.contador) {
                        j2.ganador=true;
                        System.out.println(j2.getNombre() + " ganador\n");
                    }else {
                        j1.ganador=true;
                        j2.ganador=true;
                        System.out.println("Empate\n");
                    }
                }finally {
                    if(s1!=null) {
                        try {
                            s1.close();
                        }catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(s2!=null) {
                        try {
                            s2.close();
                        }catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
