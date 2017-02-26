package com.hsmus.tranngocyennhi.spinnerbasic;

/**
 * Created by Tran Ngoc Yen Nhi on 02/11/2016.
 */

public class CNew {
    private String New;
    private Integer Picture;

    public CNew(String aNew, Integer picture) {
        New = aNew;
        Picture = picture;
    }

    public String getNew() {
        return New;
    }

    public void setNew(String aNew) {
        New = aNew;
    }

    public Integer getPicture() {
        return Picture;
    }

    public void setPicture(Integer picture) {
        Picture = picture;
    }
}
