package Object.Rating;

import java.io.Serializable;

public class Rating implements Serializable {
    private final String name;
    private int starCount;
    private String comment;


    public Rating(String name, int starCount, String comment) {
        this.name = name;
        this.starCount = starCount;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public int getStarCount() {
        return starCount;
    }

    public String getComment() {
        return comment;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public void show(){
        System.out.printf("""
                 %-100s
                |%-10s%-40s%-10s%-40s|
                |%-10s%-90s|
                |%-100s|
                ""","_".repeat(100), "Name:",name,"Star:","💖".repeat(starCount), "Comment:",comment, "_".repeat(100) );
    }
}
