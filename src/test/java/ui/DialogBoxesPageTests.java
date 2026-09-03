package ui;

import org.junit.jupiter.api.*;
import pageObjects.DialogBoxesPage;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialogBoxesPageTests extends BaseTest{

    @Test
    @DisplayName("Verify alert text")
    public void verifyAlertTextTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchAlert();

        String actualAlertText = dialogBoxesPage.getAlertText();
        assertEquals("Hello world!", actualAlertText);

        dialogBoxesPage.acceptAlert();
    }

    @Test
    @DisplayName("Accept confirm alert")
    public void acceptAlertTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchConfirm();

        String actualAlertText = dialogBoxesPage.getAlertText();
        assertEquals("Is this correct?", actualAlertText);

        dialogBoxesPage.acceptAlert();

        String actualTextUnderConfirmButton = dialogBoxesPage.getTextUnderConfirmButton();
        assertEquals("You chose: true", actualTextUnderConfirmButton);
    }

    @Test
    @DisplayName("Dismiss confirm alert")
    public void dismissConfirmAlertTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchConfirm();

        String actualAlertText = dialogBoxesPage.getAlertText();
        assertEquals("Is this correct?", actualAlertText);

        dialogBoxesPage.dismissAlert();

        String actualTextUnderConfirmButton = dialogBoxesPage.getTextUnderConfirmButton();
        assertEquals("You chose: false", actualTextUnderConfirmButton);
    }

    @Test
    @DisplayName("Enter prompted name and accept")
    public void enterPromptedNameAndAcceptTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchPrompt();

        String actualPromptText = dialogBoxesPage.getAlertText();
        assertEquals("Please enter your name", actualPromptText);

        dialogBoxesPage.enterPrompt("John Doe");
        dialogBoxesPage.acceptAlert();

        String actualTextUnderPromptButton = dialogBoxesPage.getTextUnderPromptButton();
        assertEquals("You typed: John Doe", actualTextUnderPromptButton);
    }

    @Test
    @DisplayName("Enter prompted name and cancel")
    public void enterPromptedNameAndCancelTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchPrompt();

        String actualPromptText = dialogBoxesPage.getAlertText();
        assertEquals("Please enter your name", actualPromptText);

        dialogBoxesPage.enterPrompt("John Doe");
        dialogBoxesPage.dismissAlert();

        String actualTextUnderPromptButton = dialogBoxesPage.getTextUnderPromptButton();
        assertEquals("You typed: null", actualTextUnderPromptButton);
    }

    @Test
    @DisplayName("Close modal window")
    public void closeModalWindowTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchModalWindow();

        String actualModalWindowText = dialogBoxesPage.getModalWindowText();
        assertEquals("This is the modal body", actualModalWindowText);

        dialogBoxesPage.closeModalWindow();

        String actualModalWindowTextAfterClose = dialogBoxesPage.getTextUnderModalButton();
        assertEquals("You chose: Close", actualModalWindowTextAfterClose);
    }

    @Test
    @DisplayName("Save modal window changes")
    public void saveModalWindowChangesTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchModalWindow();

        String actualModalWindowText = dialogBoxesPage.getModalWindowText();
        assertEquals("This is the modal body", actualModalWindowText);

        dialogBoxesPage.saveModalWindow();

        String actualModalWindowTextAfterSave = dialogBoxesPage.getTextUnderModalButton();
        assertEquals("You chose: Save changes", actualModalWindowTextAfterSave);
    }
}
