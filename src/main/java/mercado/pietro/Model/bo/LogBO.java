package mercado.pietro.Model.bo;

import mercado.pietro.Model.dao.impl.LogDAO;

import mercado.pietro.Model.dto.LogDTO;

import mercado.pietro.Model.entity.Log;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class LogBO {
    @Inject
    LogDAO logDAO;

    public Boolean save(LogDTO dto) {
        logDAO.insert(new Log(dto));
        return true;
    }

    public List<LogDTO> getAllLog(){
        List<Log> logList = logDAO.getAll();
        List<LogDTO> logDTOList = logList.stream().map((log) -> {
            LogDTO logDTO = new LogDTO();
            logDTO.setUsuario(log.getUsuario());
            logDTO.setUrl(log.getUrl());
            logDTO.setMetodo(log.getMetodo());
            logDTO.setData_atual(log.getData_atual());
            return logDTO;
        }).collect(Collectors.toList());
        return logDTOList;
    }
}
