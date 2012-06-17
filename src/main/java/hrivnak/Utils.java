package hrivnak;

public class Utils {

    public static <T> void printCollection(String title, Iterable<T> iterable) {
        System.out.println(title);
        for (T element : iterable) {
            System.out.println("\t" + element);
        }
    }
}
