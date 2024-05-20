package io;

import static org.junit.jupiter.api.Assertions.*;

import application.Application;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ParserTest {

  @Test
  public void testParseApplicationFromFile() {
    String filePath = "./resources/test/JohnDoe.json";
    Parser parser = new Parser();

    try {
      Application application = parser.parseApplicationFromFile(filePath);
      assertNotNull(application);
      assertNotNull(application.getDriver());
      assertNotNull(application.getVehicle());
    } catch (IOException e) {
      fail("IOException occurred: " + e.getMessage());
    }


  }


}