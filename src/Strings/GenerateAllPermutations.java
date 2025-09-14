package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutations {
    public static void main(String[] args) {
        String str = "KYLE";

        System.out.println(permuatations(str));
    }

    static List<String> permuatations(String str) {
        List<String> res = new ArrayList<>();
        permuationsHelper(str, res, 0, new ArrayList<>());
        return res;
    }

    static void permuationsHelper(String str, List<String> res, int i, List<Character> sb) {
        if (i == str.length()) {
            StringBuilder p = new StringBuilder();
            for (char ch : sb) {
                p.append(ch);
            }
            res.add(p.toString());
            return;
        }

        char ch = str.charAt(i);

        for (int pos = 0; pos <= sb.size(); pos++) {
            sb.add(pos, ch);
            permuationsHelper(str, res, i + 1, sb);
            sb.remove(pos);
        }
    }
}
