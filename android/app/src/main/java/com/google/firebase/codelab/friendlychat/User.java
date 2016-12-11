package com.google.firebase.codelab.friendlychat;

/**
 * Created by Sang on 06/12/2016.
 */

public class User {
    private String alias;
    private String email;
    private String photo_url;
    private String language;

    public User () { }

    public User (String text, String name, String photoUrl, String language) {
        this.alias = text;
        this.email = name;
        this.photo_url = photoUrl;
        this.language = language;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photo_url;
    }
    public void setPhotoUrl(String photoUrl) { this.photo_url = photoUrl; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
