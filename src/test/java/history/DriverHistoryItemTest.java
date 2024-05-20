package history;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class DriverHistoryItemTest {

  @Test
  void getViolationDate() {
    LocalDate violationDate = LocalDate.of(2020, 1, 1);
    ViolationType violationType = ViolationType.DistractedDriving;
    DriverHistoryItem driverHistoryItem = new DriverHistoryItem(violationDate, violationType);
    assertEquals(violationDate, driverHistoryItem.getViolationDate());
  }
}