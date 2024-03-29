public class Count_inversion {
    static  int countAndMerge(int[] arr, int l, int m,int r){
        int n1=m-l+1,n2=r-m;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for (int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for (int i=0;i<n2;i++){
            right[i]=arr[m+l+i];
        }
        int res=0,i=0,j=0,k=l;
        while (i<n1 && j<n2){
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }else {
                arr[k]=right[j];
                j++;
                res=res+(n1-i);
            }
            k++;
        }
        while (i<n1){arr[k]=left[i];i++;k++;}
        while (j<n2){arr[k]=right[j];j++;k++;}
        return res;
    }
    static int countInv(int[] arr,int l,int r){
        int res=0;
        if (l<r){
            int m=l+(r-l)/2;
            res+=countInv(arr, l, m);
            res+=countInv(arr,m+1,r);
            res=countAndMerge(arr,l,m,r);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array={5,3,2,4,1};
        System.out.println("Number of inversions: "+ countInv(array,0,array.length-1));
//        int[] array = {1, 20, 6, 4, 5}; // Example array
//        Count_inversion obj = new Count_inversion();
//        int inversions = obj.countInv(array, 0, array.length - 1);
//        System.out.println("Number of inversions: " + inversions);
    }
}
