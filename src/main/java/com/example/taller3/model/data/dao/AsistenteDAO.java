package com.example.taller3.model.data.dao;
import com.example.taller3.model.Asistente;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class AsistenteDAO {
    public void agregarAsistente(DSLContext query, Asistente asistente) {
            Table tablaAsistente= table(name("Asistente"));
            Field[] columnas = tablaAsistente.fields("numero","preferencia");
            query.insertInto(tablaAsistente, columnas[0], columnas[1])
                    .values(asistente.getNumero(),asistente.getPreferencia())
                    .execute();
    }
}
