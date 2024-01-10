import java.net.*;
import java.io.*;

class UDPC{
    public static void main(String [] args)throws Exception{
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getByName("Localhost");
        byte[] sendata = new byte[1024];
        byte[] recivedata = new byte[1024];

        System.out.println("Enter the line in uppercase to recive lowercase from server");
        String  sentence = inFromUser.readLine();
        sendata = sentence.getBytes();
        DatagramPacket sendpacket = new DatagramPacket(sendata,sendata.length,ipAddress,9870);
        clientSocket.send(sendpacket);

        DatagramPacket recivepacket = new DatagramPacket(recivedata,recivedata.length);
        clientSocket.receive(recivepacket);
        String modified_sentence = new String(recivepacket.getData());
        System.out.println("From Server : "+modified_sentence);

        clientSocket.close();
    }
}