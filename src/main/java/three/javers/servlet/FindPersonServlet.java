package three.javers.servlet;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer id = Integer.getInteger(request.getParameter("id"));

        PrintWriter printWriter = response.getWriter();
        printWriter.println(personService.findById(id));
    }

}
