import java.io.*;
import java.net.*;







public class TCPC {
    public static void main(String [] args)throws Exception{
        Socket socket = new Socket("127.0.0.1",4000);
        System.out.println("Enter the file name");
        BufferedReader keyread  = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyread.readLine();


        OutputStream ostream = socket.getOutputStream();
        PrintWriter pWrite = new PrintWriter(ostream ,true);
        pWrite.println(fname);

        InputStream istream = socket.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        
        String str;
        while((str = socketRead.readLine()) != null){
            System.out.println(str);
        }
        socket.close();
    }
}
