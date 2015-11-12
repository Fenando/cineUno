/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PeliculaDAL;
import java.sql.Timestamp;
import java.util.ArrayList;



/**
 *
 * @author fernando
 */
public class Pelicula {
    private String codigo;
    private String nombre;
    private String categoria;
    private int diasPrestamo;
    private String formato;
    private Timestamp fechaIngreso;
    private PeliculaDAL movie;
    private int categoriaI;
    
    public Pelicula() {
        movie = new PeliculaDAL();
    }

    public Pelicula(String codigo, String nombre, String categoria, int diasPrestamo, String formato, Timestamp fechaIngreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        
        this.diasPrestamo = diasPrestamo;
        this.formato = formato;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setCategoriaI(int categoriaI) {
        
        
        this.categoriaI = categoriaI;
    }

    public int getCategoriaI() {
        return categoriaI;
    }
   
    public void insert(Pelicula p){
        this.movie.insert(p);
    } 
    public void update(Pelicula p){
        this.movie.update(p);
    }
    public void delete(String code){
        this.movie.delete(code);
    }
    public ArrayList<Pelicula> verPorEstreno(){
        return this.movie.verPorEstreno();
    }
    public Pelicula verPorCode(String code){
        return this.movie.verPorCode(code);
    }
    public ArrayList<Pelicula> verPorDate(Timestamp date){
        return this.movie.verPorDate(date);
    }
    public ArrayList<Pelicula> verTableOne(){
        return this.movie.verPorTableOne();
    }
    public ArrayList<Pelicula> verTableTwo(){
        return this.movie.verPorTableTwo();
    }
    
    
}
