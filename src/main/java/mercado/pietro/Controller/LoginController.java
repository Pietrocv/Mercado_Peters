package mercado.pietro.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import mercado.pietro.Model.bo.UsuarioBO;
import mercado.pietro.Model.dto.LoginDTO;
import mercado.pietro.Model.entity.Usuario;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
public class LoginController {
    @Inject
    UsuarioBO usuarioBO;
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance login();
    }
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean login(LoginDTO loginDTO){
        return usuarioBO.login(loginDTO);
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLoginHTML(){
        return Templates.login();
    }

}
