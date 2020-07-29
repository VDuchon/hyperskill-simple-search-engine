package search;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NoneSearch implements SearchStrategy {

    @Override
    public void search(String query, Contacts contacts) {
        Set<Integer> linesFound = new HashSet<>();
        for (int i = 0; i < contacts.getContacts().size(); i++) {
            linesFound.add(i);
        }
        for (String queryWord : query.split("\\s+")) {
            linesFound.removeAll(contacts.getInvertedIndex().getOrDefault(queryWord, Collections.emptySet()));
        }
        printFoundContacts(linesFound, contacts);
    }
}
