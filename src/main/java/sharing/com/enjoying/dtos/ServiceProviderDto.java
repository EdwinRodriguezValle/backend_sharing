package sharing.com.enjoying.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ServiceProviderDto {

    // Attribute or constructor
    public Long id;
    public String rentFamiliarHouse;

    public String rentRoomAtFamiliarHouse;
    public String rentHostel;
    public String rentHotel;
    public String rentPrivateHouse;
    public  String price;


    //Default constructor
    public ServiceProviderDto(){}

    //Constructor with all the attribute
    public ServiceProviderDto(Long id, String rentFamiliarHouse, String rentRoomAtFamiliarHouse, String rentHostel, String rentHotel, String rentPrivateHouse, String price) {
        this.id = id;
        this.rentFamiliarHouse = rentFamiliarHouse;
        this.rentRoomAtFamiliarHouse = rentRoomAtFamiliarHouse;
        this.rentHostel = rentHostel;
        this.rentHotel = rentHotel;
        this.rentPrivateHouse = rentPrivateHouse;
        this.price = price;
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


}
