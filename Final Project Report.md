# Final Project Report - Lingyun Xiao - Option2

## Rideshare System – Prospective Drivers Validator and Simulator

### Overview and Purpose of the project

The purpose of this program is to create a system for registering prospective drivers and validating
their eligibility. Users can register as prospective drivers through the system and provide personal
information, driver's license information, vehicle information, vehicle insurance information,
driver history, and vehicle history.

The system will validate the provided information, such as driver's age, driver's license
information, vehicle information, vehicle insurance information, driver history, and vehicle
history. Based on the validation results, prospective drivers will be either accepted or rejected.

Accepted drivers will be added to the pool of existing accepted drivers, which has additional
requirements such as uniqueness and query capability. Users can also query information about
accepted drivers, such as querying driver information by last name and displaying their vehicle
information and driving violation records.

Finally, the program also provides a simulator that allows users to run simulations by reading a
file containing information about prospective drivers.

### Key Challenges and how to address

Data Preparation and Parsing: Ensure effective handling and parsing of input data files, including
correctly reading and parsing JSON files, and converting them into object representations usable by
the application (Application objects). This can be achieved by using efficient data parsing
libraries and techniques, such as the Jackson library. I have developed a custom parser for JSON
files to handle the parsing logic for these data files.

Complexity of Validation Logic: Validating the legality of driver and vehicle information may
involve multiple aspects, such as age, validity of driver's license, completeness of vehicle
information, etc. The approach involves decomposing the validation logic into independent strategies
using the strategy pattern and writing clear, maintainable validation logic to selectively invoke
these validation strategies as needed. I have implemented the RegistrationValidator class for
validation, covering various scenarios, and conducted testing for it.

Robustness of the Application: Ensure that the application can run stably in various situations and
handle exceptional conditions, such as file not found, format errors, incomplete data, etc. This
requires writing robust code logic and exception handling mechanisms, as well as conducting
sufficient testing to verify the correctness and stability of the application. I have implemented
methods like isValidPath using regular expressions to validate the validity of input values.

User Interaction and Feedback: Provide clear user interface and friendly interaction methods so that
users can easily use the application and promptly understand the operation results and possible
error messages. This can be achieved through command-line interfaces or graphical user interfaces
for user interaction, and writing clear prompt messages and error messages so that users can
understand and take appropriate actions. I have implemented the View class to facilitate interaction
with users. Additionally, I have used the MVC architecture to design the overall program structure.

### Sources and resources used in the project

Open-source tools and libraries: I utilized the com.fasterxml.jackson.databind.JsonNode and
com.fasterxml.jackson.databind.ObjectMapper libraries, which, based on a tree structure, aided me in
parsing within the Parser class.

Additionally, my data sources are located in the resources folder within the project directory,
comprising JSON files for testing purposes and potentially executable files for the main program.

### How to run this program

Starting from the main entry point in the RideShareDriverValidator class, you can run the program.
Based on the terminal prompts, you can choose the corresponding functionality to add to the
collection or provide driver information. Below are the specific file names that can be entered and
their corresponding results:

```text
Here is the input file path and result
 ./resources/main/AnneSmith.json  --- successfully added
 ./resources/main/AnneSmithVehicle2.json  --- successfully added
 ./resources/main/BrandonSmith.json --- successfully added
 ./resources/main/PatricaFuller.json --- successfully added
 ./resources/main/abc.json --- can not find file, throw out IO error (No such file or directory), end program
 ./resources/main/abc --- continue to get input
    ./resources/main/test2_JohnDoe_nameDifference.json --- print out invalid application, driver's name is not consist with driver license
    ./resources/main/test2JohnDoeNameDifference.json -- print out invalid application, driver's name is not consist with driver license


```

If we add AnneSmith.json, AnneSmithVehicle2.json, BrandonSmith.json, and PatricaFuller.json, and
choose 2 to display according to last name.
The result in console will log as:

```text
/Users/xiaolingyun/Library/Java/JavaVirtualMachines/openjdk-20.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=49302:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/xiaolingyun/Documents/GH5004/Student_repo_Lingyun_Evenlyn_Xiao/final_project_option2/out/production/classes:/Users/xiaolingyun/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-databind/2.16.1/2a16efeb840c45af1e2f31753dfe76795278b73/jackson-databind-2.16.1.jar:/Users/xiaolingyun/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-annotations/2.16.1/fd441d574a71e7d10a4f73de6609f881d8cdfeec/jackson-annotations-2.16.1.jar:/Users/xiaolingyun/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-core/2.16.1/9456bb3cdd0f79f91a5f730a1b1bb041a380c91f/jackson-core-2.16.1.jar RideShareDriverValidator
=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
1
Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)
./resources/main/AnneSmith.json
Path is valid.
Successfully added registration record

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
1
Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)
./resources/main/AnneSmithVehicle2.json
Path is valid.
Successfully added registration record

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
1
Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)
./resources/main/BrandonSmith.json
Path is valid.
Successfully added registration record

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
1
Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)
./resources/main/PatricaFuller.json
Path is valid.
Successfully added registration record

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
2
Please enter last name to be searched and display: 
Smith
Smith, Anne
    2014 Blue Honda Accord, BAY01FG
    2015 Silver Toyota Prius, AZ034W1
Smith, Brandon
    2015 Red Mazda 6, AAB1234

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
2
Please enter last name to be searched and display: 
Fuller
Fuller, Patrica
    2012 Blue Ford Explore, ZZW-123
    Driving violations:
        Distracted Driving
        Parking Violation

=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
2
Please enter last name to be searched and display: 
Jefferson
No registered driver found with last name: Jefferson
=======================
Please enter your choice: (Enter 1, 2 or 3) 
1. Validate application and add
2. Search and display according last name
3. Exit
3
You entered 3. Exiting the system!

Process finished with exit code 0

```

#### 1. How I used inheritance and composition.

* **Inheritance:**`HistoryItem` class is the super class of `DriverHistoryItem`
  and  `VehicleHistoryItem` by using
  inheritance keyword `extends` to declare.
* **Composition:** Every `Application` or `RegistrationRecordItem` is composited by `Driver`
  and `Vehicle` (This is one of composition, I use it as a example)

Code snippet is shown as below.

```java
// Inheritance
// Super class HistoryItem
public abstract class HistoryItem {

  LocalDate date;

  public HistoryItem(LocalDate date) {
    this.date = date;
  }...

  // Subclass: DriverHistoryItem class  
  public class DriverHistoryItem extends HistoryItem {

    private final ViolationType violationType;

    public DriverHistoryItem(LocalDate date, ViolationType violationType) {
      super(date);
      this.violationType = violationType;
    }...

    //Sub class: VehicleHistoryItem
    public class VehicleHistoryItem extends HistoryItem {

      private IVehicleIncidentType vehicleIncidentType;
      private Name offendingDriverName;

      public VehicleHistoryItem(LocalDate date, IVehicleIncidentType vehicleIncidentType,
          Name offendingDriverName) {
        super(date);
        this.vehicleIncidentType = vehicleIncidentType;
        this.offendingDriverName = offendingDriverName;
      }...

      // Composition
      public class Application {

        private Driver driver;
        private Vehicle vehicle;

        public Application(Driver driver, Vehicle vehicle) {
          this.driver = driver;
          this.vehicle = vehicle;
        }...
```

**2. Please include a code snippet showing how have you used an interface or an abstract class in
your
code.**

* `HistoryItem` is an abstract class and `RegistrationValidator` implements
  interface `IRegistrationValidator`
* Here is the code snippet.

```java
// Interface
public interface IRegistrationValidator {

  boolean validate(Application application);
}...

// Implement of interface
public class RegistrationValidator implements IRegistrationValidator {

  private final Integer MIN_AGE = 21;
  private final Integer MAX_YEAR = 15;
  private final Integer MIN_LICENSE_ISSUE_MONTH = 6;

  private final List<String> acceptedLicenseIssuanceCountries = Arrays.asList("US", "Canada");

  private final List<ViolationType> MovingViolations = Arrays.asList(
      ViolationType.DistractedDriving,
      ViolationType.RecklessDriving,
      ViolationType.Speeding,
      ViolationType.DrivingUnderInfluence,
      ViolationType.FailureToRespectTrafficSigns,
      ViolationType.DrivingWithoutValidLicenseOrInsurance
  );
  ...

  // Abstract class
  public abstract class HistoryItem {

    LocalDate date;

    public HistoryItem(LocalDate date) {
      this.date = date;
    }...


```

**3. Please include code example of a method overriding and method overloading from your code, or
explain why you have not used any overloading or overriding.**

* I choose to override `equals()` and `hashCode()` to assert whether two objects in a same class
  have same attributes.
* If yes, `a.equal(b)` will return true.
* Here is an overriding example in class `Driver`.

```java

@Override
public boolean equals(Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Driver driver = (Driver) o;
  return Objects.equals(name, driver.name)
      && Objects.equals(birthdate, driver.birthdate)
      && Objects.equals(driverLicense, driver.driverLicense)
      && Objects.equals(driverHistories, driver.driverHistories);
}

@Override
public int hashCode() {
  return Objects.hash(name, birthdate, driverLicense, driverHistories);
}

```

**4. Please include a code example showing how have you used encapsulation, or explain why you did
not need encapsulation in your code.**

* To avoid details shows to unnecessary class. I use encapsulation to organize my code.
* For example, to interact with user more effectively, I encapsulate scanner from console as
  a `View` class.
* It will receive scanner result as input and print out prompts to make program more user friendly.

```java
// Define a class View
public class View {

  public static String getInputFilePath() {
    Scanner scanner = new Scanner(System.in);
    String path;
    do {

      System.out.println(
          "Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)");
      path = scanner.nextLine();
    } while (!isPathValid(path));
    return path;
  }

  public static boolean isPathValid(String path) {
    String regex = "^(/|./|../)?(?:[a-zA-Z0-9_ -]+/)*[a-zA-Z0-9_ -]+\\.json$";
    boolean matches = path.matches(regex);
    if (!matches) {
      System.out.println("Invalid path! Please try again.");
    } else {
      System.out.println("Path is valid.");
    }
    return matches;
  }
  ...

  // Use View class in other classes.
  public static void main(String[] args) {
    initializeValidator();
    int userChoice;
    do {
      userChoice = View.getUserChoice();

      if (userChoice == 1) {
        Application application = getInputJsonAndParseApplication();
        handleAddValidApplication(application);
      } else if (userChoice == 2) {
        String lastName = View.getLastNameToSearch(); // Smith Fuller Jefferson
        handleProvideDriverInformation(lastName);
      } else {
        handleEndProgram(userChoice);
      }
    } while (true);
  }

```

5. **Please include a code example of subtype polymorphism from your code, or explain why you did
   not need subtype polymorphism.**

* In my project, `HistoryItem` class is the super class of `DriverHistoryItem`
  and  `VehicleHistoryItem` by using inheritance keyword `extends` to declare.
* In the subclass of my inheritance class, the functionality is simple as it only consists of
  getters and fixed operation types. There's no need to choose different operations dynamically
  based on different circumstances. Moreover, the class structure is straightforward, and the code
  logic is simple. Hence, polymorphism is unnecessary.

6. **Please include a code snippet of generics from your code.**

* In `View` class, there is a generics function `listToString(List<T> list)`.
* This method converts a generic list into a string. It takes a list of generic type as input,
  iterates over each item in the list, and appends the string representation of each item to a
  StringBuilder.
* Finally, it converts the StringBuilder to a string and returns it. This method is useful for
  situations where you need to output the contents of a list as a string, such as printing the
  contents of a list or writing the contents of a list to a file.
* The generics help object of type T to convert specific list to string.

```java
// Generics
public static <T> String listToString(List<T> list) {
  StringBuilder listString = new StringBuilder();
  for (T item : list) {
    listString.append(item.toString());
  }
  return listString.toString();
}
```

7. **Please include a code snippet showing how have you used some of the built-in data
   collections from the Java Collections Framework, or explain why you had no need for
   any data collections.**

* I used several build-in data collections such as `List` and `ArrayList`.
* For example, I use `List<>` interface to store information of `RegistrationRecords`, which is a
  collection of acceptable records, like a database.
* All the information are stored in `PoolManager` and it shows
  as`private List<RegistrationRecordItem> registeredRecords`
* Here is the code snippet

```java
public class PoolManager {

  private List<RegistrationRecordItem> registeredRecords;

  public PoolManager(List<RegistrationRecordItem> registeredRecords) {
    this.registeredRecords = registeredRecords;
  }...

  // use List.add()
  public boolean addRegistrationRecord(Application possibleRecord) {
    if (recordExists(possibleRecord)) {
      return false;
    }

    registeredRecords.add(
        new RegistrationRecordItem(possibleRecord.getDriver(), possibleRecord.getVehicle()));
    return true;
  }...
```

8. **Please include a code snippet showing how have you used interfaces Iterable and
   Iterator, or explain why you had no need for these two interfaces.**

* I use Iterator interface to traverse a list in `CrashTypes`
* Here is the code:

```java
public enum CrashType implements IVehicleIncidentType {
  /// ...

  // Iterator Interface part
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
```

**9. Please include a code snippet showing how have you used interfaces Comparable and
Comparator, or explain why you had no need for these two interfaces.**

* I used Comparator interface to compare specific record in `PoolManager`
  class's `providerDriverInfo` function.
* Here is the code:

```java
public String provideDriverInfo(String lastName) {
  //...
  // Sort by first name
  recordsFilterByLastName.sort(
      Comparator.comparing(record -> record.getDriver().getName().getFirstName()));
```

10. **Please include a code snippet showing how have you used regular expressions, or
    explain why you had no need for it.**

* I use regular expression to check whether the user input path is a valid path in class `View`.
* Here is the code:

```java
  public static boolean isPathValid(String path) {
  String regex = "^(/|./|../)?(?:[a-zA-Z0-9_ -]+/)*[a-zA-Z0-9_ -]+\\.json$";
  boolean matches = path.matches(regex);
  if (!matches) {
    System.out.println("Invalid path! Please try again.");
  } else {
    System.out.println("Path is valid.");
  }
  return matches;
}
```

11. **Please include a code snippet showing how have you used nested classes, or justify
    why you had no need for nested classes.**

* In my object-oriented design scheme, since the nested classes would increase the nesting depth of
  the code and decrease its readability without clear dependencies or organizational relationships
  among the classes, I chose not to design nested classes. Instead, I separated different classes
  into different packages to organize my code.
* At the same time, the code of my classes will be reused in other classes, so it is not appropriate
  to place them in nested classes.

12. **Please include code example showing how have you used components of functional
    programming, such as lambdas and streams, or explain why you had no need for it in
    your code.**

* I use functional programming in class `PoolManager` to filter the list of RegistrationRecordItem
* At the same time, there is also a functional programming in sorting function.
* Here is the code:

```java
public String provideDriverInfo(String lastName) {
  List<RegistrationRecordItem> recordsFilterByLastName = this.getRegisteredRecords().stream()
      .filter(record -> record.getDriver().getName().getLastName().equals(lastName))
      .collect(Collectors.toList());

  // ...
// Sort by first name
  recordsFilterByLastName.sort(
      Comparator.comparing(record -> record.getDriver().getName().getFirstName()));
}
```

13. Please include code snippet(s) showing how have you used creational, structural
    and/or behavioral design patterns. Please list which design patterns have you used,
    or explain why you had no need for design patterns in your solution.

* My code utilizes the Builder design pattern， which is a creational design pattern.
    * Although there is no explicit builder class, within the various private methods of the Parser
      class, you progressively construct complex objects (such as driver objects, driver license
      objects, vehicle objects, etc.), and ultimately combine them into an application object. This
      incremental object construction process aligns with the principles of the Builder pattern.
* The Strategy Pattern belongs to the behavioral design pattern.
    * In the RegistrationValidator class, each validation method represents a different strategy,
      and these strategies can be selectively invoked for validation as needed. That is, by calling
      multiple private methods to execute different validation strategies, each strategy validates
      specific aspects, such as driver age, driver's license, vehicle information, vehicle
      insurance, driver history, and vehicle history.
* The Singleton Pattern belongs to the creational design pattern.
    * In the provided code, constants like MIN_AGE, MAX_YEAR, and MIN_LICENSE_ISSUE_MONTH are
      declared as final and instantiated only once within the class, thus implementing the
      characteristics of the Singleton Pattern.
* The Iterator Pattern belongs to the behavioral design pattern.
    * The Iterator Pattern is used for sequentially accessing the elements of a collection object
      without exposing the underlying representation of the collection. In the
      validateVehicleHistory method, the Iterator Pattern is used to iterate over vehicle history
      records, checking for specific types of violations.

```java
// Builder Pattern
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

// Validate method --- Strategy Pattern
boolean validateDriverHistory(Application application) {
  List<DriverHistoryItem> driverViolations = application.getDriver().getDriverHistories();
  for (DriverHistoryItem violation : driverViolations) {
    ViolationType violationType = violation.getViolationType();
    if (DisallowedViolations.contains(violationType)) {
      return false;
    }
  }

  return true;
}

// Constants --- Singleton Pattern
private final Integer MIN_AGE = 21;
private final Integer MAX_YEAR = 15;
private final Integer MIN_LICENSE_ISSUE_MONTH = 6;

// Iterator Pattern
boolean validateDriverHistory(Application application) {
  List<DriverHistoryItem> driverViolations = application.getDriver().getDriverHistories();
  for (DriverHistoryItem violation : driverViolations) {
    ViolationType violationType = violation.getViolationType();
    if (DisallowedViolations.contains(violationType)) {
      return false;
    }
  }
  return true;
}

```

14. **Please include code snippets showing examples of MVC architecture, or justify why
    you had no need for MVC architecture in your design.**

* Model: There are several data models like `Driver` and `Vehicle`, their schema can be shown as
  json node tree in input json files.
* View: In my project, there is a `View` class to deal with user input, output and interaction.
* Controller: There is a `PoolManager` class as a controller to control database, add or provide
  information appropriately.
* Here is sample code:

```java
// View 
public class View {

  public static String getInputFilePath() {
    Scanner scanner = new Scanner(System.in);
    String path;
    do {

      System.out.println(
          "Please enter a path and the json file name to the file: (e.g: ./resources/WillSmith.json)");
      path = scanner.nextLine();
    } while (!isPathValid(path));
    return path;
  }...

  //Model
  public class Driver {

    //... 
    public Driver(Name name, LocalDate birthdate, DriverLicense driverLicense,
        List<DriverHistoryItem> driverHistories) {
      this.name = name;
      this.birthdate = birthdate;
      this.driverLicense = driverLicense;
      this.driverHistories = driverHistories;
    }
    //...

    // Controller
    public class PoolManager {

      // ....
      public List<RegistrationRecordItem> getRegisteredRecords() {
        return registeredRecords;
      }

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

      public boolean addRegistrationRecord(Application possibleRecord) {
        if (recordExists(possibleRecord)) {
          return false;
        }

        registeredRecords.add(
            new RegistrationRecordItem(possibleRecord.getDriver(), possibleRecord.getVehicle()));
        return true;
      }

      public String provideDriverInfo(String lastName) {
        List<RegistrationRecordItem> recordsFilterByLastName = this.getRegisteredRecords().stream()
            .filter(record -> record.getDriver().getName().getLastName().equals(lastName))
            .collect(Collectors.toList());

        if (recordsFilterByLastName.isEmpty()) {
          return "No registered driver found with last name: " + lastName;
        }

        // Sort by first name
        recordsFilterByLastName.sort(
            Comparator.comparing(record -> record.getDriver().getName().getFirstName()));
        // ...
```

15. **Please include code examples showing data and stamp coupling in your code.**

* **Data coupling**: In the method handleAddValidApplication(Application application), the
  addRegistrationRecord() method of PoolManager handles registration records by passing the
  Application object as a parameter. Here, the Application object contains the data needed to be
  added to the registration records.
* **Stamp coupling:** In the method handleProvideDriverInformation(String lastName), the
  provideDriverInfo() method of PoolManager only needs the last name to provide driver information,
  without requiring the entire Application object or more data. In this case, only the last name is
  passed as a stamp, rather than the entire object, demonstrating the concept of stamp coupling.

* Here is the code:

```java
// Data coupling
public static void handleAddValidApplication(Application application) {
  if (registrationValidator.validate(application)) {
    if (poolManager.addRegistrationRecord(application)) {
      System.out.println("Successfully added registration record\n");
    } else {
      System.out.println("Record exists, Failed to add registration record\n");
    }

  } else {
    System.out.println("Application is not valid, "
        + "it can not be registered! Your application is rejected!\n" +
        "You can try again and enter another one application.\n");
  }
}

// Stamp Coupling
public static void handleProvideDriverInformation(String lastName) {
  System.out.println(poolManager.provideDriverInfo(lastName));
}
// ...

```