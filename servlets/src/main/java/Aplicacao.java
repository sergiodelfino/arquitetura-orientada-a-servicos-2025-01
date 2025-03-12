import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.UserStore;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Credential;
import recursos.Calculadora;
import recursos.CategoriaRecurso;

public class Aplicacao {
    public static void main(String[] args) throws Exception {
        Server servidor = new Server(8080);

        ServletContextHandler contexto = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contexto.setContextPath("/api");
        contexto.addServlet(new ServletHolder(new Calculadora()), "/calculadora/*");
        contexto.addServlet(new ServletHolder(new CategoriaRecurso()), "/categorias");
        servidor.setHandler(contexto);

        Constraint restricao = new Constraint();
        restricao.setName(Constraint.__BASIC_AUTH);
        restricao.setAuthenticate(true);
        restricao.setRoles(new String[]{"administrador", "usuario"});

        ConstraintMapping mapeamento = new ConstraintMapping();
        mapeamento.setConstraint(restricao);
        mapeamento.setPathSpec("/*");

        UserStore usuarios = new UserStore();
        usuarios.addUser("sergio", Credential.getCredential("q1w2e3r4"), new String[]{"administrador", "usuario"});
        usuarios.addUser("patricia", Credential.getCredential("toor"), new String[]{"usuario"});

        HashLoginService autenticacao = new HashLoginService();
        autenticacao.setUserStore(usuarios);

        ConstraintSecurityHandler seguranca = new ConstraintSecurityHandler();
        seguranca.addConstraintMapping(mapeamento);
        seguranca.setLoginService(autenticacao);
        seguranca.setAuthenticator(new BasicAuthenticator());

        contexto.setSecurityHandler(seguranca);


        servidor.start();
        servidor.join();
    }
}
