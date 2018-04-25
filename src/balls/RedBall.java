package balls;

import java.util.ArrayList;

public class RedBall {
    private static int[] redBalls;

    public static void setRedBalls(int totalNo){
        redBalls=new int [totalNo];
        for(int i=0;i<totalNo;i++){
            redBalls[i]=i+1;
        }
    }
    public static void setSelectedRedBalls(ArrayList<Integer> selectedRedBall){
        redBalls=new int[selectedRedBall.size()];
        for (int i=0;i<selectedRedBall.size();i++){
            redBalls[i]=selectedRedBall.get(i);
        }
    }
    public static int[] getRedBalls(){
        return  redBalls;
    }
}
