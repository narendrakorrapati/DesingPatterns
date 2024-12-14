package com.narendra.bridge;

public class BridgeTest {

    public static void main(String[] args) {
        View longViewArtist = new LongView(new ArtistResource(new Artist()));
        View shortViewArtist = new ShortView(new ArtistResource(new Artist()));

        System.out.println(longViewArtist.show());
        System.out.println(shortViewArtist.show());

        View longViewBook = new LongView(new BookResource(new Book()));
        View shortViewBook = new ShortView(new BookResource(new Book()));

        System.out.println(longViewBook.show());
        System.out.println(shortViewBook.show());
    }
}

abstract class View {

    Resource resource;
    View(Resource resource) {
        this.resource = resource;
    }
    abstract String show();
}

class LongView extends View {

    LongView(Resource resource) {
        super(resource);
    }
    @Override
    String show() {
        return this.resource.getSnippet();
    }
}

class ShortView extends View {

    ShortView(Resource resource) {
        super(resource);
    }
    @Override
    String show() {
        return this.resource.getTitle();
    }
}

interface Resource {

    String getSnippet();
    String getTitle();
    String getImage();
}

class ArtistResource implements Resource{

    private Artist artist;
    ArtistResource(Artist artist) {
        this.artist = artist;

    }

    @Override
    public String getSnippet() {
        return artist.getBio();
    }

    @Override
    public String getTitle() {
        return artist.getName();
    }

    @Override
    public String getImage() {
        return artist.getImage();
    }
}

class BookResource implements Resource{

    private Book book;
    BookResource(Book book) {
        this.book = book;
    }

    @Override
    public String getSnippet() {
        return book.getCoverPage();
    }

    @Override
    public String getTitle() {
        return book.getName();
    }

    @Override
    public String getImage() {
        return book.getImage();
    }
}

class Artist {

    String getBio() {
        return "Artist bio";
    }

    String getName() {
        return "Artist Name";
    }

    String getImage() {
        return "Artist Image";
    }
}

class Book {

    String getCoverPage() {
        return "Book cover page";
    }

    String getName() {
        return "Book Name";
    }

    String getImage() {
        return "Book Image";
    }
}
