package history;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CrashTypeTest {

  @Test
  public void testToString() {
    assertEquals("Fender Bender", CrashType.FenderBender.toString());
    assertEquals("Crash Without Bodily Injuries", CrashType.CrashWithoutBodilyInjuries.toString());
    assertEquals("Crash With Bodily Injuries", CrashType.CrashWithBodilyInjuries.toString());
  }

  @Test
  public void testBelongToEnum() {
    assertTrue(CrashType.belongToEnum("FenderBender"));
    assertTrue(CrashType.belongToEnum("CrashWithoutBodilyInjuries"));
    assertTrue(CrashType.belongToEnum("CrashWithBodilyInjuries"));

    assertFalse(CrashType.belongToEnum("NonExistingCrashType"));
  }
}