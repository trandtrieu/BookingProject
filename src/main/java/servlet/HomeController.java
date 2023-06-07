package servlet;

import connection.DbCon;
import dao.TourDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Region;
import dao.RegionDao;
import model.Tour;

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TourDao t = new TourDao(DbCon.getConnection());
            RegionDao r = new RegionDao(DbCon.getConnection());

            List<Tour> tours = t.getAllTours();
            List<Region> regions = r.getAllRegions();
            int tourCount = t.getAllToursCount();  // Lấy số lượng tour

            request.getServletContext().setAttribute("myTours", tours);
            request.getServletContext().setAttribute("myRegions", regions);
            request.setAttribute("tourCount", tourCount);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
