package servicos;

import entidades.Categoria;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService
public class CategoriaServico {
    private List<Categoria> categorias;

    public CategoriaServico(){
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Carnes"));
        categorias.add(new Categoria(3, "Doces"));
        categorias.add(new Categoria(4, "Limpeza"));
    }

    @WebMethod(operationName = "salvarCategoria")
    public void salvar(@WebParam(name = "categoria") Categoria categoria) {
        categorias.add(categoria);
    }

    @WebMethod(operationName = "listarCategorias")
    @WebResult(name = "categoria")
    public List<Categoria> listar() {
        return  categorias;
    }
}
