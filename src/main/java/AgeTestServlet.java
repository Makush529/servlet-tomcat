import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class AgeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();

        String ageParam = req.getParameter("age");
        if (ageParam == null || ageParam.isEmpty()) {
            writer.write("<html><body><h1>Возраст не указан</h1></body></html>");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageParam);
        } catch (NumberFormatException e) {
            writer.write("<html><body><h1>Некорректно указан возраст</h1></body></html>");
            return;
        }

        String result = (age >= 18) ? "Вы совершеннолетний" : "Вы несовершеннолетний";

        writer.write("<html><body>");
        writer.write("<h1 style='text-align: center;'>" + result + "</h1>");
        writer.write("</body></html>");
        writer.close();
    }

}
