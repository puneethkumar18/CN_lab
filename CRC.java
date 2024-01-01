import java.util.Scanner;

public class CRC{
    public static String crc(String data, String poly,boolean errorChk){
        String rem  = data;

        if(!errorChk){
            for(int i=0;i<poly.length()-1;i++){
                rem += "0";
            }
        }
        for(int i=0;i<(rem.length()-poly.length())+1;i++){
            if(rem.charAt(i) == '1'){
            String temp = "";
            for(int j = 0;j<poly.length();j++){
                temp += (rem.charAt(i+j) == rem.charAt(j) ? '0':'1'); 
                }
                rem = rem.substring(0,i)+temp+rem.substring(i,poly.length());
            }
        }
        return rem.substring(rem.length()-poly.length()+1);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String data, poly;

        System.out.println("Enter the data to be Sent:");
        data = scanner.next();
        System.out.println("Enter the polynomial:");
        poly = scanner.next();

        String rem = crc(data,poly,false);
        String codeWord = rem + data;

        System.out.println("Remainder :"+rem);
        System.out.println("CodeWord :"+codeWord);

        String recvCodeword;
        System.out.println("Enter the recived codeword:");
        recvCodeword = scanner.next();

        String recrem = crc(recvCodeword,poly,true);

        if(Integer.parseint(recrem,2) == 0){
            System.out.println("No Error");
        }else{
            System.out.println("Error Occured");
        }
        scanner.close();
    }
}