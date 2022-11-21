package mercado.pietro.Model.bo;

import mercado.pietro.Model.dao.impl.UsuarioDAO;
import mercado.pietro.Model.dto.LoginDTO;
import mercado.pietro.Model.dto.UsuarioDTO;
import mercado.pietro.Model.entity.Usuario;
/*
import mercado.pietro.Model.utils.EncoderPassword;
import mercado.pietro.Model.utils.TokenUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
 */


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Dependent
public class UsuarioBO {

    @Inject
    UsuarioDAO usuarioDAO;
    //@ConfigProperty(name = "com.mercado.pietro.jwt.duration") public Long duration;
    //@ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;
    public Boolean save(UsuarioDTO dto) {
        usuarioDAO.insert(new Usuario(dto));
        return true;
    }
    public Boolean login(LoginDTO dto){
        usuarioDAO.findUserByEmail(dto.getEmail());
        return true;
    }
}
