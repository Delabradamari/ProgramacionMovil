/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebapeluqueria;

/**
 *
 * @author dany_
 */
public class PruebaPeluqueria {
    public class perro{
        private String nombre;
        private boolean pelo;
    
    
    public perro(){
    this.nombre="Snoopy";
    this.pelo=true;
    
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setPelo(boolean pelo){
        this.pelo=pelo;
    }
    
    public Boolean getPelo(){
        return this.pelo;
    }
    
    public String tostring(){
        return "perrro {" + "nombre"+ nombre + ",pelo=" +pelo+"}";
    }
    
    public class Peluqueria{
        public void cortarPelo(perro p){
            p.setPelo(false);
        }
    }
    
    
    }
}
