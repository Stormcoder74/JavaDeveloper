package l31.generics.bound;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "unused"})
public class Wildcard {
    public static void main(String[] args) {
        new Wildcard().run();
    }

    private void run() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);

        //printListOld(list);

        printList(list);
    }

    private void bounds() {
        Integer a = 3;
        Number b = a;

        List<Integer> aL = new ArrayList<>();
        List<? extends Number> bL = aL;
    }

    private void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        //list.add(new Object()); // error
    }

    private void printListOld(List list) {
        list.forEach(System.out::println);
        list.add(new Object());
        list.add(2);
    }
}
