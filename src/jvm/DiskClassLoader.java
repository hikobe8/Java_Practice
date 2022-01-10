package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 */
public class DiskClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classFileBytes = getClassFileBytes();
        return defineClass(name, classFileBytes, 0, classFileBytes.length);
    }

    private byte[] getClassFileBytes() {
        File file = new File("HelloClass.class");
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            int len = -1;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }

    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader();
        try {
            Class<?> helloClass = diskClassLoader.loadClass("com.hikobe8.test.HelloClass");
            Method hello = helloClass.getMethod("hello", null);
            hello.invoke(helloClass.newInstance(), null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
