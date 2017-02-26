package com.hcmus.tranngocyennhi0105.listviewcustomadapter;

/**
 * Created by Tran Ngoc Yen Nhi on 24/10/2016.
 */

public class CFood {
    private String Name;
    private Integer Money;
    private String Mota;
    private Integer Picture;

    public CFood(String name, Integer money, String mota, Integer picture) {
        Name = name;
        Money = money;
        Mota = mota;
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public Integer getPicture() {
        return Picture;
    }

    public void setPicture(Integer picture) {
        Picture = picture;
    }
}



