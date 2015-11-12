/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Pelicula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class PeliculaDAL {
    
    private Conectore con;
    private Statement sta;

    public PeliculaDAL() {
        con  = new Conectore();
        sta = con.getStatement();
    }
    
    public void insert(Pelicula movie){
    
        try {
            sta.executeUpdate("insert into pelicula (codigo, nombre, categoria,dias_prestamo, formato,fecha_ingreso) values( "
                    + "'"+movie.getCodigo()+"',"
                    + "'"+movie.getNombre()+"',"
                    + "'"+movie.getCategoria()+"',"
                    + ""+movie.getDiasPrestamo()+","
                    + "'"+movie.getFormato()+"',"
                    + "'"+movie.getFechaIngreso()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void update(Pelicula movie){
    
        try {
            sta.executeUpdate("update pelicula set "
                    + "nombre = '"+movie.getNombre()+"',"
                    + "categoria = '"+movie.getCategoria()+"',"
                    + "dias_prestamo = "+movie.getDiasPrestamo()+","
                    + "formato = '"+movie.getFormato()+"',"
                    + "fecha_ingreso = '"+movie.getFechaIngreso()+"'"
                    + " where codigo = '"+movie.getCodigo()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(String code) {
        
        try {
            sta.executeUpdate("delete from pelicula where codigo ='"+code+"'");
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Pelicula> verPorEstreno(){
        try {
            ArrayList<Pelicula> aPeliculas = new ArrayList();
            String P = "estreno";
            ResultSet rSet = sta.executeQuery("select * from pelicula where categoria = '"+P+"'");
            while (rSet.next()) {
                Pelicula p = new Pelicula();
                p.setNombre(rSet.getString("nombre"));
                p.setFormato(rSet.getString("formato"));
                p.setFechaIngreso(rSet.getTimestamp("fecha_ingreso"));
                aPeliculas.add(p);
            }
            return aPeliculas;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }         
       public Pelicula verPorCode(String code){
        try {
            ResultSet rSet = sta.executeQuery("select * from pelicula where codigo= '"+code+"'");
            rSet.next();
                Pelicula p = new Pelicula(rSet.getString("codigo"),
                        rSet.getString("nombre"), 
                        rSet.getString("categoria"),
                        rSet.getInt("dias_prestamo"), 
                        rSet.getString("formato"),
                        rSet.getTimestamp("fecha_ingreso"));
            return p;    
        }
         catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }  
    public ArrayList<Pelicula> verPorDate(Timestamp date){
        try {
            
            System.out.println(date);
            ArrayList<Pelicula> aPeliculas = new ArrayList();
            ResultSet rSet = sta.executeQuery("select * from pelicula where fecha_ingreso = '"+date+"'");
            while (rSet.next()) {
                Pelicula p = new Pelicula();
                p.setNombre(rSet.getString("nombre"));
                aPeliculas.add(p);
            }
            return aPeliculas;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }         
    public ArrayList<Pelicula> verPorTableOne(){
        try {
            ArrayList<Pelicula> aPeliculas = new ArrayList();
            ResultSet rSet = sta.executeQuery("select codigo, categoria from pelicula");
            while (rSet.next()) {
                Pelicula p = new Pelicula();
                p.setCodigo(rSet.getString("codigo"));
                p.setCategoria(rSet.getString("categoria"));
                aPeliculas.add(p);
            }
            return aPeliculas;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }         
    public ArrayList<Pelicula> verPorTableTwo(){
        try {
            ArrayList<Pelicula> aPeliculas = new ArrayList();
            ResultSet rSet = sta.executeQuery("select nombre, dias_prestamo, fecha_ingreso from pelicula");
            while (rSet.next()) {
                Pelicula p = new Pelicula();
                p.setNombre(rSet.getString("nombre"));
                p.setDiasPrestamo(rSet.getInt("dias_prestamo"));
                p.setFechaIngreso(rSet.getTimestamp("fecha_ingreso"));
                aPeliculas.add(p);
            }
            return aPeliculas;
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }         
    public void deleteAll(){
        try {
            sta.executeUpdate("delete from pelicula");
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
