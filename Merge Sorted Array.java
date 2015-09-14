/** Merge Sorted Array **/
/*======================================================================================
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
======================================================================================*/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int i=m-1;
        int j=n-1;
        int cur = m+n-1;
        while(j>=0 && i>=0){
            if(nums1[i]>nums2[j]){
                nums1[cur]=nums1[i];
                i--;
                cur--;
            }
            else{
                nums1[cur] = nums2[j];
                j--;
                cur--;
            }
        }
        
        while(j>=0){
            nums1[cur] = nums2[j];
            j--;
            cur--;
        }
        
        return;
    }
}