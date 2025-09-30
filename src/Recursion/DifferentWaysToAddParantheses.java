package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParantheses {
    List<Integer> solve(String exp) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> lr = solve(exp.substring(0, i));
                List<Integer> rr = solve(exp.substring(i + 1));

                for (int x : lr) {
                    for (int y : rr) {
                        if (ch == '+') {
                            li.add(x + y);
                        } else if (ch == '-') {
                            li.add(x - y);
                        } else {
                            li.add(x * y);
                        }
                    }
                }

            }
        }
        if (li.isEmpty()) {
            li.add(Integer.parseInt(exp));
        }
        return li;
    }

    public List<Integer> diffWaysToCompute(String exp) {
        return solve(exp);
    }
}
