import java.util.ArrayList;
import java.util.Scanner;
class Book {
    int id;
    String title;
    String author;
    Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
    void displayBook(){
        System.out.println("Book ID : " + id);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("---------------------");
    }
}
public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addBook(){
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.println("Enter Author Name: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book Added Successfully!");
    }
    public static void displayBooks(){
        if(books.isEmpty()){
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n==== Book List ====");
        for(Book b : books){
            b.displayBook();
        }
    }
    public static void searchBook(){
        sc.nextLine();
        System.out.println("Enter book title to search: ");
        String searchTitle = sc.nextLine();
        boolean found = false;
        for(Book b : books){
            if(b.title.equalsIgnoreCase(searchTitle)){
                System.out.println("Book Found: ");
                b.displayBook();
                found = true;
            }
        }
        if(!found){
            System.out.println("Book not found.");
        }
    }
    public static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int removeId = sc.nextInt();
        boolean removed = false;
        for(Book b : books){
            if(b.id == removeId){
                books.remove(b);
                System.out.println("Book Removed Successfully!");
                removed = true;
                break;
            }
        }
        if(!removed){
            System.out.println("Book not found.");
        }
    }
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Books");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1 :
                    addBook();
                    break;
                case 2 :
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    System.out.println("Exiting Library System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while(choice != 5);
        sc.close();
    }
}
