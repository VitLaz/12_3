package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @BeforeAll
    static void setUP() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillPracticeForm() {

        String firstName = "Vitaly";
        String lastName = "Lazarev";
        String email = "curcul87@gmail.com";
        String teleNumber = "1234567890";
        String gender = "Male";
        String hobbies = "Reading";
        String state = "Rajasthan";
        String city = "Jaiselmer";
        String subject = "Maths";
        String currentAddress = "asdfas";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(teleNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(9);
        $(".react-datepicker__year-select").selectOption("1987");
        $(byText("1")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("lightning_PNG52.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(teleNumber),
                text("01 October,1987"),
                text(subject),
                text(hobbies),
                text("lightning_PNG52.png"),
                text(currentAddress),
                text(state),
                text(city));

        $("#closeLargeModal").click();

    }

}
