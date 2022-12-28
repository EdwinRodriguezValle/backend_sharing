package Final_assignment.Sharing.Dtos;

import java.util.Date;

public class UserProfileDto {

    // Attribute or variable
    private Long id;
    private String name;
    private String lastName;
    private String language;
    private String gender;
    private Date birthday;
    private String Address;
    private String email;
    private int telephone;

    //Default constructor
    public  UserProfileDto(){}

    //Constructor
    public UserProfileDto(Long id, String name, String lastName, String language, String gender, Date birthday, String address, String email, int telephone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
        this.gender = gender;
        this.birthday = birthday;
        Address = address;
        this.email = email;
        this.telephone = telephone;
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

    public int getTelephone() {
        return telephone;
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

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
