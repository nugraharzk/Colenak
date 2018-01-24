package com.example.rizki.talentbdgproject.classes;

/**
 * Created by Rizki on 11/4/2017.
 */

public class Place {
    private String nama, lokasi, telp, jam, harga, deskripsi;
    private int thumbnail;
    private int[] arrInt;
    private double lat, lng;

    public Place(String nama, String lokasi, String telp, String jam, String harga, String deskripsi, int thumbnail, int[] arr) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.telp = telp;
        this.jam = jam;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.thumbnail = thumbnail;
        this.arrInt = arr;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public int[] getArrInt() {
        return arrInt;
    }

    public void setArrInt(int[] arrInt) {
        this.arrInt = arrInt;
    }
}
