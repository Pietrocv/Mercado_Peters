package mercado.pietro.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import mercado.pietro.Model.bo.UsuarioBO;
import mercado.pietro.Model.dto.UsuarioDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cadastro_usuario")
public class CadastroUsuarioController {

    @Inject
    UsuarioBO bo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_usuario();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_UsuarioHTML(){
        return CadastroUsuarioController.Templates.cadastro_usuario();
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save (UsuarioDTO dto){
        return Response.ok(bo.save(dto)).build();
    }
  
}
