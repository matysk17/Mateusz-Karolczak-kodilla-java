package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {


        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifulText = poemBeautifier.beautify("Text to beautify", (text -> text.toUpperCase()));
        System.out.println(beautifulText);

        String beautifulText2 = poemBeautifier.beautify("Text to beautify", (text -> "ABC" + text + "ABC"));
        System.out.println(beautifulText2);

        String beautifulText3 = poemBeautifier.beautify("Text to beautify", (text -> text.replace(" ", "*")));
        System.out.println(beautifulText3);

        String beautifulText4 = poemBeautifier.beautify("Text to beautify", (text -> text.length() + " letters ***" + text + "*** " + text.length() + " letters"));
        System.out.println(beautifulText4);

        String beautifulText5 = poemBeautifier.beautify("Text to beautify", (text -> text.concat(String.valueOf(text.hashCode()))));
        System.out.println(beautifulText5);

    }
}