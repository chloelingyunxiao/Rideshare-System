package history;

import java.time.LocalDate;

/**
 * Represents an abstract history item with a date.
 */
public abstract class HistoryItem {

  /**
   * The date of the history item.
   */
  LocalDate date;

  /**
   * Constructs a new HistoryItem with the specified date.
   *
   * @param date the date of the history item.
   */
  public HistoryItem(LocalDate date) {
    this.date = date;
  }

  /**
   * Retrieves the date of the history item.
   *
   * @return the date of the history item.
   */
  public LocalDate getDate() {
    return date;
  }
}
