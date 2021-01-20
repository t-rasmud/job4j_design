package ru.job4j.map;

import java.util.Objects;

public class BitOperation {
    private String ex1;
    private String ex2;

    public BitOperation(String ex1, String ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitOperation that = (BitOperation) o;
        return Objects.equals(ex1, that.ex1) &&
                Objects.equals(ex2, that.ex2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ex1, ex2);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("123 and 123 >>> 4:");
        System.out.println(binary(123));
        System.out.println(binary(123 >>> 4));
        System.out.println("255 and 255 >>> 4:");
        System.out.println(binary(255));
        System.out.println(binary(255 >>> 4));
        System.out.println("MAX_VALUE and MAX_VALUE >>> 16:");
        System.out.println(binary(Integer.MAX_VALUE));
        System.out.println(binary(Integer.MAX_VALUE >>> 16));

        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println("Object1 hashcode: " + o1.hashCode());
        System.out.println("Object2 hashcode: " + o2.hashCode());
        System.out.println("Object1 hashcode (Objects): " + Objects.hashCode(o1));
        System.out.println("Object2 hashcode (Objects): " + Objects.hashCode(o2));
        Object nullobj = null;
//        System.out.println("Null object hashcode: " + nullobj.hashCode()); // NULLPOINTEREXCEPTION
        System.out.println("Null object hashcode (Objects): " + Objects.hashCode(nullobj));
        System.out.println("Object1 hash (Objects): " + Objects.hash(o1));
        System.out.println("Object2 hash (Objects): " + Objects.hash(o2));
        BitOperation bo1 = new BitOperation("a", "b");
        BitOperation bo2 = new BitOperation("a", "b");
        System.out.println("bo1 hashcode: " + bo1.hashCode());
        System.out.println("bo2 hashcode: " + bo2.hashCode());
        System.out.println("bo1.equals(bo2): " + bo1.equals(bo2));
    }
}
