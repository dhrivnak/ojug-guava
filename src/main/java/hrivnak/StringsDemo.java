package hrivnak;

import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class StringsDemo {
    public static void main(String[] args) {
        caseFormat();
        joiner();
        splitter();
    }

    private static void caseFormat() {
        // I've never used these but they seemed like they could be handy some day
        String ourString = "ourStringIsPrettyCool";
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_CAMEL, ourString));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, ourString));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, ourString));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, ourString));
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, ourString));
    }

    private static void joiner() {
        List<String> words = Lists.newArrayList("here", "are", "some", null, "words", "to", "join");

        Joiner joiner = Joiner.on(", ").skipNulls();
        System.out.println(joiner.join(words));

        joiner = Joiner.on(" : ").useForNull("missing");
        System.out.println(joiner.join(words));
    }

    private static void splitter() {
        String splitMe = "splitters, are; ; ; , , ,,;,--... pretty - flexible -- don't you.think         ";
        Iterable<String> split = Splitter.on(CharMatcher.anyOf(";,.-")).trimResults().omitEmptyStrings().split(splitMe);
        Utils.printCollection("split:", split);
    }
}
