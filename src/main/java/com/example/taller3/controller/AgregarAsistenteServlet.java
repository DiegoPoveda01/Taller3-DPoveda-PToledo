package com.example.taller3.controller;

import com.example.taller3.model.Artista;
import com.example.taller3.model.Asistente;
import com.example.taller3.model.EventoMusical;
import com.example.taller3.model.data.DBGenerator;
import com.example.taller3.model.data.dao.ArtistaDAO;
import com.example.taller3.model.data.dao.AsistenteDAO;
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
@WebServlet(name = "registrarLibroServlet", value = "/RegistrarAsistenteServlet")
public class AgregarAsistenteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroAsistente.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroAsistenteNOValido.jsp");
        if(req.getParameter("numero").length()!=0 && req.getParameter("preferencia").length()!=0){
            int numero = Integer.parseInt(req.getParameter("numero"));
            String preferencia = req.getParameter("preferencia");

            Asistente asistente = new Asistente(numero,preferencia);
            try {
                if(agregarAsistente(asistente)){
                    req.setAttribute("asistente",asistente);
                    respuesta = req.getRequestDispatcher("/registroAsistenteValido.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarAsistente(Asistente asistente) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("GBMEventsDB");
        List<Asistente> asistentes = AsistenteDAO.obtenerAsistente(query,"numero", asistente.getNumero());
        if(asistentes.size()!=0){
            return false;
        }
        else{
            AsistenteDAO.agregarAsistente(query,asistente);
            return true;
        }
    }
}