/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Hotel {
    private int id;
    private String hotelName;
    private int hotelStar;
    private String hotelImage;
    private String hotelDetail;

    public Hotel(int id, String hotelName, int hotelStar, String hotelImage, String hotelDetail) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelStar = hotelStar;
        this.hotelImage = hotelImage;
        this.hotelDetail = hotelDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelDetail() {
        return hotelDetail;
    }

    public void setHotelDetail(String hotelDetail) {
        this.hotelDetail = hotelDetail;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", hotelName=" + hotelName + ", hotelStar=" + hotelStar + ", hotelImage=" + hotelImage + ", hotelDetail=" + hotelDetail + '}';
    }
    
    
    
    
    
}
