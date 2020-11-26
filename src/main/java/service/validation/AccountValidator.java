package service.validation;


import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AccountValidator {

    private static final String AMOUNT_OF_MONEY_VALIDATION = "^[0-9]*\\.?[0-9]*";
    private static final String NUMBER_VALIDATION = "^[0-9]*$";
    private static final String SAVINGS_ACCOUNT_VALIDATION = "SAVINGS";
    private static final String CURRENT_ACCOUNT_VALIDATION = "CURRENT";
    private static final int CNP_LENGTH = 13;
    private final Account account;
    private final List<String> errors;

    public AccountValidator(Account account) {
        this.account = account;
        this.errors = new ArrayList<>();
    }

    public List<String> getErrors() { return errors;}

    public boolean validate() {
        validateAmountOfMoney(account.getAmountOfMoney());
        validateType(account.getType());
        validateCnp(account.getCustomerCnp());
        return errors.isEmpty();
    }

    private void validateType(String type) {
        if(!Pattern.compile(SAVINGS_ACCOUNT_VALIDATION).matcher(type).matches() &&
            !Pattern.compile(CURRENT_ACCOUNT_VALIDATION).matcher(type).matches()) {
                errors.add("Please choose one of two options: CURRENT/SAVING");
        }
    }

    private void validateAmountOfMoney(Double amount) {
        if (!Pattern.compile(AMOUNT_OF_MONEY_VALIDATION).matcher(amount.toString()).matches()) {
            errors.add("Invalid Amount of Money!");
        }
    }

    private void validateCnp(String cnp) {
        if(!Pattern.compile(NUMBER_VALIDATION).matcher(cnp).matches()) {
            errors.add("Invalid Cnp!");
        } else if(cnp.length() != CNP_LENGTH) {
            errors.add("Cnp too short!");
        }

    }


}
