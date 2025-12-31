class BookLib {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends BookLib {
    void show() {
        System.out.println(ISBN + " " + title);
    }
}
