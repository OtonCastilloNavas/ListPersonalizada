package com.cam.listpersonalizada;

public class Item {
    private String nombre;
    private int numero;
    private int imagen;

    public Item(String nombre, int numero, int imagen) {
        this.nombre = nombre;
        this.numero = numero;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
