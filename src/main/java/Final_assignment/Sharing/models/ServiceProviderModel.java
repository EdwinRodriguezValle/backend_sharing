package Final_assignment.Sharing.models;

import jakarta.persistence.*;
//import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class ServiceProviderModel extends UserProfileModel{
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    //Attribute or constructor
    private String rentFamiliarHouse;
    private String rentRoomAtFamiliarHouse;
    private String rentHostel;
    private String rentHotel;
    private String rentPrivateHouse;
    private String price;

    //ServiceProviderModel
    //ManyToMany relation with BookingModel
    @ManyToMany(mappedBy = "serviceProviderModels")
    private Collection<BookingModel> bookingModels;


    //ManyToMany relation with RatingModel
    @ManyToMany(mappedBy = "serviceProviderModels")
    private Collection<RatingModel> ratingModels;

    //OneToOne relation with ServiceProviderModel
    @OneToOne(mappedBy = "serviceProviderModel")
    ServiceProviderModel serviceProviderModel;

    //Default constructor
    public ServiceProviderModel(){}

    //Constructors for all of attribute

    public ServiceProviderModel(Long id, String rentFamiliarHouse, String rentRoomAtFamiliarHouse, String rentHostel, String rentHotel, String rentPrivateHouse, String price, Collection<BookingModel> bookingModels, Collection<RatingModel> ratingModels, ServiceProviderModel serviceProviderModel) {
        this.id = id;
        this.rentFamiliarHouse = rentFamiliarHouse;
        this.rentRoomAtFamiliarHouse = rentRoomAtFamiliarHouse;
        this.rentHostel = rentHostel;
        this.rentHotel = rentHotel;
        this.rentPrivateHouse = rentPrivateHouse;
        this.price = price;
        this.bookingModels = bookingModels;
        this.ratingModels = ratingModels;
        this.serviceProviderModel = serviceProviderModel;
    }

    public ServiceProviderModel(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email, int telephone, ServiceUserModel serviceUserModel, ServiceProviderModel serviceProviderModel, Long id1, String rentFamiliarHouse, String rentRoomAtFamiliarHouse, String rentHostel, String rentHotel, String rentPrivateHouse, String price, Collection<BookingModel> bookingModels, Collection<RatingModel> ratingModels, ServiceProviderModel serviceProviderModel1) {
        super(id, name, lastName, language, gender, birthday, address, email, telephone, serviceUserModel, serviceProviderModel);
        this.id = id1;
        this.rentFamiliarHouse = rentFamiliarHouse;
        this.rentRoomAtFamiliarHouse = rentRoomAtFamiliarHouse;
        this.rentHostel = rentHostel;
        this.rentHotel = rentHotel;
        this.rentPrivateHouse = rentPrivateHouse;
        this.price = price;
        this.bookingModels = bookingModels;
        this.ratingModels = ratingModels;
        this.serviceProviderModel = serviceProviderModel1;
    }


    //Getters

    @Override
    public Long getId() {
        return id;
    }

    public String getRentFamiliarHouse() {
        return rentFamiliarHouse;
    }

    public String getRentRoomAtFamiliarHouse() {
        return rentRoomAtFamiliarHouse;
    }

    public String getRentHostel() {
        return rentHostel;
    }

    public String getRentHotel() {
        return rentHotel;
    }

    public String getRentPrivateHouse() {
        return rentPrivateHouse;
    }

    public String getPrice() {
        return price;
    }

    public Collection<BookingModel> getBookingModels() {
        return bookingModels;
    }

    public Collection<RatingModel> getRatingModels() {
        return ratingModels;
    }

    @Override
    public ServiceProviderModel getServiceProviderModel() {
        return serviceProviderModel;
    }

    //Setters


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setRentFamiliarHouse(String rentFamiliarHouse) {
        this.rentFamiliarHouse = rentFamiliarHouse;
    }

    public void setRentRoomAtFamiliarHouse(String rentRoomAtFamiliarHouse) {
        this.rentRoomAtFamiliarHouse = rentRoomAtFamiliarHouse;
    }

    public void setRentHostel(String rentHostel) {
        this.rentHostel = rentHostel;
    }

    public void setRentHotel(String rentHotel) {
        this.rentHotel = rentHotel;
    }

    public void setRentPrivateHouse(String rentPrivateHouse) {
        this.rentPrivateHouse = rentPrivateHouse;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBookingModels(Collection<BookingModel> bookingModels) {
        this.bookingModels = bookingModels;
    }

    public void setRatingModels(Collection<RatingModel> ratingModels) {
        this.ratingModels = ratingModels;
    }

    @Override
    public void setServiceProviderModel(ServiceProviderModel serviceProviderModel) {
        this.serviceProviderModel = serviceProviderModel;
    }
}
