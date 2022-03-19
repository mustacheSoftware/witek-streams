package test;

public class MyFirstStringConsumer implements StringConsumer{

    @Override
    public void consumeString(String string) {
        string = string + " !";
        System.out.println(string);
    }
}
