package computation;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculateCombination {
    private static ArrayList<Integer> redBallCombination = new ArrayList<>();
    private static int combinationsNo;
    private static ArrayList<int[]> combinations=new ArrayList<>();
    private static int[] combination;
    /**
     * �����������
     * C(n,m)=A(n,m)/m!   ��    A(n,m)����n!/(n-m)!  ;   C(n,m)=n!/(n-m)! * m!
     * @param selectedNo ��ѡ�ĺ�ɫ�����
     * @param redBallsNo ��ɫ������
     */
    public static int calculatedCombinationsNo(int selectedNo, int redBallsNo){
        int a=calculatedFactorial(redBallsNo);
        int b=calculatedFactorial(redBallsNo-selectedNo);
        int c=calculatedFactorial(selectedNo);
        combinationsNo=a/b/c;
        return combinationsNo;
    }

    /**
     * ����׳� number!
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
     * �г����п��ܵ����
     * @param index ��ɫ�������е�Ԫ��λ��
     * @param selectedNo ��ѡ�ĺ�ɫ�����
     * @param redBalls ��ɫ������
     */
    public static void combine(int index,int selectedNo,int[] redBalls) {
        if(selectedNo >redBalls.length || redBalls.length <= 0){
            return ;
        }
        if(selectedNo== 1){
            for (int i = index; i < redBalls.length; i++) {
                redBallCombination.add(redBalls[i]);
                //�洢�����������
                combination=new int[redBallCombination.size()];
                for(int j=0; j<redBallCombination.size();j++){
                    combination[j] = redBallCombination.get(j);
                }
                combinations.add(combination);
                //ɾ��������ϣ�Ϊ��һ�������׼��
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
