import java.io.*;
import java.net.*;

public class TCPS {
    public static void main(String[] args)throws Exception{
        ServerSocket sersocket = new ServerSocket(4000);
        System.out.println("Server is established");
        Socket socket = sersocket.accept();
        System.out.println("server is waiting for client request");

        InputStream istream = socket.getInputStream();
        BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
        String fname = fileread.readLine();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));

        OutputStream ostream  = socket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);

        String str;
        while((str = contentread.readLine()) != null){
            pwrite.println(str);
        }

        contentread.close();
        sersocket.close();
        socket.close();
    }
}
