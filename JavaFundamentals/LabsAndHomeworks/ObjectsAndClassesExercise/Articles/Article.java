package ObjectsAndClassesExercise.Articles;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void Edit(String newContent) {
        this.content = newContent;
    }

    public void ChangeAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void Rename(String newTitle) {
        this.title = newTitle;
    }

    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
