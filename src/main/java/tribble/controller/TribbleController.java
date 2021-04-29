package tribble.controller;

import com.azul.crs.com.fasterxml.jackson.databind.ObjectMapper;
import tribble.model.Tribble;
import tribble.service.TribbleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/tribbles")
public class TribbleController extends HttpServlet {

    private TribbleService tribbleService;
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        tribbleService.create(mapper.readValue(req.getReader().toString(),Tribble.class));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")== null)
            resp.getWriter().print(tribbleService.readAll());
        else{

            Integer id = Integer.parseInt(req.getParameter("id"));
            resp.getWriter().print(tribbleService.read(id));
        }

    }
}
