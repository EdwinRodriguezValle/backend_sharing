package sharing.com.enjoying.dtos;

public class RatingAndCommentsDto {

    //Attribute or variables
    public Long id;
    public int rate;
    public String comments;

    //Default constructor
    public RatingAndCommentsDto(){}


    //One constructor for all the attributes
    public RatingAndCommentsDto(Long id, int rate, String comments) {
        this.id = id;
        this.rate = rate;
        this.comments = comments;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public String getComments() {
        return comments;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
