package dev.mobile.ass_2_listview.enity;

/**
 * @author CuongNV
 */
public class Mobile {
    String title;
    String content;
    public Mobile(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
