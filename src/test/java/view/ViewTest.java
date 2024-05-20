package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewTest {

  private InputStream originalSystemIn;

  @BeforeEach
  public void setUp() {
    // Save the original System.in
    originalSystemIn = System.in;
  }

  @AfterEach
  public void tearDown() {
    // Restore System.in after each test
    System.setIn(originalSystemIn);
  }

  @Test
  public void testGetInputFilePath_ValidPath() {
    // Simulate user input "valid/path/WillSmith.json"
    String input = "valid/path/WillSmith.json\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the method
    String result = View.getInputFilePath();

    // Verify that the method returns the expected path
    assertEquals("valid/path/WillSmith.json", result);
  }

  @Test
  public void testGetInputFilePath_InvalidPathThenValidPath() {
    // Simulate user input "invalid/path" followed by "valid/path/WillSmith.json"
    String input = "invalid/path\nvalid/path/WillSmith.json\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Call the method
    String result = View.getInputFilePath();

    // Verify that the method returns the second valid path
    assertEquals("valid/path/WillSmith.json", result);
  }

  @Test
  void isPathValid() {
    assertTrue(View.isPathValid("./resources/main/AnneSmith.json"));
    assertTrue(View.isPathValid("AnneSmith.json"));
    assertTrue(View.isPathValid("./resources/main/AnneSmithVehicle2.json"));
    assertTrue(View.isPathValid("./resources/main/test2_JohnDoe_nameDifference.json"));
    assertFalse(View.isPathValid("happy.csv"));

  }


  @Test
  public void testGetUserChoice() {
    // Simulate user input "1"
    String input = "1\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    assertEquals(1, View.getUserChoice());
  }

  @Test
  public void testGetLastNameToSearch() {
    // Simulate user input "Smith"
    String input = "Smith\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    assertEquals("Smith", View.getLastNameToSearch());
  }


}