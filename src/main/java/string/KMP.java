package string;

public class KMP {
    
    public int kmp(String s, String pattern) {
        int[] nextArray = getNextArray(pattern);
        int i = 0, j = 0,index;
        while (i < s.length()) {
            if(j==pattern.length()){
                return i;
            }
            while(){

            }
        }
        return -1;
    }

    private int[] getNextArray(String pattern) {

    }

    public static void main(String[] args) {
        System.out.println(new KMP().kmp("asssddfdf", "ddfd"));
    }
}
