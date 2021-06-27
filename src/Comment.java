import java.io.Serializable;

public class Comment implements Serializable {
    String text;
    String answer;
    int star;
    User user;
    String userName;
    boolean checked;

    public Comment(String text, int star, User user, String answer) {
        this();
        this.text = text;
        this.star = star;
        this.user = user;
        this.answer = answer;
        this.userName = user.name;
    }

    public Comment() {
        checked = false;
        answer = "a";
    }

    public Comment(String text, String answer, int star, String userName, boolean checked){
        this();
        this.text = text;
        this.answer = answer;
        this.star = star;
        this.userName = userName;
        this.checked = checked;
    }
}

