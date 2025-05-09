package recursos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/calculadora")
public class CalculadoraRecurso {
    @GET
    @Path("/somar/{a}/{b}")
    public double somar(
            @PathParam("a") double x,
            @PathParam("b") double y){
        return x + y;
    }

    @GET
    @Path("/multiplicacao/{a}/{b}")
    public double multiplicar(
            @PathParam("a") double x,
            @PathParam("b") double y){
        return x * y;
    }
}
