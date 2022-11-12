package logicaNegocio;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import presentacion.Cliente;

public class CompraVenta {

    //private Vehiculo vehiculo = new Vehiculo();
    private ArrayList<Vehiculo> listaCoches = new ArrayList<>();
    boolean verificacion = false;

    public void agregarCoches(ArrayList<Vehiculo> listaCoches) {
        //Pone el parámetro del vehículo
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(JOptionPane.showInputDialog(null, "Placa: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
        vehiculo.setMarca(JOptionPane.showInputDialog(null, "Marca: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
        vehiculo.setModelo(JOptionPane.showInputDialog(null, "Modelo: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
        //String datosVehiculo = vehiculo.getPlaca() + "," + vehiculo.getMarca() + "," + vehiculo.getModelo();
        //listaCoches.add(vehiculo);
        if (vehiculo.getPlaca().equals("") || vehiculo.getMarca().equals("") || vehiculo.getModelo().equals("")) {
            JOptionPane.showMessageDialog(null, "No ha rellenado correctamente las casillas");
            Cliente.menu();
        } else {
            listaCoches.add(vehiculo);
            //System.out.println(datosVehiculo);
            System.out.println(listaCoches);
            JOptionPane.showMessageDialog(null, "Vehiculo Insertado");
        }
    }

    public void listarVehiculo(ArrayList<Vehiculo> lista) {
        for (int i = 0; i < lista.size(); i++) {
            JOptionPane.showMessageDialog(null, lista.get(i), "EL CACHARRO LA SEPTIMA, Vehiculo #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen vehiculos registrados");
        }
    }

    public boolean buscarVehiculoPlaca(String placa, ArrayList<Vehiculo> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (placa.equalsIgnoreCase(lista.get(i).getPlaca())) {
                JOptionPane.showMessageDialog(null, "Vehiculo encontrado con " + lista.get(i));
                verificacion = true;
                break;
            } else {
                verificacion = false;
            }
        }
        return verificacion;
    }

    public int buscaCantidadVehiculosModelo(String modelo, ArrayList<Vehiculo> lista) {
        int varContador = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (modelo.equalsIgnoreCase(lista.get(i).getModelo())) {
                varContador++;
            }
        }
        return varContador;
    }

    public void buscaCantidadVehiculosMarca(ArrayList<Vehiculo> lista) {
        int varContador = 1, maximo = 0;
        String repetir = "", repetirMaximo = "";
        for (int i = 0; i < lista.size(); i++) {  //Hyundai
            for (int j = i + 1; j < lista.size(); j++) { // Mazda, Mazda, Hyundai, Mazda, Hyundai
                if (lista.get(i).getMarca().equalsIgnoreCase(lista.get(j).getMarca())) {
                    varContador++;
                    repetir = lista.get(i).getMarca();
                }
            }
            if (varContador > maximo) {
                maximo = varContador;
                repetirMaximo = repetir;
            }
            varContador = 1;
        }
        JOptionPane.showMessageDialog(null, "El coche que más se repite es: " + repetirMaximo + " con " + maximo + " veces");
    }

    public boolean existePlaca(String nombre, boolean encontrar, String lista) {
        int index = 0;
        if (nombre.equalsIgnoreCase(lista)) {
            encontrar = true;
        } else {
            encontrar = false;
        }
        return encontrar;
    }

}
