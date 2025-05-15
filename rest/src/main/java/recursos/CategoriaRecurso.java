package recursos;

import entidades.Categoria;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/categorias")
public class CategoriaRecurso {
    private static List<Categoria> categorias;

    static {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Carnes"));
        categorias.add(new Categoria(2, "Frutas"));
        categorias.add(new Categoria(3, "Refrigerantes"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(categorias).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Categoria categoria) {
        categorias.add(categoria);
        return Response.status(Response.Status.CREATED).entity(categoria).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("codigo") Integer codigo) {
        for (Categoria categoria: categorias) {
            if (categoria.getCodigo().equals(codigo)) {
                return Response.ok(categoria).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
