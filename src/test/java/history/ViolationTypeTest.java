package history;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ViolationTypeTest {

  @Test
  public void testToString() {
    assertEquals("Distracted Driving", ViolationType.DistractedDriving.toString());
    assertEquals("Reckless Driving", ViolationType.RecklessDriving.toString());
    assertEquals("Speeding", ViolationType.Speeding.toString());
    assertEquals("Driving Under Influence", ViolationType.DrivingUnderInfluence.toString());
    assertEquals("Failure to Respect Traffic Signs",
        ViolationType.FailureToRespectTrafficSigns.toString());
    assertEquals("Driving Without Valid License or Insurance",
        ViolationType.DrivingWithoutValidLicenseOrInsurance.toString());
    assertEquals("Parking Violation", ViolationType.ParkingViolation.toString());
    assertEquals("Paperwork Issues", ViolationType.PaperworkIssues.toString());
    assertEquals("Problems with Vehicle", ViolationType.ProblemsWithVehicle.toString());
  }

  @Test
  public void testBelongToEnum() {
    assertTrue(ViolationType.belongToEnum("DistractedDriving"));
    assertTrue(ViolationType.belongToEnum("RecklessDriving"));
    assertTrue(ViolationType.belongToEnum("Speeding"));
    assertTrue(ViolationType.belongToEnum("DrivingUnderInfluence"));
    assertTrue(ViolationType.belongToEnum("FailureToRespectTrafficSigns"));
    assertTrue(ViolationType.belongToEnum("DrivingWithoutValidLicenseOrInsurance"));
    assertTrue(ViolationType.belongToEnum("ParkingViolation"));
    assertTrue(ViolationType.belongToEnum("PaperworkIssues"));
    assertTrue(ViolationType.belongToEnum("ProblemsWithVehicle"));

    assertFalse(ViolationType.belongToEnum("NonExistingViolationType"));
  }

}