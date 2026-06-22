package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WebFormPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String WEB_FORM_URL = BASE_URL + "web-form.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(WEB_FORM_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void verifyTextInputFieldTest(){
        WebElement textInputField = driver.findElement(By.id("my-text-id"));
        textInputField.clear();
        String expectedText = "Test input...";

        textInputField.sendKeys(expectedText);

        String actualText = textInputField.getAttribute("value");
        Assertions.assertEquals(expectedText,actualText,"Input text is incorrect.");
    }

    @Test
    void verifyPasswordInputFieldTest(){
        WebElement passwordInputField = driver.findElement(By.name("my-password"));
        passwordInputField.clear();
        String expectedPassword = "TestPass123$";

        passwordInputField.sendKeys(expectedPassword);

        String actualPassword = passwordInputField.getAttribute("value");
        Assertions.assertEquals(expectedPassword,actualPassword,"Input password is incorrect.");
    }

    @Test
    void verifyTextAreInputFieldTest(){
        WebElement textInputField = driver.findElement(By.name("my-textarea"));
        textInputField.clear();
        String expectedText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n";

        textInputField.sendKeys(expectedText);

        String actualText = textInputField.getAttribute("value");
        Assertions.assertEquals(expectedText,actualText,"Input text is incorrect.");
    }

    @Test
    void verifyDisabledInputFieldTest(){
        WebElement disabledInputField = driver.findElement(By.name("my-disabled"));

        String attributeValue = disabledInputField.getAttribute("placeholder");
        Assertions.assertEquals("Disabled input", attributeValue,"Placeholder is incorrect.");
        Assertions.assertFalse(disabledInputField.isEnabled(),"Input field is enabled.");
    }

    @Test
    void verifyReadOnlyFieldTest(){
        WebElement readOnlyInputField = driver.findElement(By.name("my-readonly"));

        String attributeValue = readOnlyInputField.getAttribute("value");
        Assertions.assertEquals("Readonly input", attributeValue,"Input field is read only.");
    }

    @Test
    void verifyDropDownSelectFieldTest(){
        WebElement dropDownField = driver.findElement(By.name("my-select"));
        Select select = new Select(dropDownField);

        String currentOption = select.getFirstSelectedOption().getText();
        Assertions.assertEquals("Open this select menu", currentOption,"Open this select menu");

        select.selectByVisibleText("Three");
        String nextOption = select.getOptions().get(3).getText();
        Assertions.assertEquals("Three",nextOption, "Next option is incorrect.");
    }

    @Test
    @DisplayName("Dropdown (datalist) test: select option after entering value")
    void verifyDropDownDataListFieldTest(){

        WebElement dataList = driver.findElement(By.name("my-datalist"));
        dataList.click();
        WebElement option = driver.findElement(By.xpath("//datalist/option[2]"));
        String optionValue = option.getAttribute("value");
        dataList.sendKeys(optionValue);

        Assertions.assertEquals("New York", optionValue,"New York must be selected.");
    }

    @Test
    @DisplayName("Upload file test")
    void verifyUploadFileTest() throws IOException {
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        uploadFile.sendKeys(filename);
        driver.findElement(By.tagName("form")).submit();

        String actualPage = driver.findElement(By.xpath("//p[contains(text(), 'Received!')]")).getText();
        Assertions.assertEquals("Received!",actualPage,"Page is incorrect.");
    }

    @Test
    @DisplayName("Checkboxes test")
    void verifyCheckboxesTest() {
        WebElement checkbox = driver.findElement(By.id("my-check-1"));
        Assertions.assertTrue(checkbox.isSelected(),"Checkbox is incorrect.");

        WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
        Assertions.assertFalse(checkbox2.isSelected(),"Checkbox is incorrect.");
    }

    @Test
    @DisplayName("Radio buttons tests")
    void verifyRadioButtonsTest() {
        WebElement radioButton = driver.findElement(By.id("my-radio-1"));
        Assertions.assertTrue(radioButton.isSelected(),"Radio button is not selected!");

        WebElement radioButton2 = driver.findElement(By.id("my-radio-2"));
        Assertions.assertFalse(radioButton2.isSelected(),"Radio button is selected!");
    }

    @Test
    @DisplayName("Color picker test")
    void verifyColorPickerTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        String initColor = colorPicker.getAttribute("value");

        Color red = new Color(255, 0, 0, 1);
        colorPicker.sendKeys(red.asHex());

        String finalColor = colorPicker.getAttribute("value");
        Assertions.assertNotNull(finalColor);
        Assertions.assertEquals(Color.fromString(finalColor),red,"Color picker is incorrect.");
    }

    @Test
    @DisplayName("Date picker test")
    void verifyDatePickerTest() {
        LocalDate today = LocalDate.now();
        int tomorrow = today.plusDays(30).getDayOfMonth();
        System.out.println(tomorrow);

        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("06/22/2026");

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String actualDate = datePicker.getAttribute("value");
        String expectedDate = today.format(dateFormat);;
        Assertions.assertEquals(expectedDate,actualDate,"Date picker is incorrect.");
    }

    @Test
    @DisplayName("Range test")
    void verifyRangeTest() {
        WebElement range = driver.findElement(By.name("my-range"));

        for (int i = 0; i < 3; i++) {
            range.sendKeys(Keys.ARROW_RIGHT);
        }

        String actualRange = range.getAttribute("value");
        Assertions.assertEquals("8",actualRange,"Range is incorrect.");
    }
}
