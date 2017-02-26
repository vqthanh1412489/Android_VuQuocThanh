package com.hcmus.tranngocyennhi0105.gridview;

/**
 * Created by Tran Ngoc Yen Nhi on 28/10/2016.
 */

public class CFacebook {
    private String Name;
    private Integer Picture;

    public CFacebook(String name, Integer picture) {
        Name = name;
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPicture() {
        return Picture;
    }

    public void setPicture(Integer picture) {
        Picture = picture;
    }
}
