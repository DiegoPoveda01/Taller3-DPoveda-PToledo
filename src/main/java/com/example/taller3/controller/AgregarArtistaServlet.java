package com.example.taller3.controller;

import com.example.taller3.model.Artista;
import com.example.taller3.model.EventoMusical;
import com.example.taller3.model.data.DBGenerator;
import com.example.taller3.model.data.dao.ArtistaDAO;
import com.example.taller3.model.data.dao.EventoMusicalDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
@WebServlet(name = "registrarLibroServlet", value = "/RegistrarArtistaServlet")
public class AgregarArtistaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GBMEventsDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroArtista.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroArtistaNOValido.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("genero").length()!=0){
            String nombre = req.getParameter("nombre");
            String genero = req.getParameter("genero");
            Artista artista = new Artista(nombre, genero);
            try {
                if(agregarArtista(artista)){
                    req.setAttribute("Artista",artista);
                    respuesta = req.getRequestDispatcher("/registroArtistaValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarArtista(Artista artista) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("GBMEventsDB");
        List<Artista> artistas = ArtistaDAO.obtenerArtista(query, "nombre", artista.getNombre());
        if (artistas.size() != 0) {
            return false;
        }

        ArtistaDAO.agregarArtista(query, artista);
        return true;
    }
}