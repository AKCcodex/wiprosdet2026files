package ass3;

public class largerow {
	public static void main(String[] args) {
        int[][] arr = {
            {3, 5, 1},
            {7, 2, 9},
            {4, 8, 6}
        };
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i][0]; 
        for (int j = 1; j < arr[i].length; j++) {
              if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println("Largest in row " + i + " = " + max);
        }
    }
}
