package logicaNegocio;
//import logicaNegocio.Vehiculo;
//import logicaNegocio.CompraVenta;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Archivo {

    private BufferedWriter writing;
    private BufferedReader reader;

    public void Writer(String datos) throws IOException {

        writing.write(datos);
        writing.newLine();
    }

    public boolean IsRead() throws IOException {
        return reader.ready();
    }

    public void Open(String nombre, boolean is) throws IOException {
        if (is == true) {
            this.writing = new BufferedWriter(new FileWriter(nombre, true));
        } else {
            this.reader = new BufferedReader(new FileReader(nombre));
        }

    }

//    public ArrayList<Vehiculo> ReadArchiveLi() throws IOException {
//        this.Open("Vehiculos.txt", false);
//        String linea = "";
//        ArrayList<Vehiculo> list = new ArrayList();
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i);
//        }
//        this.Close();
//        return list;
//    }

    public ArrayList<Vehiculo> ReadArchive() throws IOException {
        this.Open("Vehiculos.txt", false);
        String linea = "";
        ArrayList<Vehiculo> list = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        this.Close();
        return list;
    }

    public String Reader() throws IOException {
        return reader.readLine();
    }

    public void Close() throws IOException {

        if (writing != null) {
            writing.close();
        }
        if (reader != null) {
            reader.close();
        }
    }

//    public void ToArchiveLi(ArrayList<Vehiculo> list) throws IOException {
//        this.Open("Vehiculos.txt", true);
//        for (int i = 0; i < list.size(); i++) {
//            String dato = list.get(i).toString();
//            this.Writer(dato);
//        }
//        this.Close();
//    }

    public void ToArchive(ArrayList<Vehiculo> list) throws IOException {
        this.Open("Vehiculos.txt", true);
        for (int i = 0; i < list.size(); i++) {
            String dato = list.get(i).toString();
            this.Writer(dato);
        }
        this.Close();
    }

    public int Plus(String nombreArchivo) throws IOException {
        Open(nombreArchivo, false);
        int row = 0;
        while (IsRead()) {
            Reader();
            row++;
        }
        Close();
        return row;
    }
}
