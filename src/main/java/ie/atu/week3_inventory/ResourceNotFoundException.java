package ie.atu.week3_inventory;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message); // Pass the message to the superclass constructor
    }
}
