package Final_assignment.Sharing.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class ServiceUserModel  extends UserProfileModel{
    //Auto generated id
    @Id
    @GeneratedValue
    private Long id;

    //Attribute or variable. Type of service that is looking the consumer of the platform.
    private String typerOfService;
    private String particularInterest;
    private String placeToTravel;
    private Date period;

    //RELATIONS

    //ManyToMany relation with BookingModel
    @ManyToMany(mappedBy = "serviceUserModels")
    private Collection<BookingModel> bookingModels;


    //ManyToMany relation with RatingModel
    @ManyToMany(mappedBy = "serviceUserModels")
    private Collection<RatingModel> ratingModels;

    //ManyToMany relation with CommentsModel
    @ManyToMany(mappedBy = "serviceUserModels")
    private Collection<CommentsModel> commentsModels;

    //OneToOne relation with ServiceUserModel
    @OneToOne(mappedBy = "serviceUserModel")
    UserProfileModel userProfileModel;

    //Default constructor
    public ServiceUserModel(){}

    //Constructors

    public ServiceUserModel(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email, int telephone, RoleModel roleModel, ServiceUserModel serviceUserModel, ServiceProviderModel serviceProviderModel, Long id1, String typerOfService, String particularInterest, String placeToTravel, Date period, Collection<BookingModel> bookingModels, Collection<RatingModel> ratingModels, Collection<CommentsModel> commentsModels, UserProfileModel userProfileModel) {
        super(id, name, lastName, language, gender, birthday, address, email, telephone, roleModel, serviceUserModel, serviceProviderModel);
        this.id = id1;
        this.typerOfService = typerOfService;
        this.particularInterest = particularInterest;
        this.placeToTravel = placeToTravel;
        this.period = period;
        this.bookingModels = bookingModels;
        this.ratingModels = ratingModels;
        this.commentsModels = commentsModels;
        this.userProfileModel = userProfileModel;
    }

    //Getters

    @Override
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

    public Collection<BookingModel> getBookingModels() {
        return bookingModels;
    }

    public Collection<RatingModel> getRatingModels() {
        return ratingModels;
    }

    public Collection<CommentsModel> getCommentsModels() {
        return commentsModels;
    }

    public UserProfileModel getUserProfileModel() {
        return userProfileModel;
    }

    //Setters

    @Override
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

    public void setBookingModels(Collection<BookingModel> bookingModels) {
        this.bookingModels = bookingModels;
    }

    public void setRatingModels(Collection<RatingModel> ratingModels) {
        this.ratingModels = ratingModels;
    }

    public void setCommentsModels(Collection<CommentsModel> commentsModels) {
        this.commentsModels = commentsModels;
    }

    public void setUserProfileModel(UserProfileModel userProfileModel) {
        this.userProfileModel = userProfileModel;
    }

}
