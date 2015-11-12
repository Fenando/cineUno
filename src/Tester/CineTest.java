/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import BLL.Pelicula;
import DAL.PeliculaDAL;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author fernando
 */
public class CineTest {

    public static void main(String[] args) {
 StringBuffer t = new StringBuffer("test ");
            
            
                 System.out.println(t);
                 System.out.println(t.append("hola"));
        PeliculaDAL cBD = new PeliculaDAL();
        Pelicula cine = new Pelicula();
        cBD.deleteAll();
           
        cine.insert(new Pelicula("p01", "hobbit", "estreno", 7, "dvd", Timestamp.valueOf("2010-5-27 20:00:00")));
        cine.insert(new Pelicula("p02", "hobbit", "estreno", 7, "dvd", Timestamp.valueOf("2010-5-27 21:00:00")));
        cine.insert(new Pelicula("p04", "hobbit2", "estreno", 7, "dvd", Timestamp.valueOf("2010-5-27 20:00:00")));
        cine.update(new Pelicula("p04", "hobbit4", "estreno", 10, "dvd", Timestamp.valueOf("2010-5-27 20:00:00")));
        
        System.out.println(cine.verPorEstreno().get(0).getFechaIngreso() == Timestamp.valueOf("2010-5-27 20:00:00") ? 1 : cine.verPorEstreno().get(0).getFechaIngreso());
        System.out.println(cine.verPorDate(Timestamp.valueOf("2010-5-27 20:00:00")).get(0).getNombre());
        System.out.println(cine.verPorDate(Timestamp.valueOf("2010-5-27 20:00:00")).get(1).getNombre());
        System.out.println(cine.verPorDate(Timestamp.valueOf("2010-5-27 21:00:00")).get(0).getNombre());
        System.out.println(cine.verTableOne().get(0).getCodigo());
        System.out.println(cine.verTableTwo().get(0).getDiasPrestamo());
        
    }
}
