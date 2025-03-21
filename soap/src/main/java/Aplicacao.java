import jakarta.xml.ws.Endpoint;
import servicos.CalculadoraServico;
import servicos.Exercicio01Servico;

public class Aplicacao {
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8080/calculadora",
                new CalculadoraServico()
        );

        Endpoint.publish(
                "http://localhost:8080/exercicio01",
                new Exercicio01Servico()
        );
    }
}
