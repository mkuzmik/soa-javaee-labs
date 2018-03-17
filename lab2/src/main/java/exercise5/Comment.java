package exercise5;

public class Comment {

    private User user;
    private String name;
    private String email;
    private String comment;

    public Comment(User user, String name, String email, String comment) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toHTML() {
        return String.format("%s (%s) says:" +
                "<br> %s <br><br>", name, email, comment);
    }
}
