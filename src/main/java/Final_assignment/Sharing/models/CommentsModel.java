package Final_assignment.Sharing.models;

import jakarta.persistence.*;

import java.util.Collection;
//import javax.persistence.*;
@Entity
public class CommentsModel {
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    // Attribute or variable
    private  String title;
    private String comments;

    //ManyToMany relation with ServiceUserModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceUserModel> serviceUserModels;

    //ManyToMany relation with ServiceProviderModel
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ServiceProviderModel> serviceProviderModels;

    // Default constructor
    public CommentsModel(){}

    //Constructors
    public CommentsModel(Long id, String title, String comments, Collection<ServiceUserModel> serviceUserModels, Collection<ServiceProviderModel> serviceProviderModels) {
        this.id = id;
        this.title = title;
        this.comments = comments;
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

    public String getComments() {
        return comments;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setServiceUserModels(Collection<ServiceUserModel> serviceUserModels) {
        this.serviceUserModels = serviceUserModels;
    }

    public void setServiceProviderModels(Collection<ServiceProviderModel> serviceProviderModels) {
        this.serviceProviderModels = serviceProviderModels;
    }
}
