package algorithm.redbook.homework.hello;

import algorithm.redbook.util.StdInUtil;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        int i = 1;
        String champion = null;
        StdInUtil.setInput("animal.txt");
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / i)) {
                champion = str;
            }
            i++;
        }
        StdOut.println(champion);
    }

}
