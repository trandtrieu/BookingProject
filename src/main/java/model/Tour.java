/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Tour {
    private int tourId;
    private String tourName;
    private float price;
    private Date dateStart;
    private Date dateEnd;
    private String detailTour;
    private String imageTour;
    private Boolean statusTour;
    private String placeName;
    private String hotelName;
    private String regionName;
    private int numberDay;

    public Tour(int tourId, String tourName, float price, Date dateStart, Date dateEnd, String detailTour, String imageTour, Boolean statusTour, String placeName, String hotelName, String regionName) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.detailTour = detailTour;
        this.imageTour = imageTour;
        this.statusTour = statusTour;
        this.placeName = placeName;
        this.hotelName = hotelName;
        this.regionName = regionName;
    }
    



    public Tour(int tourId, String tourName, float price, Date dateStart, Date dateEnd, String detailTour, String imageTour, Boolean statusTour, String placeName, String hotelName) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.detailTour = detailTour;
        this.imageTour = imageTour;
        this.statusTour = statusTour;
        this.placeName = placeName;
        this.hotelName = hotelName;
    }



    public Tour(int tourId, String tourName, float price, Date dateStart, Date dateEnd, String detailTour, String imageTour, Boolean statusTour, String placeName, String hotelName, String regionName, int numberDay) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.detailTour = detailTour;
        this.imageTour = imageTour;
        this.statusTour = statusTour;
        this.placeName = placeName;
        this.hotelName = hotelName;
        this.regionName = regionName;
        this.numberDay = numberDay;
    }

    
    
    public int getNumberDay() {
        return numberDay;
    }

    

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

 
    public Tour() {
    }



    
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDetailTour() {
        return detailTour;
    }

    public void setDetailTour(String detailTour) {
        this.detailTour = detailTour;
    }

    public String getImageTour() {
        return imageTour;
    }

    public void setImageTour(String imageTour) {
        this.imageTour = imageTour;
    }

    public Boolean getStatusTour() {
        return statusTour;
    }

    public void setStatusTour(Boolean statusTour) {
        this.statusTour = statusTour;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

   

    @Override
    public String toString() {
        return "Tour{" + "tourId=" + tourId + ", tourName=" + tourName + ", price=" + price + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", detailTour=" + detailTour + ", imageTour=" + imageTour + ", statusTour=" + statusTour + ", placeName=" + placeName + ", hotelName=" + hotelName + '}';
    }

    
}