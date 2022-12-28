package Final_assignment.Sharing.Dtos;

public class CommentsDto {
    public Long id;
    public  String title;
    public String comments;

    //Default constructor
    public CommentsDto(){}

    //Constructor
    public CommentsDto(Long id, String title, String comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }

    //Getter

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }
    //Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
