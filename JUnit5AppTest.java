package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.opentest4j.MultipleFailuresError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing using JUnit 5")
/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
 * report.</li>
 * </ol>
 *
 */
public class JUnit5AppTest {

  // Create a JDK Logger here
  private static final Logger log = LoggerFactory.getLogger(JUnit5AppTest.class);

  // Create a fixture for the class under test
  private App classUnderTest;

  // Do something before ANY test is run in this class
  @BeforeAll
  public static void init() {
    System.out.println("This is done before all tests.");
  }

  // Do something after ALL tests in this class are run
  @AfterAll
  public static void done() {
    System.out.println("This is done after all tests.");
  }

  // Create an instance of the test class before each @Test method is executed
  @BeforeEach
  public void setUp() throws Exception {
    classUnderTest = new App();
  }

  // Destroy reference to the instance of the test class after each @Test method is executed
  @AfterEach
  public void tearDown() throws Exception {
    classUnderTest = null;
  }

  @Test
  @DisplayName("Dummy test")
  void aTest() {
    log.info("As written, this test will always pass!");
    assertEquals(4, (2 + 2));
  }

  @Test
  @DisplayName("Dummy test 2")
  void dummyTest() throws MultipleFailuresError{
    int expected = 4;
    int actual = 2 + 2;
    Object nullValue = null;

    assertAll(
      "Assert All of these",
      () -> assertEquals(expected, actual, "INCONCEIVABLE!"),
      () -> assertFalse(nullValue != null),
      () -> assertNull(nullValue),
      () -> assertNotNull("A String", "INCONCEIVABLE!"),
      () -> assertTrue(nullValue == null));
    // assertFalse(nullValue != null);
    // assertNull(nullValue);
    // assertNotNull("A String", "INCONCEIVABLE!");
    // assertTrue(nullValue == null);
  }



  // Disabled test
  @Test
  @Disabled
  @DisplayName("A disabled test")
  void testNotRun() {
    log.info("This test will not run (it is disabled, silly).");
  }

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
   * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
   * </ol>
   */
  @Test
  @DisplayName("Cool testAdd name")
  public void testAdd() {
    //
    // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see the
    // buttery smooth javadoc above.)
    //
    long[] arrayOne = {1,2,3,4};
    long expectedOne = 10;
    long[] arrayTwo = {20,934,110};
    long expectedTwo = 1064;
    long[] arrayThree = {2,4,6};
    long expectedThree = 12;
    assertAll(
      "Array Add",
      () -> assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested"),
      () -> assertEquals(expectedTwo, classUnderTest.add(arrayTwo), "arrayTwo tested"),
      () -> assertEquals(expectedThree, classUnderTest.add(arrayThree), "arrayOne tested"));
    
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called <code>setUp()</code> that runs before the test
   * method does (hint: use {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Negative numbers test class cool name")
  class NegativeNumbersTest {

    private App classUnderTest;

    @BeforeEach
    public void setUo() throws Exception {
      classUnderTest = new App();
    }

    @AfterEach
    public void tearDown() throws Exception {
      classUnderTest = null;
    }

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Cool name for testAdd in negative number class")
    public void testAdd() throws MultipleFailuresError{
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {-1,-2,-3,-4};
      long expectedOne = -10;
      long[] arrayTwo = {-20,-934,-110};
      long expectedTwo = -1064;
      long[] arrayThree = {-2,-4,-6};
      long expectedThree = -12;
      assertAll(
        "Array Add",
        () -> assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested"),
        () -> assertEquals(expectedTwo, classUnderTest.add(arrayTwo), "arrayTwo tested"),
        () -> assertEquals(expectedThree, classUnderTest.add(arrayThree), "arrayOne tested"));
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Positive and negative numbers test cool name")
  class PositiveAndNegativeNumbersTest {

    private App classUnderTest;

    @BeforeEach
    public void setUo() throws Exception {
      classUnderTest = new App();
    }

    @AfterEach
    public void tearDown() throws Exception {
      classUnderTest = null;
    }

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("posative and negative numbers added together")
    public void testAdd() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {-1,2,-3,4};
      long expectedOne = 2;
      long[] arrayTwo = {-20,934,-110};
      long expectedTwo = 804;
      long[] arrayThree = {2,-4,6};
      long expectedThree = 4;
      assertAll(
        "Array Add",
        () -> assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested"),
        () -> assertEquals(expectedTwo, classUnderTest.add(arrayTwo), "arrayTwo tested"),
        () -> assertEquals(expectedThree, classUnderTest.add(arrayThree), "arrayOne tested"));
    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Only test of friday becasue that is the 3rd best day")
    public void testAdd_OnlyOnFriday() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {1,2,3,4,5};
      long expectedOne = 15;
      LocalDateTime ldt = LocalDateTime.now();
      assumeTrue(ldt.getDayOfWeek().getValue() == 5);
      assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested");
       
    }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Cool test name for lambda test")
    public void testAdd_OnlyOnFriday_WithLambda() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      LocalDateTime ldt = LocalDateTime.now();
        assumingThat(ldt.getDayOfWeek().getValue() == 5,
          () -> {
            long[] arrayOne = {1,2,3,4,5};
            long expectedOne = 15;
            assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested");
          });
    }

  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Cool name for singleOrerandTest class")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("1 number in array")
    public void testAdd_NumbersGt0() throws MultipleFailuresError {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {1};
      long expectedOne = 1;
      long[] arrayTwo = {0};
      long expectedTwo = 0;
      assertAll(
        "Array Add",
        () -> assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested"),
        () -> assertEquals(expectedTwo, classUnderTest.add(arrayTwo), "arrayTwo tested"));
    }

    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("negative number in array")
    public void testAdd_NumbersLt0() throws MultipleFailuresError {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {-1};
      long expectedOne = -1;
      long[] arrayTwo = {-10};
      long expectedTwo = -10;
      assertAll(
        "Array Add",
        () -> assertEquals(expectedOne, classUnderTest.add(arrayOne), "arrayOne tested"),
        () -> assertEquals(expectedTwo, classUnderTest.add(arrayTwo), "arrayTwo tested"));
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   *
   */
  @Nested
  @DisplayName("No operands test class")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
    @Test
    @DisplayName("zero operands in array")
    public void testAdd_ZeroOperands_EmptyArgument() throws IllegalArgumentException{
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = {};
      IllegalArgumentException exception = new IllegalArgumentException();
      assertThrows(exception.getClass(), () -> classUnderTest.add(arrayOne));
    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands argument cannot be null".</li>
     * </ol>
     */
    @Test
    @DisplayName("Null array test")
    public void testAdd_ZeroOperands_NullArgument() throws IllegalArgumentException{
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      long[] arrayOne = null;
      Throwable expectedException = assertThrows(IllegalArgumentException.class,
        () -> classUnderTest.add(arrayOne));
      assertEquals("Operands argument cannot be null", expectedException.getLocalizedMessage());
      
    }

  }

}
