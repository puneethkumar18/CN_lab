import java.net.*;


class UDPS{
    public static void main(String [] args)throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(9870);
        System.out.println("Server is ready for connection");
        byte[] sendata = new byte[1024];
        byte[] recivedata = new byte[1024];
        while(true){
            DatagramPacket  recivePacket = new DatagramPacket(recivedata, recivedata.length);
            serverSocket.receive(recivePacket);
            String sentence = new String(recivePacket.getData());
            System.out.println("SERVER:RECIVED FROM CLIENT IS "+sentence);
            
            InetAddress IPAddress = recivePacket.getAddress();
            int port = recivePacket.getPort();
            String modifiedSentence = sentence.toUpperCase();
            sendata = modifiedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendata,sendata.length,IPAddress, port);
            serverSocket.send(sendPacket);


            serverSocket.close();
        }
    }
}