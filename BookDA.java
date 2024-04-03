package LabExerciseHashMap;
import java.io.*;
import java.util.*;
public class BookDA {
    private HashMap<String, Book> bookMap;
    private HashMap<String, Author> authorMap;

    public BookDA(HashMap<String, Author> authorMap) throws IOException {
        // Instantiate AuthorDA to access
        AuthorDA authorDA = new AuthorDA();
        this.authorMap = authorDA.getAuthorMap();
    }
    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }
    public void setBookMap(HashMap<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public HashMap<String, Book> readBooks() throws IOException {
        bookMap = new HashMap<>();
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Josh\\IdeaProjects\\JoshSpace\\src\\LabExerciseHashMap\\Book.csv"));
        String i;
        while ((i = input.readLine()) != null) {
            String[] data = i.split(",");
            if (data.length == 3) {
                String isbn = data[0].trim();
                String title = data[1].trim();
                String authorName = data[2].trim();

                Author author = authorMap.get(authorName);
                if (author == null) {
                    author = new Author(authorName, "");
                }

                Book book = new Book(isbn, title, author);
                bookMap.put(isbn, book);
            }
        }
        return bookMap;
    }
}
