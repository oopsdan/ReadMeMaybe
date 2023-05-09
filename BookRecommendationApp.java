package oopsdan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BookRecommendationApp {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic Literature", 1925));
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", "Classic Literature", 1960));
        bookList.add(new Book("1984", "George Orwell", "Dystopian Fiction", 1949));
        bookList.add(new Book("The Hunger Games", "Suzanne Collins", "Young Adult Fiction", 2008));
        bookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Classic Literature", 1951));
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", "Romantic Fiction", 1813));
        bookList.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", "Classic Literature", 1890));
        bookList.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy Fiction", 1937));
        bookList.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy Fiction", 1954));
        bookList.add(new Book("The Da Vinci Code", "Dan Brown", "Mystery Fiction", 2003));
        bookList.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "Mystery Fiction", 2005));
        bookList.add(new Book("The Stand", "Stephen King", "Horror Fiction", 1978));
        bookList.add(new Book("Dracula", "Bram Stoker", "Horror Fiction", 1897));
        bookList.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy Fiction", 1997));
        bookList.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery Fiction", 1892));
        bookList.add(new Book("The Cat in the Hat", "Dr. Seuss", "Children's Fiction", 1957));
        bookList.add(new Book("The Giving Tree", "Shel Silverstein", "Children's Fiction", 1964));
        bookList.add(new Book("Charlotte's Web", "E.B. White", "Children's Fiction", 1952));
        bookList.add(new Book("The Outsiders", "S.E. Hinton", "Young Adult Fiction", 1967));
        bookList.add(new Book("The Fault in Our Stars", "John Green", "Young Adult Fiction", 2012));
        bookList.add(new Book("Animal Farm", "George Orwell", "Political Fiction", 1945));
        bookList.add(new Book("Brave New World", "Aldous Huxley", "Dystopian Fiction", 1932));
        bookList.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", 1979));
        bookList.add(new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian Fiction", 1953));
        bookList.add(new Book("Wuthering Heights", "Emily Bronte", "Romantic Fiction", 1847));
        bookList.add(new Book("The Count of Monte Cristo", "Alexandre Dumas", "Adventure Fiction", 1844));

        Set<String> genres = new HashSet<>();
        for (Book book : bookList) {
            genres.add(book.getGenre());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ReadMeMaybe!\n");

        System.out.println("Available genres: " + genres + "\n");

        String selectedGenre = "";
        ArrayList<Book> booksInGenre = new ArrayList<>();
        while (booksInGenre.isEmpty()) {
            System.out.print("Enter a genre to get book recommendations (or type 'exit' to quit): ");
            selectedGenre = scanner.nextLine();

            if (selectedGenre.equalsIgnoreCase("exit")) {
                System.out.println("\nThank you for using ReadMeMaybe!");
                scanner.close();
                return;
            }

            for (Book book : bookList) {
                if (book.getGenre().equalsIgnoreCase(selectedGenre)) {
                    booksInGenre.add(book);
                }
            }

            if (booksInGenre.isEmpty()) {
                System.out.println("\nNo books found in the selected genre. Please try again.\n");
            }
        }

        System.out.println("\nWe recommend the following books in the " + selectedGenre + " genre:\n");

        Random random = new Random();
        int maxRecommendations = Math.min(booksInGenre.size(), 3);
        for (int i = 0; i < maxRecommendations; i++) {
            int randomIndex = random.nextInt(booksInGenre.size());
            Book recommendedBook = booksInGenre.get(randomIndex);
            System.out.println((i+1) + ") " + recommendedBook.getTitle() + " by " + recommendedBook.getAuthor() + "\n");
            booksInGenre.remove(randomIndex);
        }

        System.out.println("Thank you for using ReadMeMaybe!");
        scanner.close();
    }
}