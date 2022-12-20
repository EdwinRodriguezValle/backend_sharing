package sharing.com.enjoying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceProviderModel implements Serializable {
    @Id
    @GeneratedValue
    Long id;

    //Attribute or variables
    private String rentFamiliarHouse;
    private String rentRoomAtFamiliarHouse;
    private String rentHostel;
    private String rentHotel;
    private String rentPrivateHouse;
    private String price;



    //Relation with booking
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceProviderModel_BookingModel",
            joinColumns = {
                    @JoinColumn(name = "ServiceProviderModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "BookingModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @JsonIgnore

    private Set<BookingModel> bookingModels = new HashSet<>();

    //Relation with rating&comments

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceProviderModel_CommentsAndRating",
            joinColumns = {
                    @JoinColumn(name = "ServiceProviderModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "CommentAndRating_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @JsonIgnore
    private Set<RatingAndCommentsModel> ratingAndCommentsModels = new HashSet<>();


    //Default constructor
    public ServiceProviderModel(){}

    //One constructor for all the attribute

    public ServiceProviderModel(Long id, String rentFamiliarHouse, String rentRoomAtFamiliarHouse, String rentHostel, String rentHotel, String rentPrivateHouse, String price, Set<BookingModel> bookingModels, Set<RatingAndCommentsModel> ratingAndCommentsModels) {
        this.id = id;
        this.rentFamiliarHouse = rentFamiliarHouse;
        this.rentRoomAtFamiliarHouse = rentRoomAtFamiliarHouse;
        this.rentHostel = rentHostel;
        this.rentHotel = rentHotel;
        this.rentPrivateHouse = rentPrivateHouse;
        this.price = price;
        this.bookingModels = bookingModels;
        this.ratingAndCommentsModels = ratingAndCommentsModels;
    }


    //Getters

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

    public Set<BookingModel> getBookingModels() {
        return bookingModels;
    }

    public Set<RatingAndCommentsModel> getRatingAndCommentsModels() {
        return ratingAndCommentsModels;
    }


    //Setters

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

    public void setBookingModels(Set<BookingModel> bookingModels) {
        this.bookingModels = bookingModels;
    }

    public void setRatingAndCommentsModels(Set<RatingAndCommentsModel> ratingAndCommentsModels) {
        this.ratingAndCommentsModels = ratingAndCommentsModels;
    }
}
