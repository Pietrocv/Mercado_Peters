
package mercado.pietro.Model.dao.impl;
import mercado.pietro.Model.dao.AbstractDAO;
import mercado.pietro.Model.entity.Log;
import mercado.pietro.Model.entity.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class LogDAO extends AbstractDAO<Log> {
    private Log fromResultSet(ResultSet resultSet){
        try {
            while(resultSet.next()){
                return new Log(
                        resultSet.getString("usuario"),
                        resultSet.getString("url"),
                        resultSet.getString("metodo"),
                        resultSet.getInt("id"),
                        resultSet.getDate("data_atual"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @PostConstruct
    public void createTable() {
        StringBuilder sql2 = new StringBuilder();
        // language=SQL
        sql2.append("CREATE TABLE IF NOT EXISTS LOG ")
                .append(" (id INTEGER auto_increment,")
                .append("usuario VARCHAR(255),")
                .append(" url VARCHAR(255), ")
                .append(" metodo VARCHAR(255), ")
                .append(" data_atual TIMESTAMP, ")
                .append(" PRIMARY KEY (id)); ");
        try {
            connection().prepareStatement(sql2.toString()).executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void insert(Log entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("INSERT INTO LOG (usuario, url, metodo, data_atual) VALUES (?, ?, ?, ?)");
            ps.setString(1, entity.getUsuario());
            ps.setString(2, entity.getUrl());
            ps.setString(3, entity.getMetodo());
            ps.setDate(4, entity.getData_atual());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void update(Log entity) {
        StringBuilder sql = new StringBuilder();
        // language=SQL
        sql.append("UPDATE LOG SET ")
                .append("name_produto = '"+entity.getUsuario()+"', ")
                .append("name_categoria = '"+entity.getUrl()+"', ")
                .append("preco_produto = '"+entity.getMetodo()+"',")
                .append("data_validade = '"+entity.getData_atual()+"',")
                .append("WHERE id = "+entity.getId()+";");
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("UPDATE LOG SET usuario = ?, url = ?, metodo = ?, data_atual = ?, WHERE id = ?;");
            ps.setString(1, entity.getUsuario());
            ps.setString(2, entity.getUrl());
            ps.setString(3, entity.getMetodo());
            ps.setDate(4, (Date) entity.getData_atual());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public void delete(Log entity) {
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("DELETE FROM Log WHERE id = ?;");
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
    }

    @Override
    public Log getById(Log entity) {
        Log produto = null;
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM LOG WHERE id = ?");
            ps.setInt(1, entity.getId());
            produto = fromResultSet(ps.getResultSet());
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return produto;
    }

    @Override
    public List<Log> getAll() {
        List<Log> log = new ArrayList<>();
        try {
            // language=SQL
            PreparedStatement ps = preparedStatement("SELECT * FROM LOG");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
               log.add(fromResultSet(resultSet));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        close();
        return log;
    }
}
