package com.example.hellofirbasenote2;

public class NotesModel {
    private String title;

    public NotesModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    private String subTitle;


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
