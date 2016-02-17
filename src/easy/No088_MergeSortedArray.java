package easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author lichenjie0522
 *
 */
public class No088_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m - 1, i2 = n - 1;
		int index = m + n - 1;
		while (i1 >= 0 && i2 >= 0) {
			if (nums1[i1] > nums2[i2]) {
				nums1[index--] = nums1[i1--];
			} else {
				nums1[index--] = nums2[i2--];
			}
		}
		while (i1 >= 0) {
			nums1[index--] = nums1[i1--];
		}
		while (i2 >= 0) {
			nums1[index--] = nums2[i2--];
		}
	}
}
