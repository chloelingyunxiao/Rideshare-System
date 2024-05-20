import static java.lang.System.exit;

import application.Application;
import application.RegistrationRecordItem;
import io.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pool.PoolManager;
import validator.RegistrationValidator;
import view.View;

/**
 * The main class for RideShareDriverValidator application. This class serves as the entry point for
 * the RideShareDriverValidator application, providing methods to initialize the application, handle
 * user input, and manage driver registration records.
 */
public class RideShareDriverValidator {

  /**
   * List of registration record items.
   */
  private static List<RegistrationRecordItem> listOfRecords = new ArrayList<>();

  /**
   * The parser for parsing application data.
   */
  private static Parser parser = new Parser(); //

  /**
   * The registration validator for validating driver registration applications.
   */
  private static RegistrationValidator registrationValidator = new RegistrationValidator();

  /**
   * The pool manager for managing driver registration records.
   */
  private static PoolManager poolManager;

  /**
   * The main method of the application. Initializes the validator and enters a loop to handle user
   * input until the user chooses to end the program.
   *
   * @param args The command-line arguments (not used).
   */
  public static void main(String[] args) {
    initializeValidator();
    int userChoice;
    do {
      userChoice = View.getUserChoice();

      if (userChoice == 1) {
        Application application = getInputJsonAndParseApplication();
        handleAddValidApplication(application);
      } else if (userChoice == 2) {
        String lastName = View.getLastNameToSearch();
        handleProvideDriverInformation(lastName);
      } else {
        handleEndProgram(userChoice);
      }
    } while (true);
  }

  /**
   * Initializes the validator components.
   */
  public static void initializeValidator() {
    poolManager = new PoolManager(listOfRecords);
    parser = new Parser();
    registrationValidator = new RegistrationValidator();
  }

  /**
   * Reads input JSON file and parses the application data.
   *
   * @return The parsed application.
   */
  public static Application getInputJsonAndParseApplication() {
    String filePath = View.getInputFilePath();
    try {
      Application application = parser.parseApplicationFromFile(filePath);
      return application;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Handles the addition of a valid driver registration application.
   *
   * @param application The driver registration application to add.
   */
  public static void handleAddValidApplication(Application application) {
    if (registrationValidator.validate(application)) {
      if (poolManager.addRegistrationRecord(application)) {
        System.out.println("Successfully added registration record\n");
      } else {
        System.out.println("Record exists, Failed to add registration record\n");
      }

    } else {
      System.out.println("Application is not valid, "
          + "it can not be registered! Your application is rejected!\n" +
          "You can try again and enter another one application.\n");
    }
  }

  /**
   * Handles the retrieval of driver information based on last name.
   *
   * @param lastName The last name of the driver to search for.
   */
  public static void handleProvideDriverInformation(String lastName) {
    System.out.println(poolManager.provideDriverInfo(lastName));
  }

  /**
   * Handles the termination of the program.
   *
   * @param userChoice The choice made by the user to end the program.
   */
  public static void handleEndProgram(int userChoice) {
    System.out.println("You entered " + userChoice + ". Exiting the system!");
    exit(0);
  }

}
