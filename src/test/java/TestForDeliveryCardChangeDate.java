
import Model.CardUser;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForDeliveryCardChangeDate {


    @Test
    void shouldDeliveryCardWithChangeDate (){

        CardUser one = new CardUser("Москва", "Петров Иван", "+79159600300");

        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 5);
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        String str = format1.format(c.getTime());

        String deleteInfo = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue(one.getCity());
        $("[data-test-id=date] input").sendKeys(deleteInfo);
        $("[data-test-id=date] input").setValue(str);
        $("[data-test-id=name] input").setValue(one.getFullName());
        $("[data-test-id=phone] input").setValue(one.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 20000);

        $("[data-test-id=city] input").sendKeys(deleteInfo);
        $("[data-test-id=city] input").setValue(one.getCity());
        $("[data-test-id=name] input").sendKeys(deleteInfo);
        $("[data-test-id=name] input").setValue(one.getFullName());
        $("[data-test-id=phone] input").sendKeys(deleteInfo);
        $("[data-test-id=phone] input").setValue(one.getPhoneNumber());
        $("[data-test-id=agreement]").click();

        $$("button").find(exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(visible, 20000);
        $$("button").find(exactText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 20000);



    }
}


