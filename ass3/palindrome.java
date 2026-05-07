package ass3;

public class palindrome {
	 public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 2, 1};
	        boolean isPalindrome = true;
	        for (int i = 0; i < arr.length / 2; i++) {
	            if (arr[i] != arr[arr.length - 1 - i]) {
	                isPalindrome = false;
	                break;
	            }
	        }

	        if (isPalindrome) {
	            System.out.println("Array is Palindrome");
	        } else {
	            System.out.println("Array is Not Palindrome");
	        }
	    }
}
