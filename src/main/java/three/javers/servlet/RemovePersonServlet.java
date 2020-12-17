package three.javers.servlet;

import three.javers.service.PersonService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/remove-person")
public class RemovePersonServlet extends HttpServlet {

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

        boolean remove = personService.remove(id);

        try (PrintWriter printWriter = response.getWriter()) {
            if (remove) {
                printWriter.println(String.format("Person by id %s is remove", id));
            } else {
                printWriter.println(String.format("Person by id %s is not remove", id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
