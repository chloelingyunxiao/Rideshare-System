package validator;

import application.Application;
import driver.Driver;
import driver.DriverLicense;
import history.CrashType;
import history.DriverHistoryItem;
import history.ViolationType;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import other.Name;
import history.VehicleHistoryItem;
import vehicle.VehicleInformation;
import vehicle.VehicleInsurance;

/**
 * Validator for registration applications.
 */
public class RegistrationValidator implements IRegistrationValidator {

  /**
   * Constants of limit.
   */
  private final Integer MIN_AGE = 21;
  private final Integer MAX_YEAR = 15;
  private final Integer MIN_LICENSE_ISSUE_MONTH = 6;

  /**
   * Acceptable license insurance countries, which is a list.
   */
  private final List<String> acceptedLicenseIssuanceCountries = Arrays.asList("US", "Canada");

  private final List<ViolationType> MovingViolations = Arrays.asList(
      ViolationType.DistractedDriving,
      ViolationType.RecklessDriving,
      ViolationType.Speeding,
      ViolationType.DrivingUnderInfluence,
      ViolationType.FailureToRespectTrafficSigns,
      ViolationType.DrivingWithoutValidLicenseOrInsurance
  );

  /**
   * Disallowed violations list. Consists of several kinds of violation in moving violation.
   */
  private final List<ViolationType> DisallowedViolations = Arrays.asList(
      ViolationType.RecklessDriving,
      ViolationType.Speeding,
      ViolationType.DrivingUnderInfluence,
      ViolationType.DrivingWithoutValidLicenseOrInsurance
  );

  /**
   * Crashes list. The crashes in the list are also not acceptable to be added in the collection.
   */
  private final List<CrashType> Crashes = Arrays.asList(
      CrashType.FenderBender,
      CrashType.CrashWithBodilyInjuries,
      CrashType.CrashWithoutBodilyInjuries
  );

  /**
   * Validates a registration application.
   *
   * @param application The application to be validated.
   * @return True if the application is valid, false otherwise.
   */
  @Override
  public boolean validate(Application application) {
    return validateDriverAge(application)
        && validateLicense(application)
        && validateVehicleInfo(application)
        && validateVehicleInsurance(application)
        && validateDriverHistory(application)
        && validateVehicleHistory(application);
  }

  /**
   * Validates a registration application‘ age.
   *
   * @param application The application to be validated.
   * @return True if the application is valid, false otherwise.
   */
  boolean validateDriverAge(Application application) {
    LocalDate birthdate = application.getDriver().getBirthdate();
    LocalDate currentDate = LocalDate.now();
    Period ageDifference = Period.between(birthdate, currentDate);
    int age = ageDifference.getYears();
    return age >= MIN_AGE;
  }

  /**
   * Validates a registration application license.
   *
   * @param application The application to be validated.
   * @return True if the application is valid, false otherwise.
   */
  boolean validateLicense(Application application) {
    Driver driver = application.getDriver();
    DriverLicense license = driver.getDriverLicense();

    Name prospectivDriverName = driver.getName();
    Name driverLicenseName = license.getName();
    if (!prospectivDriverName.equals(driverLicenseName)) {
      return false;
    }

    LocalDate applicantBirthDate = driver.getBirthdate();
    LocalDate driverLicenseBirthDate = license.getBirthdate();
    if (!applicantBirthDate.equals(driverLicenseBirthDate)) {
      return false;
    }

    // country validation
    String licenseCountry = license.getCountry();
    if (!acceptedLicenseIssuanceCountries.contains(licenseCountry)) {
      return false;
    }

    // Check issuance date
    LocalDate licenseIssuanceDate = license.getIssuanceDate();
    Period issuedTime = Period.between(licenseIssuanceDate, LocalDate.now());
    if (issuedTime.getYears() * 12 + issuedTime.getMonths() + issuedTime.getDays() / 30
        < MIN_LICENSE_ISSUE_MONTH) {
      return false;
    }

    // Check expiration date
    LocalDate licenseExpirationDate = license.getExpirationDate();
    Period expiredTime = Period.between(LocalDate.now(), licenseExpirationDate);
    if (expiredTime.isNegative()) {
      return false;
    }

    return true;
  }

  boolean validateVehicleInfo(Application application) {
    VehicleInformation vehicleInfo = application.getVehicle().getVehicleInformation();

    int vehicleYears = vehicleInfo.getYearOfVehicle();
    if (LocalDate.now().getYear() - vehicleYears > MAX_YEAR) {
      return false;
    }

    return true;
  }

  /**
   * Validates a registration application insurance.
   *
   * @param application The application to be validated.
   * @return True if the application is valid, false otherwise.
   */
  boolean validateVehicleInsurance(Application application) {
    Driver driver = application.getDriver();
    VehicleInsurance vehicleInsurance = application.getVehicle().getVehicleInsurance();

    // Check insured or offical owner
    Name officialOwner = vehicleInsurance.getOfficialOwner();
    // Check whether specific people covered by insurance
    List<Name> insuredDrivers = vehicleInsurance.getPeopleCoveredByInsurance();
    if (!driver.getName().equals(officialOwner) && !insuredDrivers.contains(officialOwner)) {
      return false;
    }

    // Check expiration
    LocalDate expirationDate = vehicleInsurance.getExpirationDate();
    if (expirationDate.isBefore(LocalDate.now())) {
      return false;
    }

    return true;
  }

  boolean validateDriverHistory(Application application) {
    List<DriverHistoryItem> driverViolations = application.getDriver().getDriverHistories();
    for (DriverHistoryItem violation : driverViolations) {
      ViolationType violationType = violation.getViolationType();
      if (DisallowedViolations.contains(violationType)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Validates a registration application history.
   *
   * @param application The application to be validated.
   * @return True if the application is valid, false otherwise.
   */
  boolean validateVehicleHistory(Application application) {
    List<VehicleHistoryItem> vehicleHistories = application.getVehicle().getVehicleHistories();
    for (VehicleHistoryItem vehicleHistoryItem : vehicleHistories) {
      LocalDate violationDate = vehicleHistoryItem.getDate();
      if (violationDate.isBefore(LocalDate.now().minusMonths(6))) {
        continue;
      }

      // Otherwise, check whether the incident type is moving violations or crashes, if yes, return false
      if (MovingViolations.contains(vehicleHistoryItem.getVehicleIncidentType()) ||
          Crashes.contains(vehicleHistoryItem.getVehicleIncidentType())) {
        return false;
      }
    }
    return true;
  }
}
