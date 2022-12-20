package sharing.com.enjoying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserProfileModel {
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    //Attribute o variables
    private String name;
    private String lastName;
    private String language;
    private String gender;
    private Date birthday;
    private String Address;
    private String email;

    //Relations many to one with UserProfile with ServiceUser

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ServiceUser_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ServiceUserModel serviceUserModel;

    //Relations many to one with UserProfile with ServiceProvider

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ServiceProvider_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ServiceProviderModel serviceProviderModel;


    //Default constrcutor
    public UserProfileModel(){}

    //One constructor for all the attribute

    public UserProfileModel(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email, ServiceUserModel serviceUserModel, ServiceProviderModel serviceProviderModel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.birthday = birthday;
        Address = address;
        this.email = email;
        this.serviceUserModel = serviceUserModel;
        this.serviceProviderModel = serviceProviderModel;
    }


    //Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }

    public ServiceUserModel getServiceUserModel() {
        return serviceUserModel;
    }

    public ServiceProviderModel getServiceProviderModel() {
        return serviceProviderModel;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setServiceUserModel(ServiceUserModel serviceUserModel) {
        this.serviceUserModel = serviceUserModel;
    }

    public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
        this.serviceProviderModel = serviceProviderModel;
    }

}
