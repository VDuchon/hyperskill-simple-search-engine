package search;

import java.util.Set;

public interface SearchStrategy {
    void search(String query, Contacts contacts);
    default void printFoundContacts(Set<Integer> matchingLines, Contacts contacts) {
        if (!matchingLines.isEmpty()) {
            System.out.println("These are the found contacts:");
            for (Integer matchingLine : matchingLines) {
                System.out.println(contacts.getContacts().get(matchingLine));
            }
        } else {
            System.out.println("No such contact found");
        }
    }
}
