package hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note: You can assume that you can always reach the last index.
 * 
 * 主要是使用了一种Greedy的思想来求最小步数。
 * 
 * 首先我们设置不满足题意的corner case返回Integer.MAX_VALUE 接下来设置一个maxCover = 0， lastCover =
 * 0， steps = 0。
 * maxCover代表我们当前能够到达的最大距离，lastCover等于之前的maxCover，用来记录我们在Greedy情况下每一跳的最远范围。
 * 从0开始遍历数组，要注意条件是 i <= maxCover && i < nums.length 假如i >
 * lastCover，这时候说明我们已经超过了之前记录的maxCover的范围，这个时候我们必须要进行一次跳跃，所以steps++，
 * 并且我们更新lastCover = maxCover，即上一条之后，我们这一次最远可以跳到哪里 假如i + nums[i] > maxCover，
 * 这个时候我们更新maxCover = i + nums[i]，可以继续进行接下来的计算 当循环结束时，我们检测maxCover是否 >=
 * nums.length - 1 假如成立，则说明我们可以到达右边界，这时候返回steps 否则我们返回Integer.MIN_VALUE
 * 
 * @author lichenjie0522
 *
 */
public class No045_JumpGameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxCoverPos = 0, lastCoverPos = 0;
		int steps = 0;
		for (int i = 0; i < nums.length && i <= maxCoverPos; ++i) {
			if (lastCoverPos < i) {
				steps++;
				lastCoverPos = maxCoverPos;
			}
			if (maxCoverPos < i + nums[i]) {
				maxCoverPos = i + nums[i];
			}
		}
		return (maxCoverPos >= nums.length - 1) ? steps : Integer.MAX_VALUE;
	}
}
