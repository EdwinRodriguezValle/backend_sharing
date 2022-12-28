package Final_assignment.Sharing.Dtos;

public class RatingDto {

    //Attribute or variable
    public Long id;
    public String title;
    public int points; //from cero till ten.

    //Default constructor
    public RatingDto(){}

    //Constructors
    public RatingDto(Long id, String title, int points) {
        this.id = id;
        this.title = title;
        this.points = points;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPoints() {
        return points;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
