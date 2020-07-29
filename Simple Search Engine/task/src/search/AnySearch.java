package search;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AnySearch implements SearchStrategy {

    @Override
    public void search(String query, Contacts contacts) {
        Set<Integer> linesFound = new HashSet<>();
        for (String queryWord : query.split("\\s+")) {
            linesFound.addAll(contacts.getInvertedIndex().getOrDefault(queryWord, Collections.emptySet()));
        }
        printFoundContacts(linesFound, contacts);
    }
}
