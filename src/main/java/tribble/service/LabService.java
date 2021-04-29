package tribble.service;

import com.azul.crs.com.fasterxml.jackson.core.JsonProcessingException;
import com.azul.crs.com.fasterxml.jackson.databind.ObjectMapper;
import tribble.dao.LabDao;
import tribble.model.Lab;

import java.util.List;

public class LabService {
    LabDao labDao;
    ObjectMapper mapper;

    public LabService() {
        this.labDao = new LabDao();
    }

    public void create(Lab lab) throws JsonProcessingException {
        labDao.create(lab);
    }


    public List<Lab> readAll() {
       return labDao.getAll();
    }

    public Lab read(Integer id) {
        return labDao.read(id);
    }
}
