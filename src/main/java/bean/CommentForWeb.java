package bean;

import java.sql.Date;

public class CommentForWeb {
    private int id;
    private int id_user;
    private String feedback;
    private Date date_cmt;
    private int reader;

    public int getReader() {
        return reader;
    }

    public void setReader(int reader) {
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public Date getDate_cmt() {
        return date_cmt;
    }

    public int getId_user() {
        return id_user;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_cmt(Date date_cmt) {
        this.date_cmt = date_cmt;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "CommentForWeb{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", feedback='" + feedback + '\'' +
                ", date_cmt=" + date_cmt +
                ", reader=" + reader +
                '}';
    }
}
