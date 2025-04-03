package testrestful;

import api.ConsumeApi;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import modelo.pojos.Producto;

public class Main {

    public static void main(String[] args) {
        ConsumeApi api = new ConsumeApi();
        Gson json = new Gson();
        
        // Insert (Método Post)
        /* Producto producto = new Producto();
        producto.setClave("P001");
        producto.setDescripcion("Computadora de escritorio");
        producto.setPrecio(1500);
        api.postJSON(producto); */
        
        // (Método Get)
        /* List<Producto> listaProductos = api.getJSON(List.class);
        for (Producto item : listaProductos) {
            System.out.println(item.getId_producto());
            System.out.println(item.getClave());
            System.out.println(item.getDescripcion());
            System.out.println(item.getPrecio());
        } */

        // (Método Put)
        /* Producto producto = new Producto();
        producto.setClave("P001");
        producto.setDescripcion("Computadora de escritorio");
        producto.setPrecio(1500);
        api.putJSON(producto); */
        
        try {
            String id = "P001";
            URL url = new URL("http://localhost:8080/restful/webresources/test/buscarProducto/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                System.out.println("Error" + responsecode);
            } else {
                StringBuilder informationstring = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    informationstring.append(sc.nextLine());
                }
                sc.close();
                String cadenajson = informationstring.toString();
                System.out.println("Valor recibido del get con prametros: " + informationstring);

                Producto producto = json.fromJson(cadenajson, Producto.class);

                System.out.println(producto.getId_producto());
                System.out.println(producto.getClave());
                System.out.println(producto.getDescripcion());
                System.out.println(producto.getPrecio());
            }
        } catch (IOException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
    }

}
