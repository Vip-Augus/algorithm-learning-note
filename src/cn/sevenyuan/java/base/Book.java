package cn.sevenyuan.java.base;

import lombok.Data;
import lombok.ToString;

/**
 * @author JingQ at 2020/3/27
 */
@Data
@ToString
public class Book {

    private static Integer number;

    static {
        number = 1;
        System.out.println("In book static block!");
    }

    public Book() {
        System.out.println("I'm a book");
    }
}
