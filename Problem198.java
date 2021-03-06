/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
is that adjacent houses have security systems connected and it will automatically contact the 
police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.


Dynamic programic approach bottom up, choosing between current and i-2 or previous.
*/

class Problem198 {
	
	public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) 
            return Math.max(nums[0], nums[1]);
        
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i<money.length; i++) {
            money[i] = Math.max(nums[i] + money[i-2], money[i-1]);
        }
        return money[money.length-1];
    }
}

