package history;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a history item for a driver, indicating a violation.
 */
public class DriverHistoryItem extends HistoryItem {

  /**
   * Represents a history item for a driver, indicating a violation.
   */
  private final ViolationType violationType;

  /**
   * Constructs a new DriverHistoryItem with the specified date and violation type.
   *
   * @param date          the date of the violation.
   * @param violationType the type of violation.
   */

  public DriverHistoryItem(LocalDate date, ViolationType violationType) {
    super(date);
    this.violationType = violationType;
  }

  /**
   * Get the date of the violation.
   *
   * @return the date of the violation.
   */
  public LocalDate getViolationDate() {
    return date;
  }

  /**
   * Retrieves the type of violation.
   *
   * @return the type of violation.
   */
  public ViolationType getViolationType() {
    return violationType;
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
    DriverHistoryItem that = (DriverHistoryItem) o;
    return Objects.equals(date, that.date)
        && violationType == that.violationType;
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(date, violationType);
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
    return "DriverHistoryItem{" +
        "violationDate=" + date +
        ", violationType=" + violationType +
        '}';
  }
}