package other;

import java.util.Objects;

/**
 * Represents a person's name, consisting of a first name and a last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructs a Name object with the specified first name and last name.
   *
   * @param firstName the first name of the person.
   * @param lastName  the last name of the person.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name of the person.
   *
   * @return the first name of the person.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name of the person.
   *
   * @return the last name of the person.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare.
   * @return true if this object is the same as the o argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name diverName = (Name) o;
    return Objects.equals(firstName, diverName.firstName) && Objects.equals(
        lastName, diverName.lastName);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns the string representation of the Name object.
   *
   * @return a string representation of the Name object.
   */
  @Override
  public String toString() {
    return "DiverName{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
