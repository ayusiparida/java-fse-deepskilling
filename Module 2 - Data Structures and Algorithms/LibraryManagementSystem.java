import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return bookId + " " + title + " " + author;
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = books[mid].title.compareToIgnoreCase(title);

            if (compare == 0)
                return books[mid];
            else if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "Java", "James"),
                new Book(2, "Python", "Guido"),
                new Book(3, "C", "Dennis"),
                new Book(4, "Data Structures", "Mark")
        };

        System.out.println(linearSearch(books, "Python"));

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println(binarySearch(books, "Python"));
    }
}