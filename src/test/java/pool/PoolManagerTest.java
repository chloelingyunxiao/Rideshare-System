package pool;

import static org.junit.jupiter.api.Assertions.*;

import application.Application;
import application.RegistrationRecordItem;
import io.Parser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validator.RegistrationValidator;
import view.View;

class PoolManagerTest {

  private final String fileFolderPath = "./resources/test/testPoolManager/";

  @Test
  void testRecordExistsAndAddRecord() throws IOException {
    Parser parser = new Parser();

    Application application1 = parser.parseApplicationFromFile(
        fileFolderPath + "JohnDoe.json");

    List<RegistrationRecordItem> listOfRegisteredRecord = new ArrayList<>();
    PoolManager poolManager = new PoolManager(listOfRegisteredRecord);

    poolManager.addRegistrationRecord(application1);
    assertEquals(1, listOfRegisteredRecord.size());

    // Add another possible applicant, the name of the applicant is not same.
    Application application2 = parser.parseApplicationFromFile(
        fileFolderPath + "test1_FullerPatrica_differentNameCompareToExistRecord.json");
    poolManager.addRegistrationRecord(application2);
    assertEquals(2, listOfRegisteredRecord.size());

    // And another possible applicant, this applicant is existing in the list.
    Application application3 = parser.parseApplicationFromFile(
        fileFolderPath + "JohnDoe2.json");
    poolManager.addRegistrationRecord(application3);
    assertEquals(2, listOfRegisteredRecord.size());

  }


  @Test
  void provideDriverInfo() throws IOException {
    Parser parser = new Parser();
    List<RegistrationRecordItem> listOfRegisteredRecord = new ArrayList<>();
    PoolManager poolManager = new PoolManager(listOfRegisteredRecord);

    Application application1 = parser.parseApplicationFromFile(fileFolderPath + "JohnDoe.json");
    Application application2 = parser.parseApplicationFromFile(fileFolderPath + "BobDoe.json");

    poolManager.addRegistrationRecord(application1);
    poolManager.addRegistrationRecord(application2);
    String actualOutputString = poolManager.provideDriverInfo("Doe");

    String expectedOut = """
        Doe, Bob
            2018 Red Toyota Camry, AZ034W1
            Driving violations:
                Distracted Driving
                Failure to Respect Traffic Signs
        Doe, John
            2018 Red Toyota Camry, AZ034W1
            Driving violations:
                Distracted Driving
                Failure to Respect Traffic Signs
        """;

    assertEquals(expectedOut, actualOutputString);

    // If the specific last name is not existing in the list
    String actualOutputString2 = poolManager.provideDriverInfo("Zhang");
    String expectedOut2 = "No registered driver found with last name: " + "Zhang";
    assertEquals(expectedOut2, actualOutputString2);
  }
}