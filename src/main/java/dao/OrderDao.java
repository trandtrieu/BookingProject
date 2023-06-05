/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BookTour;
import model.Tour;

/**
 *
 * @author DELL
 */
public class OrderDao {

    private Connection con;

    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDao(Connection con) {
        this.con = con;
    }

    public OrderDao() {
    }

    public boolean insertOrder(BookTour model) {
        boolean result = false;
        try {
            query = "insert into orders(p_id, u_id, o_quantity, o_date, o_cusName, o_address, o_phone, o_email) values(?,?,?,?,?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getOrderId());
            pst.setInt(2, model.getUser_id());
            pst.setInt(3, model.getQuantityAd());
            pst.setInt(4, model.getQuantityChildren());
            pst.setString(5, model.getDate());
            pst.setString(6, model.getAddress());
            pst.setString(7, model.getName());
            pst.setString(8, model.getPhone());
            pst.setString(9, model.getEmail());
            pst.setString(10, model.getNote());

            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<BookTour> userOrders(int id) {
        List<BookTour> list = new ArrayList<>();
        try {
            query = "select * from orders where u_id=? order by orders.o_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                BookTour order = new BookTour();
                TourDao tourDao = new TourDao(this.con);
                int pId = rs.getInt("t_id");
                Tour tour = TourDao.getTourByID("t_id");
                order.setOrderId(rs.getInt("o_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice() * rs.getInt("o_quantity"));
                order.setQuantity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                order.setAddress(rs.getString("o_address"));
                order.setCusName(rs.getString("o_cusName"));
                order.setPhone(rs.getString("o_phone"));
                order.setEmail(rs.getString("o_email"));

                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
}
