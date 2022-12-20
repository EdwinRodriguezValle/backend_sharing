package sharing.com.enjoying.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class ServiceUserDto {


    //Attribute or constructor
    public Long id;
    public String typerOfService;
    public String particularInterest;
    public String placeToTravel;
    public Date period;

    public ServiceUserDto() {
    }
    //Constructor with all the attribute

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
