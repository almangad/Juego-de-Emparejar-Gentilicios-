package Alba_Mangado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) {
        try (Socket soc= new Socket("localhost", 55555);
             DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
             DataInputStream dis = new DataInputStream(soc.getInputStream())){
            String lin;

            while(dis.readBoolean()) {
                while((lin=dis.readLine())!=null) {
                    System.out.println(lin);
                }
                Scanner e1= new Scanner(System.in);
                dout.writeBytes(e1.nextLine() + "\n");
                dout.flush();
            }

            while((lin=dis.readLine())!=null) {
                System.out.println(lin);
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
    }
}