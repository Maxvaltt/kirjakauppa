package com.example.kirjakauppa.domain;

public class book {
private long id;
private String nimi;
private String kirjailija;
private int vuosi;
private String isbn;
private int hinta;


public book(long id, String nimi, String kirjailija, int vuosi, String isbn, int hinta) {
    super();
    this.id = id;
    this.nimi = nimi;
    this.kirjailija = kirjailija;
    this.vuosi = vuosi;
    this.isbn = isbn;
    this.hinta = hinta;
}

public String getNimi() {
    return nimi;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public int getHinta() {
    return hinta;
}

public void setHinta(int hinta) {
    this.hinta = hinta;
}

public void setNimi(String nimi) {
    this.nimi = nimi;
}

public String getKirjailija() {
    return kirjailija;
}

public void setKirjailija(String kirjailija) {
    this.kirjailija = kirjailija;
}

public int getVuosi() {
    return vuosi;
}

public void setVuosi(int vuosi) {
    this.vuosi = vuosi;
}

public String getIsbn() {
    return isbn;
}

public void setIsbn(String isbn) {
    this.isbn = isbn;
}
}
