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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CrearEventoServlet", value = "/CrearEventoServlet")
public class CrearEventoServlet extends HttpServlet {
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
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/crearEventoMusical.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/creacionEventoNOVALIDA.jsp");
        if (req.getParameter("nombre") != null && req.getParameter("fecha") != null &&
                req.getParameter("lugar") != null && req.getParameter("nombre_artistas") != null &&
                req.getParameter("nombre").length() != 0 && req.getParameter("fecha").length() != 0 &&
                req.getParameter("lugar").length() != 0 && req.getParameter("nombre_artistas").length() != 0) {

            String nombre = req.getParameter("nombre");
            String fecha = req.getParameter("fecha");
            String lugar = req.getParameter("lugar");
            String artistas = req.getParameter("nombre_artistas");

            EventoMusical evento = new EventoMusical(nombre, fecha, lugar, artistas);

            try {
                if (agregarEvento(evento)) {
                    req.setAttribute("evento", evento);
                    respuesta = req.getRequestDispatcher("/creacionEventoValida.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        respuesta.forward(req, resp);
    }
    private boolean agregarEvento(EventoMusical evento) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("GBMEventsDB");
        List<EventoMusical> eventos = EventoMusicalDAO.obtenerEvento(query,"nombre", evento.getNombre());
        if(eventos.size()!=0){
            return false;
        }
        else{
            EventoMusicalDAO.agregarEventoMusical(query,evento);
            return true;
        }
    }
}