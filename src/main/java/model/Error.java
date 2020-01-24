package model;

public enum Error {
    CONTACT_IS_NOT_VALID("Contact is not valid"),
    CONTACT_ALREADY_EXISTS("Contact already exists"),
    CONTACT_IS_NOT_FOUND("Contact is not found");

    private String error;

    Error(String error) {
        this.error = error;
    }
}
