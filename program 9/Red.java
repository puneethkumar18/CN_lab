import java.util.*;

public class Red {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the maximun packets to be sent");
        int maxPackets = scanner.nextInt();
        System.out.println("Enter the maximun Queue size");
        int queueSize = scanner.nextInt();
        System.out.println("Enter the maximum probability");
        double maxprobability = scanner.nextDouble();
        System.out.println("Enter the minmum probability");
        double minprobability = scanner.nextDouble();
        System.out.println("Enter the threshold value");
        int threshold = scanner.nextInt();

        SimulateCongention(maxPackets,queueSize,maxprobability,minprobability,threshold);
        
        }

        public static void SimulateCongention(
            int maxPackets,int queueSize,double maxprobability, 
            double minprobability, int threshold
        ){
            Random random = new Random(System.currentTimeMillis());
            int queueLength = 0;
            for(int i=0;i<maxPackets;i++){
                double dropProbability = calculateDropProbabilty(queueLength,queueSize,maxprobability,minprobability,threshold);
                if(queueLength >= threshold && random.nextDouble()<dropProbability){
                    System.out.println("Packet dropped (CONGENTION AVOIDENCE)");
                }else{
                    System.out.println("Packet Accepted : "+(i+1));
                    queueLength++;
                }
            }
        }

        public static double calculateDropProbabilty(
            int currentQueueLength,
            int queueSize,
            double maxprobability,
            double minprobability,
            int threshold
            ){
                double slope = (maxprobability-minprobability)/(queueSize-threshold);
                return minprobability+slope+(currentQueueLength-threshold);
            }
    
}
