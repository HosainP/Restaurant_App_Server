public class Comment {
    String text;
    String answer;
    int star;
    User user;

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
