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

@WebServlet("/save-person")
public class SavePersonServlet extends HttpServlet {

    @Inject
    PersonService personService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        if (!year.equals("") && !month.equals("") && !day.equals("")) {
            String birthdate = year + "-" + month + "-" + day;
            LocalDate birthday = DateFormatter.localDateFormatter(birthdate);

            PersonDto personDto = new PersonDto(name, lastName, birthday);
            personService.savePerson(personDto);

            try (PrintWriter printWriter = response.getWriter()) {
                printWriter.println(String.format("Person saved: %s", personDto.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
