import java.util.Date;

public class Challenge11 {
    public static class User {
        private String name;
        private boolean status;
        private Date logtime;

        public User(String name) {
            this.name = name;
        }

        public boolean isLoggedIn() {
            if (this.status) {
                return true;
            }
            return false;
        }

        public Date getLastLoggedInAt() {
            return logtime;
        }

        public void logIn() {
            if (!this.status) {
                this.status = true;
                logtime = new Date();
            }
        }
        public void logOut() {
            if (this.status) {
                this.status = false;
            }
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public boolean canEdit(Comment comment) {
            if (comment.author.name == name) {
                return true;
            }
            return false;
        }
        public boolean canDelete(Comment comment) {
            return false;
        }
    }

    public static class Moderator extends User{

        public Moderator(String name) {
            super(name);
        }

        public boolean canDelete(Comment comment) {
            return true;
        }
    }

    public static class Admin extends Moderator{
        public Admin(String name) {
            super(name);
        }

        public boolean canEdit(Comment comment) {
            return true;
        }
    }

    public static class Comment {
        private User author;
        private String message;
        private Comment repliedTo;
        private Date time;

        public Comment(User author, String message) {
            this.message = message;
            this.author = author;
            this.time = new Date();
        }

        public Comment(User author, String message, Comment repliedTo) {
            this.message = message;
            this.author = author;
            this.repliedTo = repliedTo;
            this.time = new Date();
        }

        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public Date getCreatedAt() {
            return time;
        }
        public User getAuthor() {
            return author;
        }
        public Comment getRepliedTo() {
            return repliedTo;
        }

        public String toString() {
            if (this.repliedTo == null) {
                return message + " by " + author.name;
            }
            return message + " by " + author.name + " (replied to " + repliedTo.author.name + ")";
        }
    }
}
