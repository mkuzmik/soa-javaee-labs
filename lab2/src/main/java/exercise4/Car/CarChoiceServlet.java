package exercise4.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex4")
public class CarChoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarType type = parseType(req.getParameter("car-type"));
        int[] range = parsePriceRange(req.getParameter("price-range"));

        PrintWriter writer = resp.getWriter();

        Car car = CarChoiceHelper.selectCar(type, range[0], range[1]);

        writer.write("You should buy " + car.toString());
        writer.close();
    }

    private CarType parseType(String type) {
        switch (type) {
            case "city": return CarType.CITY;
            case "sport": return CarType.SPORT;
            case "premium": return CarType.PREMIUM;
            default: return CarType.SPORT;
        }
    }

    int[] parsePriceRange(String range) {
        String trimmed = range.trim();
        int[] ranges = new int[2];
        int mid = trimmed.indexOf(":");
        ranges[0] = Integer.valueOf(range.substring(0, mid));
        ranges[1] = Integer.valueOf(range.substring(mid+1));

        return ranges;
    }
}
