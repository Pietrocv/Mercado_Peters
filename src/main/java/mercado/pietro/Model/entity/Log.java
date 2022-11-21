package mercado.pietro.Model.entity;

import mercado.pietro.Model.dto.LogDTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Log {
    public Log(String usuario, String url, String metodo, int id, Date data_atual) {
        this.usuario = usuario;
        this.url = url;
        this.metodo = metodo;
        this.id = id;
        this.data_atual = data_atual;
    }

    public Log(){
    }
    public Log(LogDTO dto){
        this( dto.getUsuario(), dto.getMetodo(), dto.getUrl(), dto.getId(),dto.getData_atual());
    }

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_atual() {
        return data_atual;
    }

    public void setData_atual(Date data_atual) {
        this.data_atual = data_atual;
    }

    private String url;
    private String metodo;
    private int id;
    private Date data_atual;
}
