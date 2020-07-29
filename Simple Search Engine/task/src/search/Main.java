package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Contacts contacts;
        if (args[0].equals("--data")) {
            String filename = args[1];
            try {
                contacts = new Contacts(new File(filename));
            } catch (FileNotFoundException e) {
                return;
            }
        } else {
            return;
        }
        boolean run = true;
        while (run) {
            printMenu();
            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    searchContacts(contacts);
                    break;
                case 2:
                    contacts.printContacts();
                    break;
                case 3:
                    contacts.printInvertedIndex();
                    break;
                case 0:
                    System.out.println("Bye!");
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    printMenu();
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Menu ===\n"
                + "1 - Find a person\n"
                + "2 - Print all people.\n"
                + "3 - Print inverted index\n"
                + "0 - Exit.");
    }

    private static void searchContacts(Contacts contacts) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        Searcher searcher = Searcher.getSearcher(getInputFromUser());
        System.out.println("Enter a name or email to search all suitable people:");
        searcher.search(getInputFromUser(), contacts);
    }

    private static String getInputFromUser() {
        return scanner.nextLine();
    }
}