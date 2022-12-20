package sharing.com.enjoying.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BookingModel implements Serializable {
   //Auto generated id
    @Id
    @GeneratedValue
     Long id;

    //Attribute or variable
    private String serviceType;
    private LocalDateTime date;
    private double price;

    // Relaciones with ServiceUser
    @ManyToMany(mappedBy = "bookingModel", fetch = FetchType.LAZY)
    private Set<ServiceUserModel> serviceUserModels = new HashSet<>();

    // Relaciones with ServiceProvider

    @ManyToMany(mappedBy = "bookingModels", fetch = FetchType.LAZY)
    private Set<ServiceProviderModel> serviceProviderModels = new HashSet<>();



    // Default constructor
    public BookingModel(){}

    //One constructor for all the attribute
    public BookingModel(Long id, String serviceType, LocalDateTime date, double price) {
        this.id = id;
        this.serviceType = serviceType;
        this.date = date;
        this.price = price;
    }

    //Getters


    public Set<ServiceUserModel> getServiceUserModels() {
        return serviceUserModels;
    }

    public Set<ServiceProviderModel> getServiceProviderModels() {
        return serviceProviderModels;
    }

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

    //Generate Setters


    public void setServiceUserModels(Set<ServiceUserModel> serviceUserModels) {
        this.serviceUserModels = serviceUserModels;
    }

    public void setServiceProviderModels(Set<ServiceProviderModel> serviceProviderModels) {
        this.serviceProviderModels = serviceProviderModels;
    }

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
