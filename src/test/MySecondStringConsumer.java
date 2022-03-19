package test;

public class MySecondStringConsumer implements StringConsumer{

    @Override
    public void consumeString(String string) {
        string = string + " ???";
        System.out.println(string);
    }
}
