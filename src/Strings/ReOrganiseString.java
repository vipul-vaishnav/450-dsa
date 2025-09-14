package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganiseString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }

    static String reorganizeString(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        int strLen = s.length();
        int limit = (strLen + 1) / 2;
        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() > limit) return "EMPTY";
            pq.offer(new Tuple(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int size = pq.size();
            if (size >= 2) {
                Tuple a = pq.poll();
                Tuple b = pq.poll();

                sb.append(a.ch);
                assert b != null;
                sb.append(b.ch);

                if (a.freq - 1 > 0) {
                    pq.offer(new Tuple(a.ch, a.freq - 1));
                }

                if (b.freq - 1 > 0) {
                    pq.offer(new Tuple(b.ch, b.freq - 1));
                }
            } else {
                Tuple a = pq.poll();

                if (a.freq > 1) return "EMPTY";
                sb.append(a.ch);
            }
        }


        return sb.toString();
    }

    static class Tuple {
        char ch;
        int freq;

        Tuple(char _ch, int _freq) {
            this.ch = _ch;
            this.freq = _freq;
        }
    }
}
