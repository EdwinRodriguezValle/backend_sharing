package sharing.com.enjoying.dtos;


import java.util.Date;

public class UserProfileDto {

    //Attribute or variables
    public Long id;
    public String name;
    public String lastName;
    public String language;
    public String gender;
    public Date birthday;
    public String Address;
    public String email;


    //Default constructor
    public UserProfileDto(){}

    // Constructor with all the attributes

    public UserProfileDto(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.birthday = birthday;
        Address = address;
        this.email = email;
    }

    // All the getters

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

    // All the setters

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

}
