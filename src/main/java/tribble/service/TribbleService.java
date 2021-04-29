package tribble.service;

import tribble.dao.TribbleDao;
import tribble.model.Tribble;

import java.util.List;

public class TribbleService {
    private TribbleDao tribbleDao;

    public void create(Tribble readValue) {
     tribbleDao.create(readValue);
    }

    public List<Tribble> readAll() {
    return tribbleDao.getAll();
    }

    public Tribble read(Integer id) {
        return tribbleDao.read(id);
    }
}
