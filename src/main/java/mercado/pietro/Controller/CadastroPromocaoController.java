package mercado.pietro.Controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cadastro_promocao")
public class CadastroPromocaoController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro_promocao();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getCadastro_PromocaoHTML(){
        return CadastroPromocaoController.Templates.cadastro_promocao();
    }
}
