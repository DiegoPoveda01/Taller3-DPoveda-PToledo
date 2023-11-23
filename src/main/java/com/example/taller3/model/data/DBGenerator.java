package com.example.taller3.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaArtista(create);
        crearTablaAsistente(create);
        crearTablaEntrada(create);
        crearTablaEventoMusical(create);
        relacionarTabla(create,"Artista","nombre_artistas","Evento");
        DBConnector.closeConnection();

    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaArtista(DSLContext create){
        create.createTableIfNotExists("Artista").column("nombre",VARCHAR(50))
                .column("genero",VARCHAR(100))
                .constraint(primaryKey("nombre")).execute();
    }
    private static void crearTablaAsistente(DSLContext create){
        create.createTableIfNotExists("Asistente").column("numero",INTEGER)
                .column("preferencia",VARCHAR(100))
                .constraint(primaryKey("numero")).execute();
    }
    private static void crearTablaEntrada(DSLContext create){
        create.createTableIfNotExists("Entrada").column("tipo",VARCHAR(50))
                .column("precio",INTEGER)
                .column("disponible",BOOLEAN)
                .constraint(primaryKey("tipo")).execute();
    }
    private static void crearTablaEventoMusical(DSLContext create){
        create.createTableIfNotExists("Evento").column("nombre",VARCHAR(50))
                .column("fecha",VARCHAR(100))
                .column("lugar",VARCHAR(50))
                .column("nombre_artistas",INTEGER)
                .constraint(primaryKey("nombre")).execute();
    }
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion){
        //  create.alterTableIfExists(nombreTabla).add(foreignKey(claveForanea).references(nombreTablaRelacion)).execute();
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }

}