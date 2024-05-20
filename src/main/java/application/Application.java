package application;

import driver.Driver;
import java.util.Objects;
import vehicle.Vehicle;

/**
 * Application is a class that represents a new record application. It is a possible record to be
 * stored in pool. It stores information of driver and vehicle.
 */
public class Application {

  private Driver driver;
  private Vehicle vehicle;

  /**
   * Constructor of Application
   *
   * @param driver
   * @param vehicle
   */
  public Application(Driver driver, Vehicle vehicle) {
    this.driver = driver;
    this.vehicle = vehicle;
  }

  /**
   * Get driver object
   *
   * @return - driver object
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Get vehicle object
   *
   * @return - vehicle object
   */
  public Vehicle getVehicle() {
    return vehicle;
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
    Application that = (Application) o;
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
    return "Application{" +
        "driver=" + driver +
        ", vehicle=" + vehicle +
        '}';
  }
}
