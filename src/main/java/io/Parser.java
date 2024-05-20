package io;

import application.Application;
import driver.Driver;
import driver.DriverLicense;
import history.CrashType;
import history.DriverHistoryItem;
import history.IVehicleIncidentType;
import history.VehicleHistoryItem;
import history.ViolationType;
import other.Name;
import vehicle.Vehicle;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import vehicle.VehicleInformation;
import vehicle.VehicleInsurance;

/**
 * A class responsible for parsing application data from JSON files.
 */
public class Parser {

  /**
   * Parses the application JSON file and creates an Application object.
   *
   * @param filePath the path to the JSON file.
   * @return the Application object parsed from the file.
   * @throws IOException if an I/O error occurs.
   */
  public Application parseApplicationFromFile(String filePath) throws IOException {
    File jsonFile = new File(filePath);
    FileInputStream fis = new FileInputStream(jsonFile);
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));

    StringBuilder jsonContent = new StringBuilder();
    String line;

    while ((line = br.readLine()) != null) {
      jsonContent.append(line);
    }

    br.close();
    fis.close();

    return parseApplication(jsonContent.toString());
  }

  /**
   * Parses the application data from a JSON string and creates an Application object.
   *
   * @param json the JSON string containing application data.
   * @return the Application object parsed from the JSON string.
   */
  public Application parseApplication(String json) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(json);

      // Parse driver
      JsonNode driverNode = rootNode.get("driver");
      Driver driver = parseDriver(driverNode);

      // Parse vehicle
      JsonNode vehicleNode = rootNode.get("vehicle");
      Vehicle vehicle = parseVehicle(vehicleNode);

      // Instantiate a new application
      return new Application(driver, vehicle);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Parses the driver information from a JSON node.
   *
   * @param driverNode the JSON node containing driver information.
   * @return the Driver object parsed from the JSON node.
   */
  private Driver parseDriver(JsonNode driverNode) {
    JsonNode nameNode = driverNode.get("name");
    String firstName = nameNode.get("firstName").asText();
    String lastName = nameNode.get("lastName").asText();
    Name name = new Name(firstName, lastName);

    LocalDate birthdate = LocalDate.parse(driverNode.get("birthdate").asText());

    JsonNode licenseNode = driverNode.get("driverLicense");
    DriverLicense driverLicense = parseLicense(licenseNode);

    List<DriverHistoryItem> driverHistories = new ArrayList<>();

    JsonNode historiesNode = driverNode.get("driverHistories");
    if (historiesNode != null) {
      driverHistories = parseDriverHistories(historiesNode);
    }

    return new Driver(name, birthdate, driverLicense, driverHistories);
  }

  /**
   * Parses the driver license information from a JSON node.
   *
   * @param licenseNode the JSON node containing driver license information.
   * @return the DriverLicense object parsed from the JSON node.
   */
  private DriverLicense parseLicense(JsonNode licenseNode) {
    Integer licenseUniqueNumber = licenseNode.get("licenseUniqueNumber").asInt();

    JsonNode nameNode = licenseNode.get("name");
    String firstName = nameNode.get("firstName").asText();
    String lastName = nameNode.get("lastName").asText();
    Name name = new Name(firstName, lastName);

    String address = licenseNode.get("address").asText();
    LocalDate birthdate = LocalDate.parse(licenseNode.get("birthdate").asText());
    String country = licenseNode.get("country").asText();
    String stateOfInsurance = licenseNode.get("stateOfInsurance").asText();
    LocalDate issuanceDate = LocalDate.parse(licenseNode.get("issuanceDate").asText());
    LocalDate expirationDate = LocalDate.parse(licenseNode.get("expirationDate").asText());

    return new DriverLicense(licenseUniqueNumber, name,
        address, birthdate, country, stateOfInsurance, issuanceDate, expirationDate);
  }

  /**
   * Parses the driver history items from a JSON node.
   *
   * @param historiesNode the JSON node containing driver history items.
   * @return a list of DriverHistoryItem objects parsed from the JSON node.
   */
  private List<DriverHistoryItem> parseDriverHistories(JsonNode historiesNode) {
    List<DriverHistoryItem> driverHistories = new ArrayList<>();
    for (JsonNode historyNode : historiesNode) {
      String violationDateString = historyNode.get("violationDate").asText();
      LocalDate violationDate = LocalDate.parse(violationDateString);

      String violationTypeString = historyNode.get("violationType").asText();
      ViolationType violationType = ViolationType.valueOf(violationTypeString);
      driverHistories.add(new DriverHistoryItem(violationDate, violationType));
    }
    return driverHistories;
  }

  /**
   * Parses the vehicle information from a JSON node.
   *
   * @param vehicleNode the JSON node containing vehicle information.
   * @return the Vehicle object parsed from the JSON node.
   */
  private Vehicle parseVehicle(JsonNode vehicleNode) {
    JsonNode vehicleInformationNode = vehicleNode.get("vehicleInformation");
    VehicleInformation vehicleInformation = parseVehicleInformation(vehicleInformationNode);

    JsonNode vehicleInsuranceNode = vehicleNode.get("vehicleInsurance");
    VehicleInsurance vehicleInsurance = parseVehicleInsurance(vehicleInsuranceNode);

    List<VehicleHistoryItem> vehicleHistories = new ArrayList<>();

    JsonNode vehicleHistoriesNode = vehicleNode.get("vehicleHistories");
    if (vehicleHistoriesNode != null) {
      vehicleHistories = parseVehicleHistory(vehicleHistoriesNode);
    }

    return new Vehicle(vehicleInformation, vehicleInsurance, vehicleHistories);
  }

  /**
   * Parses the vehicle information from a JSON node.
   *
   * @param vehicleInformationNode the JSON node containing vehicle information.
   * @return the VehicleInformation object parsed from the JSON node.
   */
  private VehicleInformation parseVehicleInformation(JsonNode vehicleInformationNode) {
    String make = vehicleInformationNode.get("make").asText();
    String model = vehicleInformationNode.get("model").asText();
    Integer year = vehicleInformationNode.get("year").asInt();

    JsonNode ownerNode = vehicleInformationNode.get("owner");
    String firstName = ownerNode.get("firstName").asText();
    String lastName = ownerNode.get("lastName").asText();
    Name owner = new Name(firstName, lastName);

    String color = vehicleInformationNode.get("color").asText();

    String licensePlateNumber = vehicleInformationNode.get("licensePlateNumber").asText();

    return new VehicleInformation(make, model, year, owner, color, licensePlateNumber);
  }

  /**
   * Parses the vehicle insurance information from a JSON node.
   *
   * @param vehicleInsuranceNode the JSON node containing vehicle insurance information.
   * @return the VehicleInsurance object parsed from the JSON node.
   */
  private VehicleInsurance parseVehicleInsurance(JsonNode vehicleInsuranceNode) {
    JsonNode officialOwnerNode = vehicleInsuranceNode.get("officialOwner");
    String officialOwnerFirstName = officialOwnerNode.get("firstName").asText();
    String officialOwnerLastName = officialOwnerNode.get("lastName").asText();
    Name officialOwner = new Name(officialOwnerFirstName, officialOwnerLastName);

    List<Name> peopleCoveredByInsurance = new ArrayList<>();
    JsonNode peopleCoveredByInsuranceNode = vehicleInsuranceNode.get(
        "peopleNameCoveredByInsurance");
    if (peopleCoveredByInsuranceNode != null && peopleCoveredByInsuranceNode.isArray()) {
      for (JsonNode personNode : peopleCoveredByInsuranceNode) {
        String firstName = personNode.get("firstName").asText();
        String lastName = personNode.get("lastName").asText();
        Name person = new Name(firstName, lastName);
        peopleCoveredByInsurance.add(person);
      }
    }

    LocalDate expirationDate = LocalDate.parse(vehicleInsuranceNode.get("expirationDate").asText());

    return new VehicleInsurance(officialOwner, peopleCoveredByInsurance, expirationDate);
  }

  /**
   * Parses the vehicle history items from a JSON node.
   *
   * @param vehicleHistoriesNode the JSON node containing vehicle history items.
   * @return a list of VehicleHistoryItem objects parsed from the JSON node.
   */
  private List<VehicleHistoryItem> parseVehicleHistory(JsonNode vehicleHistoriesNode) {
    List<VehicleHistoryItem> vehicleHistories = new ArrayList<>();

    for (JsonNode vehicleHistoryNode : vehicleHistoriesNode) {
      JsonNode dateNode = vehicleHistoryNode.get("vehicleIncidentDate");
      LocalDate date = LocalDate.parse(dateNode.asText());

      String vehicleIncidentTypeString = vehicleHistoryNode.get("vehicleIncidentType").asText();

      IVehicleIncidentType vehicleIncidentType = null;
      if (CrashType.belongToEnum(vehicleIncidentTypeString)) {
        vehicleIncidentType = CrashType.valueOf(vehicleIncidentTypeString);
      } else {
        vehicleIncidentType = ViolationType.valueOf(vehicleIncidentTypeString);
      }

      JsonNode nameNode = vehicleHistoryNode.get("offendingDriverName");
      String firstName = nameNode.get("firstName").asText();
      String lastName = nameNode.get("lastName").asText();
      Name name = new Name(firstName, lastName);

      vehicleHistories.add(new VehicleHistoryItem(date, vehicleIncidentType, name));
    }

    return vehicleHistories;

  }

}
