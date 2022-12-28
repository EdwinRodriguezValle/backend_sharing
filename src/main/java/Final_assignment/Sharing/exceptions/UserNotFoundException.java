package Final_assignment.Sharing.exceptions;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public UserNotFoundException() {
    }

    public UserNotFoundException(String username) {
        super("We could not find a user" + username);
    }

}
