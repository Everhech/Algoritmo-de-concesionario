package presentacion;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicaNegocio.Archivo;
import logicaNegocio.CompraVenta;
import logicaNegocio.Vehiculo;

public class Cliente {

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() {
        ArrayList<Vehiculo> listaCoches = new ArrayList();
        Archivo dataBase = new Archivo();
        CompraVenta compraVenta = new CompraVenta();
        String atrPlacaBusqueda, atrModeloBusqueda, atrMarcaBusqueda;
        int option = 0;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Insertar Vehiculo\n"
                        + "2. Listar Vehiculos\n"
                        + "3. Buscar Vehiculo por placa\n"
                        + "4. Conocer Cuantos Vehiculos hay por modelo\n"
                        + "5. Conocer Cuantos Vehiculos hay por marca\n"
                        + "6. Eliminar por placa\n"
                        + "7. Salir\n"
                        + "Seleccione una opcion", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
                switch (option) {
                    case 1:
                        compraVenta.agregarCoches(listaCoches);
                        try {
                            dataBase.ToArchive(listaCoches);
                            JOptionPane.showMessageDialog(null, "SE HAN GUARDADO LOS VEHICULOS EN UN ARCHIVO");
                        } catch (IOException z) {
                            JOptionPane.showMessageDialog(null, "Error" + z.getMessage());
                        }
                        break;
                    case 2:
                        compraVenta.listarVehiculo(listaCoches);
                        break;
                    case 3:
                        atrPlacaBusqueda = JOptionPane.showInputDialog(null, "Digite la placa del vehiculo a buscar: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE);
                        boolean verificacion = compraVenta.buscarVehiculoPlaca(atrPlacaBusqueda, listaCoches);
                        if (verificacion == false) {
                            JOptionPane.showMessageDialog(null, "Vehiculo no encontrado con esa placa");
                        }
                        break;
                    case 4:
                        atrModeloBusqueda = JOptionPane.showInputDialog(null, "Digite el modelo del coche: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE);
                        int coches = compraVenta.buscaCantidadVehiculosModelo(atrModeloBusqueda, listaCoches);
                        if (coches > 0) {
                            JOptionPane.showMessageDialog(null, "Hay " + coches + " vehiculos");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron vehiculos con ese modelo");
                        }
                        break;
                    case 5:
                        compraVenta.buscaCantidadVehiculosMarca(listaCoches);
                        break;
                    case 6:
                        boolean encontrar = false;
                        String nom = JOptionPane.showInputDialog(null, "Inserte la placa del auto que quiere eliminar");
                        int listaOut = listaCoches.size();
                        for (int i = 0; i < listaCoches.size(); i++) {
                            if (compraVenta.existePlaca(nom, encontrar, listaCoches.get(i).getPlaca())) {
                                listaCoches.remove(i);
                                JOptionPane.showMessageDialog(null, "El vehiculo elegido se ha eliminado con éxito");
                            }
                        }
                        if (listaCoches.size() == listaOut) {
                            JOptionPane.showMessageDialog(null, "No se ha encontrado vehiculo con esa placa");
                        }
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while (option != 7);
    }

//    public static int opciones() {
//        return Integer.parseInt(JOptionPane.showInputDialog(null,
//                "1. Insertar Vehiculo\n"
//                + "2. Listar Vehiculos\n"
//                + "3. Salir\n"
//                + "Seleccione una opcion", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
//    }
//
//    public static String opcionesInsertar() {
//        Vehiculo vehiculo = new Vehiculo();
//        vehiculo.setPlaca(JOptionPane.showInputDialog(null, "Placa: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
//        vehiculo.setMarca(JOptionPane.showInputDialog(null, "Marca: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
//        vehiculo.setModelo(JOptionPane.showInputDialog(null, "Modelo: ", "EL CACHARRO LA SEPTIMA", JOptionPane.INFORMATION_MESSAGE));
//        String datosVehiculo = vehiculo.getPlaca() + "," + vehiculo.getMarca() + "," + vehiculo.getModelo();
//        System.out.println(datosVehiculo);
//        return datosVehiculo;
//    }
}
