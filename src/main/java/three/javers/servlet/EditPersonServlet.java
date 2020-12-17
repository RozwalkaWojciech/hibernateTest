package three.javers.servlet;

import three.javers.dto.PersonDto;
import three.javers.service.PersonService;
import three.javers.utils.DateFormatter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/edit-person")
public class EditPersonServlet extends HttpServlet {

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

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        LocalDate birthdate = DateFormatter.localDateFormatter(request.getParameter("birthdate"));

        PersonDto editPersonDto = new PersonDto(name, lastName, birthdate);
        personService.edit(id, editPersonDto);

        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.println(String.format("New person is: %s", editPersonDto.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
