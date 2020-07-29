package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Contacts {
    private List<String> contacts;
    private Map<String, Set<Integer>> invertedIndex;

    public Contacts(File file) throws FileNotFoundException {
        this.contacts = new ArrayList<>();
        readContactsFromFile(file);
        this.invertedIndex = createInvertedIndex();
    }

    private Map<String, Set<Integer>> createInvertedIndex() {
        Map<String, Set<Integer>> invertedIndex = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        int lineNum = 0;
        for (String contact : this.contacts) {
            for (String word : contact.split("\\s+")) {
                if (!invertedIndex.containsKey(word)) {
                    invertedIndex.put(word, new HashSet<>());
                }
                invertedIndex.get(word).add(lineNum);
            }
            lineNum++;
        }
        return invertedIndex;
    }

    private void readContactsFromFile(File file) throws FileNotFoundException {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                contacts.add(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    public List<String> getContacts() {
        return contacts;
    }

    public Map<String, Set<Integer>> getInvertedIndex() {
        return invertedIndex;
    }

    public void printContacts() {
        System.out.println("=== List of people ===");
        contacts.forEach(System.out::println);
    }

    public void printInvertedIndex() {
        invertedIndex.forEach((s, n) -> System.out.println(s + " -> " + n));
    }
}
