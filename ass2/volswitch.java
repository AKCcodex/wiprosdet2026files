package ass2;
import java.util.Scanner;
public class volswitch {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("enter char");
	char ch=sc.next().charAt(0);
	sc.close();
	
	switch(ch) {
    case 'a':
    			System.out.print(ch+" is a vowel");
    				break;
    case 'e':
    	System.out.print(ch+" is a vowel");
		break;
    case 'i':
    	System.out.print(ch+" is a vowel");
		break;
    case 'o':
    	System.out.print(ch+" is a vowel");
		break;
    case 'u':
    	System.out.print(ch+" is a vowel");
		break;
    case 'A':
    	System.out.print(ch+" is a vowel");
		break;
    case 'E':
    	System.out.print(ch+" is a vowel");
		break;
    case 'I':
    	System.out.print(ch+" is a vowel");
		break;
    case 'O':
    	System.out.print(ch+" is a vowel");
		break;
    case 'U':
    	System.out.print(ch+" is a vowel");
		break;
    
        default: System.out.print(ch+" is a consonant");
}
}
}
