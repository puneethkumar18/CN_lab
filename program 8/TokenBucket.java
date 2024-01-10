import java.util.*;

public class TokenBucket{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int token_remaining = 0;
        int token_sent, token_requested;
        System.out.println("Enter the bucket capacity :");
        int bucket_capacity = in.nextInt();
        System.out.println("Enter the generation rate(rate at which computer sends token to bucket)");
        int token_gen_rate = in.nextInt();

       
        System.out.println("Enter the number of cycles that host sends token");
        int n = in.nextInt();
        System.out.println(String.format("%s\t%s\t%s\t%s", "Time t","token_requested","token_sent","token_remaining"));

        for(int i=0;i<n;i++){
            token_requested = token_gen_rate;
            if(token_requested+token_remaining > bucket_capacity){
                token_sent = bucket_capacity - token_remaining;
                token_remaining = bucket_capacity;
            }else{
                token_sent = token_gen_rate;
                token_remaining += token_sent;
            }

            System.out.println(String.format("%d\t\t%d\t\t%d\t\t%d", i+1,token_requested,token_sent,token_remaining));

        }
        in.close();
    }
}