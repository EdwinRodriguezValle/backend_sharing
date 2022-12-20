package sharing.com.enjoying.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String username) {
        super( "We could not find a user" + username);

    }

}
