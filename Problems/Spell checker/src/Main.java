import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dictionarySize = scanner.nextInt();
        scanner.nextLine();
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < dictionarySize; i++) {
            String word = scanner.nextLine().toLowerCase();
            dictionary.add(word);
        }

        int textSize = scanner.nextInt();
        scanner.nextLine();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < textSize; i++) {
            lines.add(scanner.nextLine().toLowerCase());
        }

        Set<String> erroneousWords = new HashSet<>();
        for (String line : lines) {
            for (String word : line.split(" ")) {
                if (!dictionary.contains(word)) {
                    erroneousWords.add(word);
                }
            }
        }

        for (String erroneous : erroneousWords) {
            System.out.println(erroneous);
        }
    }
}
