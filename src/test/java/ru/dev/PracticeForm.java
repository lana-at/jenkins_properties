package ru.dev;
import org.junit.jupiter.api.Test;
import static testdata.TestData.*;


public class PracticeForm extends TestBase{


    @Test
    void successfulLoginTest() {

        practiceFormPage.openPage()
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
        practiceFormPage.openPage()
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
        practiceFormPage.openPage()
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .submitFormErrors()
                .validationErrors()
                .modalNotShown();

    }


    @Test
    void negativeInvalidEmail() {
        practiceFormPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(wrongEmail)
                .setGender(genderWrapper)
                .typeNumber(userNumber)
                .submitFormErrors()
                .validationErrors()
                .modalNotShown();
    }

    @Test
    void negativeInvalidPhone() {
        practiceFormPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genderWrapper)
                .typeNumber(wrongNumber)
                .submitFormErrors()
                .validationErrors()
                .modalNotShown();

    }

    @Test
    void negativeEmptyGender() {
        practiceFormPage.openPage()
                .typeLastName(lastName)
                .typeNumber(userNumber)
                .submitFormErrors()
                .validationErrors()
                .modalNotShown();

    }

    @Test
    void negativeEmptyForm() {
        practiceFormPage.openPage()
                .submitFormErrors()
                .validationErrors()
                .modalNotShown();

    }




}