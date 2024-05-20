package driver;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import other.Name;

class DriverLicenseTest {

  private DriverLicense license;
  private Integer expectedNumber;
  private Name name;
  private LocalDate birthdate;
  private String address;
  private String country;
  private String stateOfInsurance;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;

  @BeforeEach
  public void setUp() {
    expectedNumber = 123456789;
    name = new Name("John", "Doe");
    birthdate = LocalDate.of(1990, 5, 15);
    address = "123 Main St";
    country = "USA";
    stateOfInsurance = "California";
    issuanceDate = LocalDate.of(2020, 1, 1);
    expirationDate = LocalDate.of(2025, 12, 31);

    license = new DriverLicense(expectedNumber, name, address, birthdate,
        country, stateOfInsurance, issuanceDate, expirationDate);
  }

  @Test
  public void testGetLicenseUniqueNumber() {
    assertEquals(expectedNumber, license.getLicenseUniqueNumber());
  }

  @Test
  public void testGetName() {
    assertEquals(name, license.getName());
  }

  @Test
  public void testGetAddress() {
    assertEquals(address, license.getAddress());
  }

  @Test
  public void testGetState() {
    assertEquals(stateOfInsurance, license.getStateOfInsurance());

  }
}