package generics;

import java.util.Arrays;
import java.util.List;

public class Main {

    public Main() {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
        System.out.println(test1(src1));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");
        System.out.println(test2(src2));
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = new Selector<Integer>() {
            @Override
            public boolean select(Integer integer) {
                return integer < 10;
            }
        };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */


        Mapper<Integer, Integer> mapper = new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer integer) {
                return integer + 10;
            }
        };

        return ListCreator.<Integer, Integer>collectFrom(src).when(sel).mapEvery(mapper);
    }

    public List<Integer> test2(List<String> src) {

        Selector<String> sel = new Selector<String>() {
            @Override
            public boolean select(String string) {
                return string.length() > 3;
            }
        };

        Mapper<String, Integer> map = new Mapper<String, Integer>() {
            @Override
            public Integer map(String string) {
                return string.length() + 10;
            }
        };

        return ListCreator.<String, Integer>collectFrom(src).when(sel).mapEvery(map);
    }


    public static void main(String[] args) {
        new Main();
    }
}
