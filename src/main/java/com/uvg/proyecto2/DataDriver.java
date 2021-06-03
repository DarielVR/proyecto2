package com.uvg.proyecto2;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import static org.neo4j.driver.Values.parameters;

import java.util.HashMap;
import java.util.Map;

public class DataDriver implements AutoCloseable{
    private Driver driver;

    public DataDriver( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void crearUsuario(String nombre, String clave)
    {
        try ( Session session = driver.session() )
        {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nombreUsuario", nombre);
            parametros.put("clave", clave);
            session.writeTransaction(tx -> tx.run( "Merge (a:usuarios {nombreUsuario: $nombreUsuario, clave: $clave}) ", parametros ));
                  
        }
    }

    public void eliminarUsuario(String nombre, String clave)
    {
        try ( Session session = driver.session() )
        {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nombreUsuario", nombre);
            parametros.put("clave", clave);
            session.writeTransaction(tx -> tx.run( "Match (a:usuarios {nombreUsuario: $nombreUsuario, clave: $clave}) Delete a", parametros ));
                  
        }
    }

}
