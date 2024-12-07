package Alba_Mangado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor_Gentilicios {
	public static void main(String[] args) {
		try(ServerSocket so = new ServerSocket(55555)){
			Socket s = null;
			//Creamos el ArrayParejas en donde estarán las parejas
			ArrayParejas p = new ArrayParejas();
			while(!Thread.interrupted()) {
                try {
                	s = so.accept();
                	try(DataInputStream din = new DataInputStream(s.getInputStream());
                			DataOutputStream dout = new DataOutputStream(s.getOutputStream())){
                		String pas, gas;
                		
                		//Mostramos las parejas desordenadas
                		dout.writeBytes(p.SinEmparejar());
                		dout.writeBytes("Propon una pareja de la forma: Pueblo\nGentilicio\n");
                		dout.flush();
                		
                		//Leemos la pareja aspirante
                		pas = din.readLine();
                		gas = din.readLine();
                		
                		//Vemos si la pareja es correcto
                		if(p.ParejaCorrecta(pas, gas)) {
                			dout.writeBytes("Pareja correcta\n");
                			dout.writeBytes(p.Emparejados());
                		}else {
                			dout.writeBytes("Pareja de " + pas + ", " + gas + " incorrecta \n");
                		}
                		dout.flush();
                		
                		
                	}
                }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
