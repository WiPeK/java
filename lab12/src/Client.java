import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        Runnable cl = () -> {
            try {
                DatagramSocket ds = new DatagramSocket();
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                while(true) {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter a string");
                    String msg = in.nextLine();
                    DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, 1234);
                    ds.send(dp);
                    if(msg.equals("exit")) {
                        ds.close();
                        break;
                    }
                }
                ds.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable ser = () -> {
            try {
                DatagramSocket ds = new DatagramSocket(1235);
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, 1024);
                while(true) {
                    ds.receive(dp);
                    String str = new String(dp.getData(), 0, dp.getLength());
                    if(str.equals("exit")) {
                        ds.close();
                        break;
                    }
                    System.out.println(str);
                }
                ds.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(ser).start();
        new Thread(cl).start();
    }
}
