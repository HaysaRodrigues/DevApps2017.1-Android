package model;

/**
 * Created by Haysa on 12/08/17.
 */

public class Article {

    private String author;
    private String description;
    private String title;
    private String urlToImage;

    public Article(String author, String description, String title, String urlToImage){


    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }



    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }




}
