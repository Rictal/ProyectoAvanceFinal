/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.google.gson.JsonObject;
import com.utils.OperacionesJson;
import dominio.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bryan
 */
public class EliminarPublicacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader br = request.getReader();
        HttpSession session = request.getSession();
        List<Post> listaPublicacion = (List<Post>) session.getAttribute("listaPublicaciones");

        String json = OperacionesJson.obtenerJson(br);
        System.out.println(json);
        JsonObject postJson = OperacionesJson.stringToJson(json);
        int id = postJson.get("postId").getAsInt();

        System.out.println(id);

        listaPublicacion = this.eliminarPublicacion(listaPublicacion, id);
        for (Post post: listaPublicacion){
            System.out.println(post + "\n");
        }
        session.setAttribute("listaPublicaciones", listaPublicacion);
    }

    private List<Post> eliminarPublicacion(List<Post> listaPublicacion, int id){
        for (Post post: listaPublicacion){
            if (post.getId() == (id)){
                listaPublicacion.remove(post);
                return listaPublicacion;
            }
        }
        return null;
    }

}
