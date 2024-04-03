package LabExerciseHashMap;
import java.io.*;
import java.util.*;


public class BookReport {
    public static void main(String[] args) throws IOException {

        BookDA bookDA = new BookDA(new AuthorDA().getAuthorMap());
        HashMap<String, Book> bookMap = bookDA.readBooks();

        for (Map.Entry  <String, Book> entry : bookMap.entrySet()) {
            Book book = entry.getValue();
            Author author = book.getAuthor();
            System.out.println(book.getIsbn() + " " + book.getTitle() +
                    "\n\t" + author.getName() + " - " + author.getBio() + "\n" );
        }
    }
}
