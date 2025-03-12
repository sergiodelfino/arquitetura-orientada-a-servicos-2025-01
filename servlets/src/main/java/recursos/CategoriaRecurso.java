package recursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import entidades.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/categorias")
public class CategoriaRecurso extends HttpServlet {
    private List<Categoria> categorias;
    private ObjectMapper mapeador;

    @Override
    public void init() throws ServletException {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1L, "Alimentos"));
        categorias.add(new Categoria(2L, "Bebidas"));
        categorias.add(new Categoria(3L, "Higiene Pessoal"));
        categorias.add(new Categoria(4L, "Limpeza"));

        mapeador = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException {
        String json = mapeador.writeValueAsString(categorias);

        resposta.setContentType("application/json");
        resposta.setCharacterEncoding("UTF-8");
        resposta.getWriter().write(json);
    }
}
