package history;

/**
 * Enum representing different types of violations.
 */
public enum
ViolationType implements IVehicleIncidentType {
  // Moving
  DistractedDriving,
  RecklessDriving,
  Speeding,
  DrivingUnderInfluence,
  FailureToRespectTrafficSigns,
  DrivingWithoutValidLicenseOrInsurance,

  //NonMoving
  ParkingViolation,
  PaperworkIssues,
  ProblemsWithVehicle;

  /**
   * Returns a string representation of the violation type.
   *
   * @return a string representation of the violation type.
   */
  @Override
  public String toString() {
    return switch (this) {
      case DistractedDriving -> "Distracted Driving";
      case RecklessDriving -> "Reckless Driving";
      case Speeding -> "Speeding";
      case DrivingUnderInfluence -> "Driving Under Influence";
      case FailureToRespectTrafficSigns -> "Failure to Respect Traffic Signs";
      case DrivingWithoutValidLicenseOrInsurance -> "Driving Without Valid License or Insurance";
      case ParkingViolation -> "Parking Violation";
      case PaperworkIssues -> "Paperwork Issues";
      case ProblemsWithVehicle -> "Problems with Vehicle";
    };
  }

  /**
   * Checks if the given string belongs to the ViolationType enum.
   *
   * @param enumString the string to check.
   * @return {@code true} if the string belongs to the ViolationType enum, {@code false} otherwise.
   */
  static public boolean belongToEnum(String enumString) {
    for (ViolationType crashType : ViolationType.values()) {
      if (crashType.name().equals(enumString)) {
        return true;
      }
    }
    return false;
  }

}
