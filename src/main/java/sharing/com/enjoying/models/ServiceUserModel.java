package sharing.com.enjoying.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceUserModel implements Serializable {
    //Auto generated value
    @Id
    @GeneratedValue
    private Long id;

    //Default constructor
    private String typerOfService;
    private String particularInterest;
    private String placeToTravel;
    private Date period;

    //Relation with booking
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceUserModel_Booking",
            joinColumns = {
                    @JoinColumn(name = "ServiceUserModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "BookingModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @JsonIgnore

    private Set<BookingModel> bookingModel = new HashSet<>();

    //Relation with rating&comment
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceUserModel_rating&comment",
            joinColumns = {
                    @JoinColumn(name = "ServiceUserModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "RatingAndCommentsModel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @JsonIgnore

    private Set<RatingAndCommentsModel> ratingAndCommentsModels = new HashSet<>();


//    //Default constructor
//    public ServiceUserModel(){}
//
//    //One constructor for all the attribute o variables
//
//    public ServiceUserModel(Long id, String typerOfService, String particularInterest, String placeToTravel, Date period, Set<BookingModel> bookingModel, Set<RatingAndCommentsModel> ratingAndCommentsModels) {
//        this.id = id;
//        this.typerOfService = typerOfService;
//        this.particularInterest = particularInterest;
//        this.placeToTravel = placeToTravel;
//        this.period = period;
//        this.bookingModel = bookingModel;
//        this.ratingAndCommentsModels = ratingAndCommentsModels;
//    }


    // Getter

    public Long getId() {
        return id;
    }

    public String getTyperOfService() {
        return typerOfService;
    }

    public String getParticularInterest() {
        return particularInterest;
    }

    public String getPlaceToTravel() {
        return placeToTravel;
    }

    public Date getPeriod() {
        return period;
    }

    public Set<BookingModel> getBookingModel() {
        return bookingModel;
    }

    public Set<RatingAndCommentsModel> getRatingAndCommentsModels() {
        return ratingAndCommentsModels;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTyperOfService(String typerOfService) {
        this.typerOfService = typerOfService;
    }

    public void setParticularInterest(String particularInterest) {
        this.particularInterest = particularInterest;
    }

    public void setPlaceToTravel(String placeToTravel) {
        this.placeToTravel = placeToTravel;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public void setBookingModel(Set<BookingModel> bookingModel) {
        this.bookingModel = bookingModel;
    }

    public void setRatingAndCommentsModels(Set<RatingAndCommentsModel> ratingAndCommentsModels) {
        this.ratingAndCommentsModels = ratingAndCommentsModels;
    }
}
