/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connection.DbCon;
import dao.OrderDao;
import jakarta.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AccountDTO;
import model.BookTour;
import model.EmailSender;
import model.Tour;

/**
 *
 * @author DELL
 */
public class BookingServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int adults = Integer.parseInt(request.getParameter("adults"));
        int children = Integer.parseInt(request.getParameter("children"));
        String note = request.getParameter("note");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        AccountDTO acc = (AccountDTO) request.getSession().getAttribute("acc");

        if (acc != null) {
            try {
                request.setAttribute("acc", acc);
                String tourId = request.getParameter("id");
                BookTour orderModel = new BookTour();
                orderModel.setOrderId(Integer.parseInt(tourId));
                orderModel.setUser_id(acc.getId());
                orderModel.setQuantityAd(adults);
                orderModel.setQuantityChildren(children);
                orderModel.setAddress(address);
                orderModel.setName(fullName);
                orderModel.setPhone(phone);
                orderModel.setEmail(email);
                orderModel.setNote(note);
                orderModel.setDate(formatter.format(date));
                OrderDao orderDao = new OrderDao(DbCon.getConnection());
                boolean result = orderDao.insertOrder(orderModel);

                if (result) {
                    try {
                        
                        EmailSender.sendConfirmationEmail(email, orderModel);
                        request.getRequestDispatcher("orderSuccess.jsp").forward(request, response);
                    } catch (MessagingException ex) {
                        // Xử lý lỗi gửi email
                        ex.printStackTrace();
                        response.getWriter().println("Failed to send confirmation email");
                    }
                } else {
                    response.getWriter().println("Order failed");
                }
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect("Login");
            return;
        }
    }

}
