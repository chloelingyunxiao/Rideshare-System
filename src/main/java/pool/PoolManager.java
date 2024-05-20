package pool;

import application.Application;
import application.RegistrationRecordItem;
import driver.Driver;
import history.DriverHistoryItem;
import history.ViolationType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import vehicle.Vehicle;
import view.View;

/**
 * Manages the pool of registered drivers and their registration records.
 */
public class PoolManager {

  /**
   * List of registration record items.
   */
  private List<RegistrationRecordItem> registeredRecords;

  /**
   * Constructor of PoolManager.
   */
  public PoolManager(List<RegistrationRecordItem> registeredRecords) {
    this.registeredRecords = registeredRecords;
  }

  /**
   * Get registered records list.
   *
   * @return registered records list
   */
  public List<RegistrationRecordItem> getRegisteredRecords() {
    return registeredRecords;
  }

  /**
   * Check whether the record is existing in the list.
   *
   * @param possibleRecord possible record to be added
   * @return boolean, check result
   */
  private boolean recordExists(Application possibleRecord) {
    if (registeredRecords.isEmpty()) {
      return false;
    }

    for (RegistrationRecordItem record : registeredRecords) {
      if (record.isSameAsApplication(possibleRecord)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Add possible record to the registered records list.
   *
   * @param possibleRecord the application to be added
   * @return whether the adding method is run successfully
   */
  public boolean addRegistrationRecord(Application possibleRecord) {
    if (recordExists(possibleRecord)) {
      return false;
    }

    registeredRecords.add(
        new RegistrationRecordItem(possibleRecord.getDriver(), possibleRecord.getVehicle()));
    return true;
  }


  public String provideDriverInfo(String lastName) {
    List<String> infos = new ArrayList<>();

    List<RegistrationRecordItem> recordsFilterByLastName = this.getRegisteredRecords().stream()
        .filter(record -> record.getDriver().getName().getLastName().equals(lastName))
        .collect(Collectors.toList());

    if (recordsFilterByLastName.isEmpty()) {
      infos.add(
          "No registered driver found with last name: " + lastName
      );
      return View.listToString(infos);
    }

    // Aggragte records by drivers
    HashMap<Driver, List<Vehicle>> driverVehicleHashMap = new HashMap<>();
    for (RegistrationRecordItem record : recordsFilterByLastName) {
      Driver driver = record.getDriver();
      if (!driverVehicleHashMap.containsKey(driver)) {
        driverVehicleHashMap.put(driver, new ArrayList<>());
      }
      driverVehicleHashMap.get(driver).add(record.getVehicle());
    }

    // sort driver by first name
    var drivers = new ArrayList<Driver>(driverVehicleHashMap.keySet());
    drivers.sort(Comparator.comparing(driver -> driver.getName().getFirstName()));

    StringBuilder info = new StringBuilder();
    for (Driver driver : drivers) {
      infos.add(extractDriverInfo(driver, driverVehicleHashMap.get(driver)));
    }

    return View.listToString(infos);
  }

  /**
   * Append vehicle information in a string
   *
   * @param record a specific record in registered records list.
   * @return a string, which stores the information of a vehicle
   */
  private static String extractDriverInfo(Driver driver, List<Vehicle> vehicles) {
    StringBuilder info = new StringBuilder();

    // append driver's name
    info.append(driver.getName().getLastName())
        .append(", ").append(driver.getName().getFirstName()).append("\n");

    // append vehicle's information
    for (Vehicle vehicle : vehicles) {
      info.append("    ").append(vehicle.getVehicleInformation().getYearOfVehicle())
          .append(" ").append(vehicle.getVehicleInformation().getColor())
          .append(" ").append(vehicle.getVehicleInformation().getMake())
          .append(" ").append(vehicle.getVehicleInformation().getModel())
          .append(", ").append(vehicle.getVehicleInformation().getLicensePlateNumber())
          .append("\n");
    }

    // append driving violation records
    List<DriverHistoryItem> driverHistories = driver.getDriverHistories();
    if (!driverHistories.isEmpty()) {
      info.append("    Driving violations:\n");
      for (DriverHistoryItem driverHistoryItem : driverHistories) {
        info.append("    ").append("    ")
            .append(driverHistoryItem.getViolationType().toString()).append("\n");
      }
    }

    return info.toString();
  }
}
