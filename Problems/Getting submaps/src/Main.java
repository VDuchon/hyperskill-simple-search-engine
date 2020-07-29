import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();
        int lines = scanner.nextInt();
        scanner.nextLine();

        SortedMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String[] line = scanner.nextLine().split("\\s");
            map.put(Integer.parseInt(line[0]), line[1]);
        }

        map.subMap(start, end + 1).forEach((key, value) -> System.out.println(key + " " + value));

    }
}