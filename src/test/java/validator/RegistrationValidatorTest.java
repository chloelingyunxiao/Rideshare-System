package validator;

import static org.junit.jupiter.api.Assertions.*;

import application.Application;
import io.Parser;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationValidatorTest {

  @Test
  void testValidateDriverAge() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test1_JohnDoe_age2.json");
    assertFalse(registrationValidator.validateDriverAge(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateDriverAge(applicationOriginal));
  }

  @Test
  void testValidateLicenseNameDifference() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test2_JohnDoe_nameDifference.json");
    assertFalse(registrationValidator.validateLicense(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(applicationOriginal.getDriver().getName()
        .equals(applicationOriginal.getDriver().getDriverLicense().getName()));

    assertTrue(registrationValidator.validateLicense(applicationOriginal));
  }

  @Test
  void testValidateLicenseBirthdateDifference() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test3_JohnDoe_birthdateDifference.json");
    assertFalse(registrationValidator.validateLicense(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateLicense(applicationOriginal));
  }

  @Test
  void testValidateLicenseCountryDifference() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test4_JohnDoe_countryDifference.json");
    assertFalse(registrationValidator.validateLicense(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateLicense(applicationOriginal));
  }

  @Test
  void testValidateLicenseDateOfIssuanceLessThan6Months() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test5_JohnDoe_dateOfIssuanceLessThan6Months.json");
    assertFalse(registrationValidator.validateLicense(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateLicense(applicationOriginal));
  }

  @Test
  void testValidateLicenseExpirationDate() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test6_JohnDoe_licenseExpired.json");
    assertFalse(registrationValidator.validateLicense(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateLicense(applicationOriginal));
  }

  @Test
  void testValidateVehicleInformation() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test7_JohnDoe_vehicleYearOver15.json");
    assertFalse(registrationValidator.validateVehicleInfo(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateVehicleInfo(applicationOriginal));
  }

  @Test
  void testValidateVehicleInsuranceOwnerOrCoveredPeople() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test9_JohnDoe_notOwnerOrCoveredPeople.json");
    assertFalse(registrationValidator.validateVehicleInsurance(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateVehicleInsurance(applicationOriginal));

  }

  @Test
  void testValidateVehicleInsuranceExpired() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test10_JohnDoe_insuranceExpired.json");
    assertFalse(registrationValidator.validateVehicleInsurance(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateVehicleInsurance(applicationOriginal));

  }


  @Test
  void testValidateDriverHistory() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile(
        "./resources/test/test11_JohnDoe_recklessDriving.json");
    assertFalse(registrationValidator.validateDriverHistory(application));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateDriverHistory(applicationOriginal));

  }

  @Test
  void testValidateVehicleHistory() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();

    Application application1 = parser.parseApplicationFromFile(
        "./resources/test/test12_JohnDoe_crashesLessThan6Months.json");
    assertFalse(registrationValidator.validateVehicleHistory(application1));

    Application application2 = parser.parseApplicationFromFile(
        "./resources/test/test13_JohnDoe_movingViolationLessThan6Months.json");
    assertFalse(registrationValidator.validateVehicleHistory(application2));

    Application application3 = parser.parseApplicationFromFile(
        "./resources/test/test14_JohnDoe_movingViolationOver6Months.json");
    assertTrue(registrationValidator.validateVehicleHistory(application3));

    Application applicationOriginal = parser.parseApplicationFromFile(
        "./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validateVehicleHistory(applicationOriginal));

  }

  @Test
  void testValidate() throws IOException {
    Parser parser = new Parser();
    RegistrationValidator registrationValidator = new RegistrationValidator();
    Application application = parser.parseApplicationFromFile("./resources/test/JohnDoe.json");
    assertTrue(registrationValidator.validate(application));
  }
}