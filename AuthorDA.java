package LabExerciseHashMap;
import java.io.*;
import java.util.*;
public class AuthorDA {
    private HashMap<String, Author> authorMap;

    public AuthorDA() throws FileNotFoundException {
        this.authorMap = loadAuthors();
    }
    public HashMap<String, Author> getAuthorMap() {
        return authorMap;
    }
    private HashMap<String, Author> loadAuthors() throws FileNotFoundException {
        HashMap<String, Author> authors = new HashMap<>();
        Scanner input = new Scanner(new FileReader("C:\\Users\\Josh\\IdeaProjects\\JoshSpace\\src\\LabExerciseHashMap\\Author.csv"));
        while (input.hasNext()) {
            String i = input.nextLine();
            String[] data = i.split(",");
            if (data.length == 2) {
                String name = data[0].trim();
                String bio = data[1].trim();
                authors.put(name, new Author(name, bio));
            }
        }
        return authors;
    }
}
