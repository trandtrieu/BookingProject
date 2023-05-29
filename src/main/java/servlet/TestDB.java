/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.TourDao;
import java.util.List;
import model.Tour;


/**
 *
 * @author DELL
 */
public class TestDB {

    /**
     * 19 * @param args the command line arguments 20
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TourDao tourDao = new TourDao();
        List<Tour> l = tourDao.getAllTours();

//        System.out.println("" + l);
                System.out.println("" + l);

    }

}
