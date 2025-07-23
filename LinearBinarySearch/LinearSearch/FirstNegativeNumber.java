package linearSearch;

public class FirstNegativeNumber {

	public static void main(String[] args) {
		int[] nums = {1,2,5,9,-5,3};
		int gotIndex = findIndex(nums);
		
		System.out.println(gotIndex);
	}
	
	public static int findIndex(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i]<0) {
				return i;
			}
		}
		return -1;
	}

}