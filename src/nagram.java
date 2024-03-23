import java.util.Arrays;
import java.util.Scanner;

public class nagram {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String s1= s.next();
        String s2= s.next();
        s1=s1.toUpperCase();
        s2=s2.toUpperCase();
        char[] arr1=s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr2);
        String res1=new String(arr1);
        String res2=new String(arr2);
        if (res1.equals(res2)){
            System.out.println("1");
        }
        else System.out.println("0");
    }
}
