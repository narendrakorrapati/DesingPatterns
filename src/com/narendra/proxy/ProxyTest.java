package com.narendra.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        BookParser parser = new EagerBookParser(new Book());

        System.out.println(parser.getLines());
        System.out.println(parser.getPages());

        parser = new LazyBookParser(new Book());
        System.out.println(parser.getLines());
        System.out.println(parser.getPages());
    }
}

class Book {
    String content = "abcd";

    String getContent() {
        return content;
    }
}

interface BookParser {
    int getPages();
    int getLines();
}

class EagerBookParser implements BookParser {

    int pages = 0;
    int lines = 0;
    EagerBookParser(Book book) {
        this.pages = 100;
        this.lines = 1000;
    }

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public int getLines() {
        return lines;
    }
}

class LazyBookParser implements BookParser {

    private Book book;
    private EagerBookParser eagerBookParser;

    LazyBookParser(Book book) {
        this.book = book;
    }


    @Override
    public int getPages() {

        if(eagerBookParser == null) {
            eagerBookParser = new EagerBookParser(book);
        }

        return eagerBookParser.getPages();
    }

    @Override
    public int getLines() {
        if(eagerBookParser == null) {
            eagerBookParser = new EagerBookParser(book);
        }

        return eagerBookParser.getLines();
    }
}
