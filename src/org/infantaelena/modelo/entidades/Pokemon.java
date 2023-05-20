package org.infantaelena.modelo.entidades;
/**
 * Clase que representa a un pokemon
 * @author
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int vida;
    private int ataque;
    private int defensa;
    public Pokemon() {}

    public Pokemon(String nombre, String tipo, int vida, int ataque, int defensa){
        this.nombre = nombre;
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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                '}';
    }
}