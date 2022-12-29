package Final_assignment.Sharing.exceptions;

public class UsernameNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
