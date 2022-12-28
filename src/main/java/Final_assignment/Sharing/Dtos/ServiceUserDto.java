package Final_assignment.Sharing.Dtos;

import java.util.Date;

public class ServiceUserDto {
    //Attribute or variable. Type of service that is looking the consumer of the platform.
    private Long id;
    private String typerOfService;
    private String particularInterest;
    private String placeToTravel;
    private Date period;

    //Default constructor
    public ServiceUserDto(){}

    //Constructor
    public ServiceUserDto(Long id, String typerOfService, String particularInterest, String placeToTravel, Date period) {
        this.id = id;
        this.typerOfService = typerOfService;
        this.particularInterest = particularInterest;
        this.placeToTravel = placeToTravel;
        this.period = period;
    }

    //Getters
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


}
