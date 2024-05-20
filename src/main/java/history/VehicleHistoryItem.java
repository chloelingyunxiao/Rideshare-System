package history;

import java.time.LocalDate;
import java.util.Objects;
import other.Name;

/**
 * Represents a history item for a vehicle, indicating an incident.
 */
public class VehicleHistoryItem extends HistoryItem {

  private IVehicleIncidentType vehicleIncidentType;
  private Name offendingDriverName;

  /**
   * Constructs a new VehicleHistoryItem with the specified date, vehicle incident type, and
   * offending driver name.
   *
   * @param date                the date of the incident.
   * @param vehicleIncidentType the type of the vehicle incident.
   * @param offendingDriverName the name of the offending driver.
   */
  public VehicleHistoryItem(LocalDate date, IVehicleIncidentType vehicleIncidentType,
      Name offendingDriverName) {
    super(date);
    this.vehicleIncidentType = vehicleIncidentType;
    this.offendingDriverName = offendingDriverName;
  }

  /**
   * Retrieves the type of vehicle incident.
   *
   * @return the type of vehicle incident.
   */
  public IVehicleIncidentType getVehicleIncidentType() {
    return vehicleIncidentType;
  }

  /**
   * Retrieves the name of the offending driver.
   *
   * @return the name of the offending driver.
   */
  public Name getOffendingDriverName() {
    return offendingDriverName;
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
    VehicleHistoryItem that = (VehicleHistoryItem) o;
    return Objects.equals(vehicleIncidentType, that.vehicleIncidentType)
        && Objects.equals(offendingDriverName, that.offendingDriverName);
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleIncidentType, offendingDriverName);
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
    return "VehicleHistoryItem{" +
        "vehicleIncidentType=" + vehicleIncidentType +
        ", offendingDriverName=" + offendingDriverName +
        '}';
  }
}
