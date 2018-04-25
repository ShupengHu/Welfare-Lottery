package computation;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculateCombination {
    private static ArrayList<Integer> redBallCombination = new ArrayList<>();
    private static int combinationsNo;
    private static ArrayList<int[]> combinations=new ArrayList<>();
    private static int[] combination;
    /**
     * 计算组合总数
     * C(n,m)=A(n,m)/m!   ；    A(n,m)＝＝n!/(n-m)!  ;   C(n,m)=n!/(n-m)! * m!
     * @param selectedNo 被选的红色球个数
     * @param redBallsNo 红色球总数
     */
    public static int calculatedCombinationsNo(int selectedNo, int redBallsNo){
        int a=calculatedFactorial(redBallsNo);
        int b=calculatedFactorial(redBallsNo-selectedNo);
        int c=calculatedFactorial(selectedNo);
        combinationsNo=a/b/c;
        return combinationsNo;
    }

    /**
     * 计算阶乘 number!
     * @param number
     * @return
     */
    public static int calculatedFactorial(int number){
        if(number==1){
        return number;
    }
        return number*calculatedFactorial(number-1);
    }

    /**
     * 列出所有可能的组合
     * @param index 红色球数组中的元素位置
     * @param selectedNo 被选的红色球个数
     * @param redBalls 红色球数组
     */
    public static void combine(int index,int selectedNo,int[] redBalls) {
        if(selectedNo >redBalls.length || redBalls.length <= 0){
            return ;
        }
        if(selectedNo== 1){
            for (int i = index; i < redBalls.length; i++) {
                redBallCombination.add(redBalls[i]);
                //存储本次组合数据
                combination=new int[redBallCombination.size()];
                for(int j=0; j<redBallCombination.size();j++){
                    combination[j] = redBallCombination.get(j);
                }
                combinations.add(combination);
                //删除本次组合，为下一个组合做准备
                redBallCombination.remove((Object)redBalls[i]);
            }
        }else if(selectedNo > 1){
            for (int i = index; i <= redBalls.length - selectedNo; i++) {
                redBallCombination.add(redBalls[i]);
                combine(i + 1,selectedNo - 1, redBalls);
                redBallCombination.remove((Object)redBalls[i]);
            }
        }else{
            return ;
        }
    }

    public static ArrayList<int[]> getCombinations(){
        return combinations;
    }
}
