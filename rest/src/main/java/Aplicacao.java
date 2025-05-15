import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import recursos.CalculadoraRecurso;
import recursos.CategoriaRecurso;

public class Aplicacao {
    public static void main(String[] args) {
        JAXRSServerFactoryBean servidor = new JAXRSServerFactoryBean();
        servidor.setResourceClasses(CalculadoraRecurso.class, CategoriaRecurso.class);
        servidor.setAddress("http://localhost:8080/api");
        servidor.setProvider(new JacksonJsonProvider());
        servidor.create();
    }
}
