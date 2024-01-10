import java.util.*;

public class CRC {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("At Sender side");

        System.out.println("Enter the message in bits");
        String message = sc.nextLine();
        System.out.println("Enter the generator");
        String generator = sc.nextLine();

        int data[] = new int[message.length()+generator.length()-1];
        int divisor[] = new int[generator.length()];

        for(int i = 0;i<message.length();i++)
            data[i] = Integer.parseInt(message.charAt(i)+"");

        for(int j= 0;j<generator.length();j++){
            divisor[j] = Integer.parseInt(generator.charAt(j)+"");
        }

        for(int i = 0;i < message.length();i++){
            if(data[i] == 1){
                for(int j = 0; j < divisor.length;j++){
                    data[i+j] ^= divisor[j];
                }
            }
        }
        for(int i = 0;i<message.length();i++)
            data[i] = Integer.parseInt(message.charAt(i)+"");


        System.out.println("The Chucksum Code");
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
        }

        System.out.println();

        System.out.println("At Reciver Side");

        System.out.println("Enter the ChuckSum Code");
        message = sc.nextLine();
        System.out.println("Enter the generoator");
        generator = sc.nextLine();

        data = new int[message.length()+generator.length()-1];
        divisor = new int[generator.length()];

        for(int i=0;i<message.length();i++){
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        for(int i=0 ; i<generator.length();i++){
            divisor[i] = Integer.parseInt(message.charAt(i)+"");
        }

        for(int i = 0; i < message.length();i++){
            if(data[i] == 1){
                for(int j =  0;j<divisor.length;j++){
                    data[i+j] ^= divisor[j]; 
                }
            }
        }

        boolean valid = true;
        for(int i = 0;i<data.length;i++){
            if(data[i] == 1){
                valid = false;
                break;
            }
        }

        
        if(valid){
            System.out.println("Data Stream is valid");
        }else{
            System.out.println("Data Stream is invalid , CRC error occured");
        }


        sc.close();

    }
}