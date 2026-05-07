package day5;


final class Encryption {

    public int encrypt(int key) {
        int reversed = 0;

        while (key != 0) {
            int digit = key % 10;
            reversed = reversed * 10 + digit;
            key = key / 10;
        }

        System.out.println("Encrypted key: " + reversed);
        return reversed;
    }

    public int decrypt(int key) {
        int original = 0;

        while (key != 0) {
            int digit = key % 10;
            original = original * 10 + digit;
            key = key / 10;
        }

        System.out.println("Decrypted key: " + original);
        return original;
    }
}



public class encription {
    public static void main(String[] args) {
        Encryption obj = new Encryption();

        int encrypted = obj.encrypt(12345);
        obj.decrypt(encrypted);
    }
}