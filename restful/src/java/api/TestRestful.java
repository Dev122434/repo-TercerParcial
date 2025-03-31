package api;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.Producto;

@Path("generic")
public class TestRestful {

    @Context
    private UriInfo context;

    public TestRestful() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJSON() {

        List<Producto> listaProductos = new ArrayList<>();

        Producto producto = new Producto();
        producto.setId_producto(1);
        producto.setClave("P001");
        producto.setDescripcion("Computadora de escritorio");
        producto.setPrecio(10000);

        listaProductos.add(producto);

        producto = new Producto();
        producto.setId_producto(2);
        producto.setClave("P002");
        producto.setDescripcion("Laptop");
        producto.setPrecio(8000);
        listaProductos.add(producto);

        producto = new Producto();
        producto.setId_producto(3);
        producto.setClave("P003");
        producto.setDescripcion("Tablet");
        producto.setPrecio(5000);
        listaProductos.add(producto);

        Gson json = new Gson();
        String response = json.toJson(listaProductos);
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJSON(String content) {
        System.out.println("Valor recibido - POST: " + content);
        Gson json = new Gson();
        Producto producto = json.fromJson(content, Producto.class);

        System.out.println(producto.getId_producto());
        System.out.println(producto.getClave());
        System.out.println(producto.getDescripcion());
        System.out.println(producto.getPrecio());
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJSON(String content) {
        System.out.println("Valor recibido - PUT: " + content);
        Gson json = new Gson();
        Producto producto = json.fromJson(content, Producto.class);

        System.out.println(producto.getId_producto());
        System.out.println(producto.getClave());
        System.out.println(producto.getDescripcion());
        System.out.println(producto.getPrecio());
    }

    @DELETE
    public void deleteJSON() {
    }
}
