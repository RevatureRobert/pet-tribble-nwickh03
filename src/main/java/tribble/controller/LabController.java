package tribble.controller;


import com.azul.crs.com.fasterxml.jackson.databind.ObjectMapper;
import tribble.model.Lab;
import tribble.service.LabService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/labs")
public class LabController extends HttpServlet {

    private LabService labService;
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        this.labService = new LabService();

    }

    public LabController(){
        this.labService = new LabService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        labService.create(mapper.readValue(req.getReader().toString(),Lab.class));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getReader().toString().length() == 0)
            resp.getWriter().print(labService.readAll());
        else{

            Integer id = Integer.parseInt(req.getReader().toString());
            resp.getWriter().print(labService.read(id));
        }
    }


}
