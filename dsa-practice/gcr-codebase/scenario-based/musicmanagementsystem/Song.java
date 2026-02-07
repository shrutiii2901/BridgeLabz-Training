class Song {
    String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        Song s = (Song) o;
        return this.title.equals(s.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return title;
    }
}
