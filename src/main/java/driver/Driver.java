package driver;

import history.DriverHistoryItem;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import other.Name;

/**
 * Represents a driver.
 */

public class Driver {

  private Name name;
  private LocalDate birthdate;
  private DriverLicense driverLicense;
  private List<DriverHistoryItem> driverHistories;

  /**
   * Constructor of driver
   *
   * @param name            - driver's name
   * @param birthdate       - driver's birthdate
   * @param driverLicense   - driver's driver licnese
   * @param driverHistories - driver's violation histories
   */
  public Driver(Name name, LocalDate birthdate, DriverLicense driverLicense,
      List<DriverHistoryItem> driverHistories) {
    this.name = name;
    this.birthdate = birthdate;
    this.driverLicense = driverLicense;
    this.driverHistories = driverHistories;
  }

  /**
   * Get driver's name
   *
   * @return driver's name
   */
  public Name getName() {
    return name;
  }

  /**
   * Check whether last name is equals to actual last name
   *
   * @return check result
   */
  public boolean matchLastName(String lastName) {
    return name.getLastName().equals(lastName);
  }

  /**
   * Get birthdate
   *
   * @return driver's birthdate
   */
  public LocalDate getBirthdate() {
    return birthdate;
  }

  /**
   * Get driver's license
   *
   * @return driver's license
   */
  public DriverLicense getDriverLicense() {
    return driverLicense;
  }

  /**
   * Get driver's violation histories
   *
   * @return driver's violation histories
   */
  public List<DriverHistoryItem> getDriverHistories() {
    return driverHistories;
  }

  /**
   * Returns a string representation of the object. In general, the {@code toString} method returns
   * a string that "textually represents" this object. The result should be a concise but
   * informative representation that is easy for a person to read.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Driver{" +
        "name=" + name +
        ", birthdate=" + birthdate +
        ", driverLicense=" + driverLicense +
        ", driverHistories=" + driverHistories +
        '}';
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Driver driver = (Driver) o;
    return Objects.equals(name, driver.name) && Objects.equals(birthdate,
        driver.birthdate) && Objects.equals(driverLicense, driver.driverLicense)
        && Objects.equals(driverHistories, driver.driverHistories);
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, birthdate, driverLicense, driverHistories);
  }
}
