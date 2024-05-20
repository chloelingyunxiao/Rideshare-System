package application;

import driver.Driver;
import java.util.Objects;
import vehicle.Vehicle;

/**
 * Represents a registration record item containing information about a driver and a vehicle.
 */

public class RegistrationRecordItem {

  private Driver driver;
  private Vehicle vehicle;

  /**
   * Constructs a new RegistrationRecordItem with the specified driver and vehicle.
   *
   * @param driver  the driver associated with this record item.
   * @param vehicle the vehicle associated with this record item.
   */
  public RegistrationRecordItem(Driver driver, Vehicle vehicle) {
    this.driver = driver;
    this.vehicle = vehicle;
  }

  /**
   * Retrieves the driver associated with this record item.
   *
   * @return the driver associated with this record item.
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Retrieves the vehicle associated with this record item.
   *
   * @return the vehicle associated with this record item.
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Checks if this record item is the same as the specified application.
   *
   * @param application the application to compare with.
   * @return {@code true} if this record item is the same as the application, {@code false}
   * otherwise.
   */
  public boolean isSameAsApplication(Application application) {
    return this.driver.equals(application.getDriver()) && this.vehicle.equals(
        application.getVehicle());
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
    RegistrationRecordItem that = (RegistrationRecordItem) o;
    return Objects.equals(driver, that.driver) && Objects.equals(vehicle,
        that.vehicle);
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(driver, vehicle);
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
    return "acceptedRecord{" +
        "driver=" + driver +
        ", vehicle=" + vehicle +
        '}';
  }
}
