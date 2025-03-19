import jakarta.xml.ws.Endpoint;
import servicos.CalculadoraServico;

public class Aplicacao {
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8080/calculadora",
                new CalculadoraServico()
        );
    }
}
