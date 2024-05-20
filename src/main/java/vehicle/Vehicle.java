package vehicle;

import history.VehicleHistoryItem;
import java.util.List;
import java.util.Objects;

/**
 * Represents a vehicle.
 */
public class Vehicle {

  private VehicleInformation vehicleInformation;

  private VehicleInsurance vehicleInsurance;

  private List<VehicleHistoryItem> vehicleHistories;

  /**
   * Constructs a Vehicle object.
   *
   * @param vehicleInformation The information about the vehicle.
   * @param vehicleInsurance   The insurance details of the vehicle.
   * @param vehicleHistories   The history items associated with the vehicle.
   */
  public Vehicle(VehicleInformation vehicleInformation, VehicleInsurance vehicleInsurance,
      List<VehicleHistoryItem> vehicleHistories) {
    this.vehicleInformation = vehicleInformation;
    this.vehicleInsurance = vehicleInsurance;
    this.vehicleHistories = vehicleHistories;
  }

  /**
   * Retrieves the information about the vehicle.
   *
   * @return The VehicleInformation object containing information about the vehicle.
   */
  public VehicleInformation getVehicleInformation() {
    return vehicleInformation;
  }

  /**
   * Retrieves the insurance details of the vehicle.
   *
   * @return The VehicleInsurance object containing insurance details.
   */
  public VehicleInsurance getVehicleInsurance() {
    return vehicleInsurance;
  }

  /**
   * Retrieves the history items associated with the vehicle.
   *
   * @return A list of VehicleHistoryItem objects representing the vehicle's history.
   */
  public List<VehicleHistoryItem> getVehicleHistories() {
    return vehicleHistories;
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
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(vehicleInformation, vehicle.vehicleInformation)
        && Objects.equals(vehicleInsurance, vehicle.vehicleInsurance)
        && Objects.equals(vehicleHistories, vehicle.vehicleHistories);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return A hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleInformation, vehicleInsurance, vehicleHistories);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return A string representation of the Vehicle object.
   */
  @Override
  public String toString() {
    return "Vehicle{" +
        "vehicleInformation=" + vehicleInformation +
        ", vehicleInsurance=" + vehicleInsurance +
        ", vehicleHistories=" + vehicleHistories +
        '}';
  }
}

