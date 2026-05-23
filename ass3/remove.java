package ass3;

public class remove {
	public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int n = arr.length;

        System.out.println("Array after removing duplicates:");

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
