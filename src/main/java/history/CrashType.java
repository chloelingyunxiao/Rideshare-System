package history;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Enum representing different types of crashes.
 */
public enum CrashType implements IVehicleIncidentType {
  FenderBender,

  CrashWithoutBodilyInjuries,

  CrashWithBodilyInjuries;

  /**
   * Returns a string representation of the crash type.
   *
   * @return a string representation of the crash type.
   */
  @Override
  public String toString() {
    return switch (this) {
      case FenderBender -> "Fender Bender";
      case CrashWithoutBodilyInjuries -> "Crash Without Bodily Injuries";
      case CrashWithBodilyInjuries -> "Crash With Bodily Injuries";
    };
  }

  /**
   * Checks if the given string belongs to the CrashType enum.
   *
   * @param enumString the string to check.
   * @return {@code true} if the string belongs to the CrashType enum, {@code false} otherwise.
   */
  static public boolean belongToEnum(String enumString) {
    List<CrashType> crashTypes = new ArrayList<>();

    crashTypes.add(FenderBender);
    crashTypes.add(CrashWithBodilyInjuries);
    crashTypes.add(CrashWithoutBodilyInjuries);
    Iterator<CrashType> crashTypeIterator = crashTypes.iterator();
    while (crashTypeIterator.hasNext()) {
      if (crashTypeIterator.next().name().equals(enumString)) {
        return true;
      }
    }
    return false;
  }
}
