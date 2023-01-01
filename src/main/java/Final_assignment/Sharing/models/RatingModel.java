package Final_assignment.Sharing.models;

import jakarta.persistence.*;
//import javax.persistence.*;

import java.util.Collection;

@Entity
public class RatingModel {
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    //Attribute or variable
    private String title;
    private int points; //from cero till ten.

    //ManyToMany relation with ServiceUserModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceUserModel> serviceUserModels;

    //ManyToMany relation with ServiceProviderModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceProviderModel> serviceProviderModels;

    //Default constructor
    public RatingModel (){}

    // Constructor for each one.

    public RatingModel(Long id, String title, int points, Collection<ServiceUserModel> serviceUserModels, Collection<ServiceProviderModel> serviceProviderModels) {
        this.id = id;
        this.title = title;
        this.points = points;
        this.serviceUserModels = serviceUserModels;
        this.serviceProviderModels = serviceProviderModels;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }

    public Collection<ServiceUserModel> getServiceUserModels() {
        return serviceUserModels;
    }

    public Collection<ServiceProviderModel> getServiceProviderModels() {
        return serviceProviderModels;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setServiceUserModels(Collection<ServiceUserModel> serviceUserModels) {
        this.serviceUserModels = serviceUserModels;
    }

    public void setServiceProviderModels(Collection<ServiceProviderModel> serviceProviderModels) {
        this.serviceProviderModels = serviceProviderModels;
    }
}
