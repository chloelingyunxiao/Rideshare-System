package vehicle;

import java.util.Objects;
import other.Name;

/**
 * Represents information about a vehicle.
 */
public class VehicleInformation {

  private String make;
  private String model;
  private Integer yearOfVehicle;
  private Name owner;
  private String color;
  private String licensePlateNumber;

  /**
   * Constructs a VehicleInformation object.
   *
   * @param make               The make of the vehicle.
   * @param model              The model of the vehicle.
   * @param yearOfVehicle      The year of the vehicle.
   * @param owner              The owner of the vehicle.
   * @param color              The color of the vehicle.
   * @param licensePlateNumber The license plate number of the vehicle.
   */
  public VehicleInformation(String make, String model, Integer yearOfVehicle, Name owner,
      String color, String licensePlateNumber) {
    this.make = make;
    this.model = model;
    this.yearOfVehicle = yearOfVehicle;
    this.owner = owner;
    this.color = color;
    this.licensePlateNumber = licensePlateNumber;
  }

  /**
   * Retrieves the make of the vehicle.
   *
   * @return The make of the vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * Retrieves the model of the vehicle.
   *
   * @return The model of the vehicle.
   */
  public String getModel() {
    return model;
  }

  /**
   * Retrieves the year of the vehicle.
   *
   * @return The year of the vehicle.
   */
  public Integer getYearOfVehicle() {
    return yearOfVehicle;
  }

  /**
   * Retrieves the owner of the vehicle.
   *
   * @return The owner of the vehicle.
   */
  public Name getOwner() {
    return owner;
  }

  /**
   * Retrieves the color of the vehicle.
   *
   * @return The color of the vehicle.
   */
  public String getColor() {
    return color;
  }

  /**
   * Retrieves the license plate number of the vehicle.
   *
   * @return The license plate number of the vehicle.
   */
  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o The reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleInformation that = (VehicleInformation) o;
    return Objects.equals(make, that.make) && Objects.equals(model, that.model)
        && Objects.equals(yearOfVehicle, that.yearOfVehicle) && Objects.equals(
        owner, that.owner) && Objects.equals(color, that.color) && Objects.equals(
        licensePlateNumber, that.licensePlateNumber);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return A hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(make, model, yearOfVehicle, owner, color, licensePlateNumber);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return A string representation of the VehicleInformation object.
   */
  @Override
  public String toString() {
    return "VehicleInformation{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", yearOfVehicle=" + yearOfVehicle +
        ", owner=" + owner +
        ", color='" + color + '\'' +
        ", licensePlateNumber='" + licensePlateNumber + '\'' +
        '}';
  }
}
