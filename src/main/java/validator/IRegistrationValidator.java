package validator;

import application.Application;

/**
 * Interface for registration validators.
 */
public interface IRegistrationValidator {

  /**
   * Validates the registration based on the given application.
   *
   * @param application The application to be validated.
   * @return true if the application is valid, false otherwise.
   */
  boolean validate(Application application);
}
