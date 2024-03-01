package bean;

import java.sql.Date;

public class CommentReponse {
    private int id;
    private String nameUser;
    private String feedback;
    private Date date_cmt;
    private  int reader;

    public int getReader() {
        return reader;
    }

    public void setReader(int reader) {
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getFeedback() {
        return feedback;
    }

    public Date getDate_cmt() {
        return date_cmt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setDate_cmt(Date date_cmt) {
        this.date_cmt = date_cmt;
    }

    @Override
    public String toString() {
        return "CommentReponse{" +
                "id=" + id +
                ", nameUser='" + nameUser + '\'' +
                ", feedback='" + feedback + '\'' +
                ", date_cmt=" + date_cmt +
                '}';
    }
}
