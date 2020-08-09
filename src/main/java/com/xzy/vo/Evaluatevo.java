package com.xzy.vo;

import java.util.Date;

public class Evaluatevo {
    private String userName;
    private String userPic;
    private String dialogbox;
    private Date date;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getDialogbox() {
        return dialogbox;
    }

    public void setDialogbox(String dialogbox) {
        this.dialogbox = dialogbox;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "userName='" + userName + '\'' +
                ", userPic='" + userPic + '\'' +
                ", dialogbox='" + dialogbox + '\'' +
                ", date=" + date +
                '}';
    }
}
