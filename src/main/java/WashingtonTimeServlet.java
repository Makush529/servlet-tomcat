import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/washington")
public class WashingtonTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer= resp.getWriter();
        ZonedDateTime beijingTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = beijingTime.format(formatter);

        writer.write("<!DOCTYPE html>\n");
        writer.write("<html lang=\"en\">\n");
        writer.write("<head>\n");
        writer.write("    <meta charset=\"UTF-8\">\n");
        writer.write("    <title>Текущее время</title>\n");
        writer.write("    <link rel=\"stylesheet\" href=\"/../styles/stylesCity.css\">\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("    <h1>Текущее время в <span id=\"city\"> Вашингтоне </span>: <span id=\"time\">" + formattedTime + "</span></h1>\n");
        writer.write("</body>\n");
        writer.write("</html>\n");
        writer.close();
    }
}