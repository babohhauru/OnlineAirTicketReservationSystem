package com.works.domain;

public class Admin {
    private Integer adminID;
    private String adminUsrName;
    private String password;

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAdminUsrName() {
        return adminUsrName;
    }

    public void setAdminUsrName(String adminUsrName) {
        this.adminUsrName = adminUsrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
