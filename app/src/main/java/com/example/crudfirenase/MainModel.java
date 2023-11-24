package com.example.crudfirenase;

public class MainModel {

    String Nombre, Apellido, email, imgUrl;

    public MainModel(){
    }

    public MainModel(String nombre, String apellido, String email, String imgUrl) {
        Nombre = nombre;
        Apellido = apellido;
        this.email = email;
        this.imgUrl = imgUrl;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
