package com.example.taller3.model.data.dao;
import com.example.taller3.model.Asistente;
import com.example.taller3.model.Artista;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.Record;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class AsistenteDAO {
    public static void agregarAsistente(DSLContext query, Asistente asistente) {
            Table tablaAsistente= table(name("Asistente"));
            Field[] columnas = tablaAsistente.fields("numero","preferencia");
            query.insertInto(tablaAsistente, columnas[0], columnas[1])
                    .values(asistente.getNumero(),asistente.getPreferencia())
                    .execute();
    }
    private static List<Asistente> obtenerListaAsistente(Result<Record> resultados) {
        List<Asistente> asistentes = new ArrayList<>();

        for (Record record : resultados) {
            int nombre = record.getValue(DSL.field("nombre", int.class));
            String editorial = record.getValue(DSL.field("editorial", String.class));

            asistentes.add(new Asistente(nombre, editorial));
        }

        return asistentes;
    }
    public static List obtenerAsistente(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Asistente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAsistente(resultados);
    }
}
