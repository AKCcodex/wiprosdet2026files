package day8;
import java.util.*;
class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;}
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);}
    public int hashCode() {
        return Objects.hash(title, author); }}
public class Library {
    public static void main(String[] args) {

        Map<Book, Boolean> library = new HashMap<>();

        Book b1 = new Book("Java Basics", "James");
        Book b2 = new Book("Data Structures", "Mark");

        library.put(b1, true);
        library.put(b2, false);

        for (Map.Entry<Book, Boolean> entry : library.entrySet()) {
            Book b = entry.getKey();
            System.out.println(b.title + " by " + b.author +
                    " → " + (entry.getValue() ? "Available" : "Not Available"));
        }
    }
}