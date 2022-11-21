package mercado.pietro.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import mercado.pietro.Model.bo.ProdutoBO;
import mercado.pietro.Model.dto.ProdutoDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cadastro_produto")
public class CadastroProdutoController {
    @Inject
    ProdutoBO bo;
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_produto();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_ProdutoHTML(){
        return CadastroProdutoController.Templates.cadastro_produto();
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (ProdutoDTO dto){
        return Response.ok(bo.save(dto)).build();
    }

    @GET
    @Path("lista_produtos")
    public Response getAllProdutos (){
       return Response.ok(bo.getAllProduto()).build();
    }


}
