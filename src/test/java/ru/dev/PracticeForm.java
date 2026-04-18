package ru.dev;
import org.junit.jupiter.api.Test;
import static testdata.TestData.*;


public class PracticeForm extends TestBase{


    @Test
    void successfulLoginTest() {

        textBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .typeSubjects(subjects)
                .setHobbies(hobbies)
                .typePicture(uploadfile)
                .typeAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderWrapper)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadfile)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);


    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        textBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .submitForm()
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genderWrapper)
                .checkResult("Mobile", userNumber);


    }


    @Test
    void negativeEmptyFirstNameTest() {
        textBoxPage.openPage()
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .submitFormErrors()
                .ValidationErrors()
                .ModalNotShown();

    }


    @Test
    void negativeInvalidEmail() {
        textBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(wrongEmail)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .submitFormErrors()
                .ValidationErrors()
                .ModalNotShown();
    }

    @Test
    void negativeInvalidPhone() {
        textBoxPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeNumber(wrongNumber)
                .submitFormErrors()
                .ValidationErrors()
                .ModalNotShown();

    }

    @Test
    void negativeEmptyGender() {
        textBoxPage.openPage()
                .typeLastName(lastName)
                .typeNumber(userNumber)
                .submitFormErrors()
                .ValidationErrors()
                .ModalNotShown();

    }

    @Test
    void negativeEmptyForm() {
        textBoxPage.openPage()
                .submitFormErrors()
                .ValidationErrors()
                .ModalNotShown();

    }




}