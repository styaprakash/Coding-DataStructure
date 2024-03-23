import java.util.Scanner;

public class subarray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //size of the subARRAY
        System.out.println("size of the subARRAY: ");
        int x=s.nextInt();
        //size of the ARRAY
        System.out.println("size of the ARRAY");
        int n= s.nextInt();
        int[] arr=new int[n];
        //inserting elements in the array
        System.out.println("inserting elements in the array");
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n-x;i++){
            min=Integer.MAX_VALUE;
            for (int j=0;j<(x+i);j++){
                min=Math.min(min,arr[i]);
            }
            max=Math.max(min,max);
        }
        System.out.println("The maximum of the minimum is: "+max);
    }
}
