package view;

import java.awt.print.Printable;
import java.util.List;
import java.util.Scanner;

/**
 * Provides methods for user interaction and input/output operations.
 */
public class View {

  /**
   * Prompts the user to enter a file path for input.
   *
   * @return The user-entered file path.
   */
  public static String getInputFilePath() {
    Scanner scanner = new Scanner(System.in);
    String path;
    do {

      System.out.println(
          "Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)");
      path = scanner.nextLine();
    } while (!isPathValid(path));
    return path;
  }

  /**
   * Checks if the entered file path is valid.
   *
   * @param path The file path to validate.
   * @return True if the path is valid, false otherwise.
   */
  public static boolean isPathValid(String path) {
    String regex = "^(/|./|../)?(?:[a-zA-Z0-9_ -]+/)*[a-zA-Z0-9_ -]+\\.json$";
    boolean matches = path.matches(regex);
    if (!matches) {
      System.out.println("Invalid path! Please try again.");
    } else {
      System.out.println("Path is valid.");
    }
    return matches;
  }

  /**
   * Prompts the user to enter their choice.
   *
   * @return The user's choice as an integer.
   */
  public static int getUserChoice() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=======================");
    System.out.println("Please enter your choice: (Enter 1, 2 or 3) \n"
        + "1. Validate application and add\n"
        + "2. Search and display according last name\n"
        + "3. Exit");
    int userChoice = scanner.nextInt();
    return userChoice;
  }

  /**
   * Prompts the user to enter a last name for search.
   *
   * @return The last name entered by the user.
   */
  public static String getLastNameToSearch() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter last name to be searched and display: ");
    String lastName = scanner.nextLine();
    return lastName;
  }

  /**
   * Converts a list to a string with newline as separators.
   *
   * @param list The list to be converted.
   * @param <T>  The type of elements in the list.
   * @return The string representation of the list.
   */
  public static <T> String listToString(List<T> list) {
    StringBuilder listString = new StringBuilder();
    for (T item : list) {
      listString.append(item.toString());
    }
    return listString.toString();
  }
}
