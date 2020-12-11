package three.javers.servlet;

import three.javers.dto.PersonDto;
import three.javers.service.PersonService;

import javax.inject.Inject;
import javax.servlet.ServletException;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//TODO check id
        Integer id = Integer.parseInt(request.getParameter("id"));

        PersonDto personById = personService.findById(id);

        PrintWriter printWriter = response.getWriter();
        printWriter.println(String.format("Person by id= %s", personById.toString()));
    }

}
