package org.infantaelena.modelo.entidades;
/**
 * Clase que representa a un pokemon
 * @author Dragos Alexandru
 * @version 24/04/2023
 *
 */
public class Pokemon {
    private int id;
    private String nombre;
    private Tipo tipo;
    private int vida;
    private int ataque;
    private int defensa;
    public Pokemon() {
        this.tipo=Tipo.NORMAL;
        this.vida=0;
        this.ataque=0;
        this.defensa=0;
    }

    public Pokemon(String nombre, Tipo tipo, int vida, int ataque, int defensa){
        this.nombre = nombre.trim().toUpperCase();
        this.tipo = tipo;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre.trim().toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre.trim().toUpperCase() + '\'' +
                ", tipo='" + tipo.toString()
                + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }
}