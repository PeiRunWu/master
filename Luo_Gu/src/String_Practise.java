public class String_Practise {
    public static void main(String[] args) {
        int[] chars = {1,2,3,4};
        System.out.print("[");
        for(int i=0;i<chars.length;i++){
            if(i == chars.length-1){
                System.out.println("word"+chars[i]+"]");
            }else{
                System.out.print("word"+chars[i]+"#");
            }
        }
    }
}
