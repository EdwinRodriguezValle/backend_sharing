package Final_assignment.Sharing.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserProfileModel {
    //Auto generated value
    @Id
    @GeneratedValue
    private Long id;

    // Attribute or variable
    private String name;
    private String lastName;
    private String language;
    private String gender;
    private Date birthday;
    private String address;
    private String email;
    private int telephone;

    //ManyToOne relation with RoleModel
    @ManyToOne
    @JoinColumn(name = "role_id")
    RoleModel roleModel;

//   OneToOne relation with ServiceUserModel
    @OneToOne
    ServiceUserModel serviceUserModel;

// OneToOne relation with ServiceProviderModel
    @OneToOne
    ServiceProviderModel serviceProviderModel;

    //Default constructor
    public UserProfileModel(){}

    //Constructor for each attribute
    public UserProfileModel(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email, int telephone, RoleModel roleModel, ServiceUserModel serviceUserModel, ServiceProviderModel serviceProviderModel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.roleModel = roleModel;
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
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public RoleModel getRoleModel() {
        return roleModel;
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
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    public void setServiceUserModel(ServiceUserModel serviceUserModel) {
        this.serviceUserModel = serviceUserModel;
    }

    public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
        this.serviceProviderModel = serviceProviderModel;
    }
}
