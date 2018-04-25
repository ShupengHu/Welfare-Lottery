public class Test {
    public static void main(String[] args){
        StringBuffer s=new StringBuffer("AkleBiCeilD");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                char a=s.charAt(i);
                s.deleteCharAt(i);
                s.append(a);
            }
        }
        System.out.println(s);
    }
}
