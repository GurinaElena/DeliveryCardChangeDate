import com.github.javafaker.Faker;
import java.util.Locale;

public class DataGenerator {


    Faker faker = new Faker(new Locale("ru"));

    private String fullName = faker.name().fullName();
    private String city = faker.address().city();
    private String phoneNumber = faker.phoneNumber().phoneNumber();


    public  String getCity() {
        return city;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }






}



