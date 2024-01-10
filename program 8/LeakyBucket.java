import java.util.*;

public class LeakyBucket {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int bucket_remaining = 0,recived,sent;
        System.out.println("Enter the Bucket capacity :");
        int bucket_capacity = scanner.nextInt();
        System.out.println("Enter the bucket rate ");
        int bucket_rate = scanner.nextInt();
        System.out.println("Enter the number of packets to be sent");
        int n = scanner.nextInt();
        int[] buf = new int[40];

        System.out.println("Enter the size of the ecah packet");
        for(int i=0;i<n;i++){
            System.out.println("size Of "+(i+1)+" packet");
            buf[i] = scanner.nextInt();
        }
        System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t", "Time_t","p_size","recived","sent","bucket_remaining"));
        for(int i=0;i<n;i++){
            if(buf[i] != 0){
                if(bucket_remaining+buf[i] > bucket_capacity){
                    recived = -1;
                }else{
                    recived = buf[i];
                    bucket_remaining += recived;
                }
            }else{
                recived = 0;
            }

            if(bucket_remaining != 0){
                if(bucket_remaining < bucket_rate ){
                    sent = bucket_remaining;
                    bucket_remaining = 0;
                }else{
                    sent = bucket_rate;
                    bucket_remaining = bucket_remaining-sent;
                }
            }else{
                sent = 0;
            }
            if(recived == -1){
                System.out.println(String.format("%d\t%d\t%s\t%d\t%d\t", i+1,buf[i],"dropped",sent,bucket_remaining));
            }else{
                System.out.println(String.format("%d\t%d\t%d\t%d\t%d\t", i+1,buf[i],recived,sent,bucket_remaining));
            }
        }
        scanner.close();
    }
}
