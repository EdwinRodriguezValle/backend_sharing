package sharing.com.enjoying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RatingAndCommentsModel implements Serializable{
    //Auto generated value
    @Id
    @GeneratedValue
    Long id;

    //Attribute or variables
    private int rate;
    private String comments;

    //Relations with ServiceUser
    @ManyToMany(mappedBy = "ratingAndCommentsModels", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ServiceUserModel> serviceUserModels = new HashSet<>();

    //Relation with ServiceProvider
    @ManyToMany(mappedBy = "ratingAndCommentsModels", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ServiceProviderModel> serviceProviderModels = new HashSet<>();


    //Default constructor
    public RatingAndCommentsModel(){}

    //One constructor for all the attributes

    public RatingAndCommentsModel(Long id, int rate, String comments, Set<ServiceUserModel> serviceUserModels, Set<ServiceProviderModel> serviceProviderModels) {
        this.id = id;
        this.rate = rate;
        this.comments = comments;
        this.serviceUserModels = serviceUserModels;
        this.serviceProviderModels = serviceProviderModels;
    }


    //Getters

    public Long getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getComments() {
        return comments;
    }

    public Set<ServiceUserModel> getServiceUserModels() {
        return serviceUserModels;
    }

    public Set<ServiceProviderModel> getServiceProviderModels() {
        return serviceProviderModels;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setServiceUserModels(Set<ServiceUserModel> serviceUserModels) {
        this.serviceUserModels = serviceUserModels;
    }

    public void setServiceProviderModels(Set<ServiceProviderModel> serviceProviderModels) {
        this.serviceProviderModels = serviceProviderModels;
    }
}
