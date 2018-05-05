package com.joelson.swarm.model.enterprise;


import javax.enterprise.context.RequestScoped;


@RequestScoped
public class UserHolder {

    private String user;

    public UserHolder() {
    }

    public UserHolder(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
