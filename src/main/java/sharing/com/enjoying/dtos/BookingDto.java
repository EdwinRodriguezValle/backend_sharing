package sharing.com.enjoying.dtos;

import java.time.LocalDateTime;

public class BookingDto {
    public Long id;
    //Attribute or constructor
    public String serviceType;
    public LocalDateTime date;
    public double price;

    //Default constructor
    public BookingDto(){}

    //Constructor for all the variables
    public BookingDto(Long id, String serviceType, LocalDateTime date, double price) {
        this.id = id;
        this.serviceType = serviceType;
        this.date = date;
        this.price = price;
    }


    //Getters
    public Long getId() {
        return id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }


    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
