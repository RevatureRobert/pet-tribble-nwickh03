import tribble.dao.LabDao;
import tribble.model.Lab;
import tribble.util.ConnectionUtil;

import java.util.Properties;

public class Driver {
    public static void main(String[] args) {
        Properties properties = ConnectionUtil.getConnectionProperties();
        System.out.println(properties);
        LabDao labDao = new LabDao();
        labDao.create(new Lab(0,"Basic",50));

    }
}
