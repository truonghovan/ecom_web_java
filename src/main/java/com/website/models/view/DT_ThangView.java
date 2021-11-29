package com.website.models.view;

public class DT_ThangView {

    private String thang;
    private int doanhthu;

    public DT_ThangView() {
    }

    public DT_ThangView(String thang, int doanhthu) {
        this.thang = thang;
        this.doanhthu = doanhthu;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }
}
