package com.utils;

import dominio.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaPublicaciones {

    private List<Post> listaPublicacion;

    public ListaPublicaciones(){
        this.listaPublicacion= new ArrayList<>();
        this.cargarLista();
    }

    public List<Post> getListaPublicacion(){
        return this.listaPublicacion;
    }

    public void agregarPublicacion(Post post){
        this.listaPublicacion.add(post);
    }

    private void cargarLista() {
        this.listaPublicacion.removeAll(this.listaPublicacion);
        this.listaPublicacion.add(new Post(1L, new Date(), "Pochito 'el travieso' Arce", "Hola muy buenas a todos guapisímos, aquí vegueta 777 en directo en minecraft, desde mundo vegueta😊😊😊😊"));
        this.listaPublicacion.add(new Post(2L, new Date(), "Justin B", "buenas tardes mi nombre es Justin biber y me comunico con el fin de evaluar el servicio que usted recibe"));
        this.listaPublicacion.add(new Post(3L, new Date(), "McGregor", "me lastime la pierna en mi ultima pelea"));
        this.listaPublicacion.add(new Post(4L, new Date(), "Gabe Newell", "half life 4"));
        this.listaPublicacion.add(new Post(5L, new Date(), "Romana Garcia", "pokemon go"));
    }

}