package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Wit", "Bartek", "Karola", "Maja");
        List<Integer> ages = Arrays.asList(1, 4, 10, 12);

        names.get(0).toLowerCase();




        names.stream()
                .filter(string -> string.length() > 4)
                .map(string -> string + "!")
                .map(String::toLowerCase)
                .forEach(System.out::println);



        List<String> longerNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 4) {
                longerNames.add(name);
            }
        }

        List<String> modifiedStrings = new ArrayList<>();
        for (String longerName : longerNames) {
            modifiedStrings.add(longerName + "!");
        }


        List<String> lowercaseStrings = new ArrayList<>();
        for (String modifiedString : modifiedStrings) {
            lowercaseStrings.add(modifiedString.toLowerCase());
        }

//        for(String lowercaseString :lowercaseStrings){
//            System.out.println(lowercaseString);
//        }


        MyFirstStringConsumer myFirstStringConsumer = new MyFirstStringConsumer();
        MySecondStringConsumer mySecondStringConsumer = new MySecondStringConsumer();

        //consumeAllStrings(names, stringWitka -> System.out.println(stringWitka.toLowerCase()));
    }


    public static void consumeAllStrings(List<String> strings, StringConsumer stringConsumer) {
        for (String string : strings) {
            stringConsumer.consumeString(string);
        }
    }
}
