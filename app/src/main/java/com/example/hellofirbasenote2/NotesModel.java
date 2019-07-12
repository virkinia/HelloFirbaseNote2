package com.example.hellofirbasenote2;

public class NotesModel {
    private String title;
    private String subTitle;

    public NotesModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public NotesModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
