import java.util.*;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;

    Book(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;

    DVD(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;

    Magazine(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];

            String title = parts[1].replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } 
            else if (type.equals("DVD")) {
                item = new DVD(title);
            } 
            else {
                item = new Magazine(title);
            }

            System.out.println(
                item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}
