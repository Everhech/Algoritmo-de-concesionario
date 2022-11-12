/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class Vehiculo {
    
    String placa,marca,modelo; 
    ArrayList <String> listaVehiculos= new ArrayList();

    
    
    public ArrayList<String> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<String> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    
    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    
    @Override
    public String toString() {
        return "Placa del auto= " + placa + ", Marca del auto= " + marca + ", Modelo del auto= " + modelo + "\n" ;
    }
    
}
