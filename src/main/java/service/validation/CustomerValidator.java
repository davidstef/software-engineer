package service.validation;

import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerValidator {

    private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String NUMBER_VALIDATION = "^[0-9]*$";
    private static final String LETTERS_VALIDATION = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    private static final int CNP_LENGTH = 13;
    private final Customer customer;
    private final List<String> errors;

    public CustomerValidator(Customer customer) {
        this.customer = customer;
        this.errors = new ArrayList<>();
    }

    public List<String> getErrors() { return errors;}

    public boolean validate() {
        validateCnpAndPhoneNumber(customer.getCnp(), customer.getPhoneNumber());
        validateEmail(customer.getEmail());
        validateName(customer.getName());
        return errors.isEmpty();
    }

    private void validateCnpAndPhoneNumber(String cnp, String phoneNumber) {
        if(!Pattern.compile(NUMBER_VALIDATION).matcher(cnp).matches()) {
            errors.add("Invalid Cnp!");
        } else if(cnp.length() != CNP_LENGTH) {
            errors.add("Cnp too short!");
        }
        if(!Pattern.compile(NUMBER_VALIDATION).matcher(phoneNumber).matches()) {
            errors.add("Invalid Phone Number!");
        }
    }

    private void validateName(String name) {
        if (!Pattern.compile(LETTERS_VALIDATION).matcher(name).matches()) {
            errors.add("Invalid Name!");
        }
    }

    private void validateEmail(String email) {
        if (!Pattern.compile(EMAIL_VALIDATION_REGEX).matcher(email).matches()) {
            errors.add("Invalid email!");
        }
    }




}
