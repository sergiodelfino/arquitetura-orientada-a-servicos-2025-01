import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import recursos.CalculadoraRecurso;

public class Aplicacao {
    public static void main(String[] args) {
        JAXRSServerFactoryBean servidor = new JAXRSServerFactoryBean();
        servidor.setResourceClasses(CalculadoraRecurso.class);
        servidor.setAddress("http://localhost:8080/api");
        servidor.create();
    }
}
