package servicos;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class TemperaturaServico {
    @WebMethod
    public float celsiusParaFahrenheit (float celsius) {
        return 0;
    }

    @WebMethod
    public float celsiusParaKelvin (float celsius) {
        return 0;
    }
}
