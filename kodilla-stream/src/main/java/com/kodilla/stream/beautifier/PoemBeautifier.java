package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public static void getBeauty(String String) {
        System.out.println("+_-" + String + "-_+");
    }

    public void beautify(String inscription, PoemDecorator poemDecorator) {
        poemDecorator.decorate(inscription);
    }
}
