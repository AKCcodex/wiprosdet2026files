package assday6;

public class isadigit {
	public static void main(String[] args) {
        char ch = '5';

        if (Character.isDigit(ch)) {
            System.out.println("It is a digit");
        } else {
            System.out.println("Not a digit");
        }
    }
}
