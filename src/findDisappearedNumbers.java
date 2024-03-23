import java.util.*;

public class findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0) continue;
            nums[idx] *=-1;
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result1 = findDisappearedNumbers(nums1);
        System.out.println("Disappeared numbers in nums1: " + result1);

        int[] nums2 = {1, 1, 2, 2, 3, 3, 4, 4};
        List<Integer> result2 = findDisappearedNumbers(nums2);
        System.out.println("Disappeared numbers in nums2: " + result2);
    }
}
