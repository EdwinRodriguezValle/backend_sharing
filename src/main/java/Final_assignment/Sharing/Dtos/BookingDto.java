package Final_assignment.Sharing.Dtos;

import Final_assignment.Sharing.models.ServiceProviderModel;
import Final_assignment.Sharing.models.ServiceUserModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.time.LocalDateTime;
import java.util.Collection;

public class BookingDto {

    public Long id;
    public String serviceType;
    public LocalDateTime entranceDate;
    public LocalDateTime departureDate;
    public double price;

    //Default constructor
    public BookingDto(){}
    //Constructors

    public BookingDto(Long id, String serviceType, LocalDateTime entranceDate, LocalDateTime departureDate, double price) {
        this.id = id;
        this.serviceType = serviceType;
        this.entranceDate = entranceDate;
        this.departureDate = departureDate;
        this.price = price;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDateTime getEntranceDate() {
        return entranceDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public double getPrice() {
        return price;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setEntranceDate(LocalDateTime entranceDate) {
        this.entranceDate = entranceDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
