package Final_assignment.Sharing.models;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class BookingModel {
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    //Attribute or variable
    private String serviceType;
    private LocalDateTime entranceDate;
    private LocalDateTime departureDate;
    private double price;

    //ManyToMany relation with ServiceUserModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceUserModel> serviceUserModels;

    //ManyToMany relation with ServiceProviderModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceProviderModel> serviceProviderModels;

    //Default constructor
    public BookingModel(){}

    //Constructors
    public BookingModel(Long id, String serviceType, LocalDateTime entranceDate, LocalDateTime departureDate, double price, Collection<ServiceUserModel> serviceUserModels, Collection<ServiceProviderModel> serviceProviderModels) {
        this.id = id;
        this.serviceType = serviceType;
        this.entranceDate = entranceDate;
        this.departureDate = departureDate;
        this.price = price;
        this.serviceUserModels = serviceUserModels;
        this.serviceProviderModels = serviceProviderModels;
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

    public Collection<ServiceUserModel> getServiceUserModels() {
        return serviceUserModels;
    }

    public Collection<ServiceProviderModel> getServiceProviderModels() {
        return serviceProviderModels;
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

    public void setServiceUserModels(Collection<ServiceUserModel> serviceUserModels) {
        this.serviceUserModels = serviceUserModels;
    }

    public void setServiceProviderModels(Collection<ServiceProviderModel> serviceProviderModels) {
        this.serviceProviderModels = serviceProviderModels;
    }
}
