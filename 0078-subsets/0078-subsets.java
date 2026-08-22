class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(new ArrayList<>(), nums, 0, ans);
        return ans; 
    }

    static void helper(List<Integer> current, int[] nums, int index, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<> (current));
            return;
        }
        current.add(nums[index]);
        helper(current, nums, index+1, ans);

        current.remove(current.size() -1);

        helper(current,nums,index+1,ans);
    }
}