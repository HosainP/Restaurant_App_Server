import java.io.Serializable;

public class Comment implements Serializable {
    String text;
    String answer;
    int star;
    User user;
    boolean checked;

    public Comment(String text, int star, User user, String answer) {
        this();
        this.text = text;
        this.star = star;
        this.user = user;
        this.answer = answer;
    }
    public Comment(){
        answer = "a";
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                ", star=" + star +
                ", user=" + user +
                '}';
    }
}
