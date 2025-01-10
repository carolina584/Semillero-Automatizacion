package co.tweek.qa.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;
public class ManagerTask extends SerenityManagedException {

    public static final String MESSAGE_EXCEPTION_ELEMENT = "not enable element";

    public ManagerTask(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }
}
