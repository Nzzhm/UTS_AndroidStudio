package com.example.uts;

public class Destinasi {
    private String judul;
    private String deskripsi;
    private int gambarId;

    public Destinasi(String judul, String deskripsi, int gambarId) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambarId = gambarId;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambarId() {
        return gambarId;
    }

    public void setGambarId(int gambarId) {
        this.gambarId = gambarId;
    }
}
