package vehicle;

import driver.Driver;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import other.Name;


/**
 * Represents insurance information for a vehicle.
 */
public class VehicleInsurance {

  private Name officialOwner;
  private List<Name> peopleCoveredByInsurance;
  private LocalDate expirationDate;

  /**
   * Constructor of VehicleInsurance.
   *
   * @param officialOwner            the insurance official owner
   * @param peopleCoveredByInsurance the people's names list, who covered by insurance
   * @param expirationDate           insurance expiration date.
   */
  public VehicleInsurance(Name officialOwner,
      List<Name> peopleCoveredByInsurance, LocalDate expirationDate) {
    this.officialOwner = officialOwner;
    this.peopleCoveredByInsurance = peopleCoveredByInsurance;
    this.expirationDate = expirationDate;
  }

  /**
   * Get the insurance official owner
   *
   * @return the insurance official owner
   */
  public Name getOfficialOwner() {
    return officialOwner;
  }

  /**
   * Get the people's names list, who covered by insurance
   *
   * @return people's names list, who covered by insurance
   */
  public List<Name> getPeopleCoveredByInsurance() {
    return peopleCoveredByInsurance;
  }

  /**
   * Get insurance expiration date
   *
   * @return insurance expiration date
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
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
    VehicleInsurance that = (VehicleInsurance) o;
    return Objects.equals(officialOwner, that.officialOwner) && Objects.equals(
        peopleCoveredByInsurance,
        that.peopleCoveredByInsurance) && Objects.equals(expirationDate,
        that.expirationDate);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return A hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(officialOwner, peopleCoveredByInsurance,
        expirationDate);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return A string representation of the VehicleInformation object.
   */
  @Override
  public String toString() {
    return "VehicleInsurance{" +
        "officialOwner=" + officialOwner +
        ", peopleCoveredByInsuranceLicenseUniqueNumbers="
        + peopleCoveredByInsurance +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
