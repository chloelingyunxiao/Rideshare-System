package driver;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import other.Name;

/**
 * Represents driver license's information
 */
public class DriverLicense {

  private Integer licenseUniqueNumber;
  private Name name;
  private String address;
  private LocalDate birthdate;
  private String country;
  private String stateOfInsurance;

  private LocalDate issuanceDate;

  private LocalDate expirationDate;

  /**
   * Constructor of driver license
   *
   * @param licenseUniqueNumber driver license number, which is a unique number
   * @param name                - driver's name
   * @param address             - driver's address
   * @param birthdate           driver's birthdate
   * @param country             driver's country
   * @param stateOfInsurance    driver's state of insurance
   * @param issuanceDate        driver's license issuance date
   * @param expirationDate      driver's license expiration date
   */
  public DriverLicense(Integer licenseUniqueNumber, Name name, String address, LocalDate birthdate,
      String country, String stateOfInsurance, LocalDate issuanceDate, LocalDate expirationDate) {
    this.licenseUniqueNumber = licenseUniqueNumber;
    this.name = name;
    this.address = address;
    this.birthdate = birthdate;
    this.country = country;
    this.stateOfInsurance = stateOfInsurance;
    this.issuanceDate = issuanceDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Getter method. Get license unique number
   *
   * @return license unique number
   */
  public Integer getLicenseUniqueNumber() {
    return licenseUniqueNumber;
  }

  /**
   * Getter method. Get license name
   *
   * @return license name
   */
  public Name getName() {
    return name;
  }

  /**
   * Getter method. Get driver's address
   *
   * @return driver's address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Getter method. Get driver's birthdate
   *
   * @return driver's birthdate
   */
  public LocalDate getBirthdate() {
    return birthdate;
  }

  /**
   * Getter method. Get driver's country
   *
   * @return driver's country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Getter method. Get driver's state of insurance
   *
   * @return driver's state of insurance
   */
  public String getStateOfInsurance() {
    return stateOfInsurance;
  }

  /**
   * Getter method. Get driver license issuance date
   *
   * @return driver license issuance date
   */
  public LocalDate getIssuanceDate() {
    return issuanceDate;
  }

  /**
   * Getter method. Get driver license expiration date
   *
   * @return driver license expiration date
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
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
    DriverLicense that = (DriverLicense) o;
    return Objects.equals(licenseUniqueNumber, that.licenseUniqueNumber)
        && Objects.equals(name, that.name) && Objects.equals(address,
        that.address) && Objects.equals(birthdate, that.birthdate)
        && Objects.equals(country, that.country) && Objects.equals(
        stateOfInsurance, that.stateOfInsurance) && Objects.equals(issuanceDate,
        that.issuanceDate) && Objects.equals(expirationDate, that.expirationDate);
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(licenseUniqueNumber, name, address, birthdate, country, stateOfInsurance,
        issuanceDate, expirationDate);
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
    return "DriverLicense{" +
        "licenseUniqueNumber=" + licenseUniqueNumber +
        ", name=" + name +
        ", address='" + address + '\'' +
        ", birthdate=" + birthdate +
        ", country='" + country + '\'' +
        ", stateOfInsurance='" + stateOfInsurance + '\'' +
        ", issuanceDate=" + issuanceDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
