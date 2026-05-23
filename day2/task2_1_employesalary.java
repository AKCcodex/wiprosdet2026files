package day2;

public class task2_1_employesalary {
public static void main(String[] args) {
	int[][] arr= {{1,1234},{2,2000},{3,3000}};
	for(int i=0;i<arr.length;i++) {
		int salary=arr[i][1];
		arr[i][1]+=salary*0.1;
		System.out.println("employe "+arr[i][0]+"new salary is "+arr[i][1]);
	}
}
}
