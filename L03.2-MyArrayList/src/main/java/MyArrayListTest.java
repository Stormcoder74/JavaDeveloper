import java.util.*;

public class MyArrayListTest {
    public static void main(String[] args) {

        Object[] string = {"xfg", "jfg", "abc", "abj"};
        Arrays.sort(string);
        System.out.println(Arrays.toString(string));

        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>(8);

        for (int i = 0; i < 6; i++) {
            integerMyArrayList.add(i);
            System.out.println(integerMyArrayList.size());
        }

        List<String> stringArrayList = new MyArrayList<>(25);
        stringArrayList.add("zero");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add(1, "oneIns");

        List<String> arrayList = new MyArrayList<>();
        arrayList.add("otherOne");
        arrayList.add("otherTwo");
        arrayList.add("otherThree");

        stringArrayList.addAll(arrayList);
        stringArrayList.addAll(3, arrayList);

        System.out.print(Arrays.toString(stringArrayList.toArray()));
        System.out.println();

        stringArrayList.remove(3);

        System.out.print(Arrays.toString(stringArrayList.toArray()));
        System.out.println();


        Collections.sort(stringArrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.compareTo(o2);
                return result;
            }
        });

        System.out.print(Arrays.toString(stringArrayList.toArray()));
        System.out.println();

        Collections.copy(stringArrayList, arrayList);

        System.out.print(Arrays.toString(stringArrayList.toArray()));
        System.out.println();
    }

}
