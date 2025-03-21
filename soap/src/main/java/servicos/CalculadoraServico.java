package servicos;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CalculadoraServico {
    @WebMethod
    public double somar(double a, double b) {
        return a + b;
    }

    @WebMethod
    public double subtrair(double a, double b) {
        return a - b;
    }

    @WebMethod
    public double multiplicar(double a, double b) {
        return a * b;
    }
}
