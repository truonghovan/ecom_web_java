package com.website.models.view;

public class DT_NamView {
    private String nam;
    private int giatri;

    public DT_NamView(String nam, int giatri) {
        this.nam = nam;
        this.giatri = giatri;
    }

    public DT_NamView() {
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }
}
