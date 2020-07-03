
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestWithDataGeneration {


        @Test
        void shouldDeliveryCardWithChangeDate (){

            Calendar c = new GregorianCalendar();
            c.add(Calendar.DAY_OF_YEAR, 5);
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            String str = format1.format(c.getTime());

            String deleteInfo = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

            DataGenerator UserOne = new DataGenerator();

            open("http://localhost:9999");
            $("[data-test-id=city] input").setValue(UserOne.getCity());
            $("[data-test-id=date] input").setValue(deleteInfo);
            $("[data-test-id=date] input").setValue(str);
            $("[data-test-id=name] input").setValue(UserOne.getFullName());
            $("[data-test-id=phone] input").setValue(UserOne.getPhoneNumber());
            $("[data-test-id=agreement]").click();
            $$("button").find(exactText("Запланировать")).click();
            $(withText("Успешно!")).waitUntil(visible, 20000);

            $("[data-test-id=city] input").setValue(deleteInfo);
            $("[data-test-id=city] input").setValue(UserOne.getCity());
            $("[data-test-id=name] input").setValue(deleteInfo);
            $("[data-test-id=name] input").setValue(UserOne.getFullName());
            $("[data-test-id=phone] input").setValue(deleteInfo);
            $("[data-test-id=phone] input").setValue(UserOne.getPhoneNumber());
            $("[data-test-id=agreement]").click();
            $("[data-test-id=agreement]").click();

            $$("button").find(exactText("Запланировать")).click();
            $(withText("Необходимо подтверждение")).waitUntil(visible, 20000);
            $$("button").find(exactText("Перепланировать")).click();
            $(withText("Успешно!")).waitUntil(visible, 20000);



        }
    }




