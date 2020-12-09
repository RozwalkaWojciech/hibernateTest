package three.javers.servlet;

import three.javers.model.Person;
import three.javers.service.PersonService;
import three.javers.utils.DateFormatter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/save-person")
public class SavePersonServlet extends HttpServlet {

    @Inject
    PersonService personService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        LocalDate birthday = DateFormatter.localDateFormatter(request.getParameter("birthdate"));

        Person person = new Person(name, lastName, birthday);
        personService.savePerson(person);

        PrintWriter printWriter = response.getWriter();
        printWriter.println(String.format("Person saved: %s", person.toString()));
    }

}
