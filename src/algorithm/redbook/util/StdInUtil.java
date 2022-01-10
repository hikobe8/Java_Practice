package algorithm.redbook.util;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class StdInUtil {

    /**
     * 反射设置{@link edu.princeton.cs.algs4.StdIn}的 Scanner，便捷的在代码中设置输入源
     * @param fileName 文件名
     */
    public static void setInput(String fileName) {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(fileName));
            Class<StdIn> stdInClass = StdIn.class;
            Field declaredField = stdInClass.getDeclaredField("scanner");
            declaredField.setAccessible(true);
            declaredField.set(null, scanner);
        } catch (FileNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            StdOut.println("设置输入源失败!");
            e.printStackTrace();
        }

    }

}
