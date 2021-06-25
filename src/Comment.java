public class Comment {
    String text;
    String answer;
    int star;
//    User user; TODO

    Comment(String text, String answer, int star) {
        this.text = text;
        this.answer = answer;
        this.star = star;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                ", star=" + star +
//                ", user=" + user + TODO
                '}';
    }
}