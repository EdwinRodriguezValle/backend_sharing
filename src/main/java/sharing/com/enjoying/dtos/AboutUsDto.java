package sharing.com.enjoying.dtos;

public class AboutUsDto {
    public Long id;
    public String description;

    //Default constructor
    public AboutUsDto(){};

    //Constructor
    public AboutUsDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
