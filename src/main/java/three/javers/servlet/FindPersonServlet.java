package three.javers.servlet;

import three.javers.dto.PersonDto;
import three.javers.service.PersonService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-person")
public class FindPersonServlet extends HttpServlet {

    @Inject
    PersonService personService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Integer id = null;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        PersonDto personById = personService.findById(id);

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.println(String.format("Person by id= %s", personById.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
