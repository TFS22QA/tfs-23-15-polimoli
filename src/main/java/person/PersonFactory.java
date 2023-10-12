package person;

import generators.AppearanceGenerator;
import generators.FullNameGenerator;
import generators.PhoneGenerator;

public class PersonFactory {

    public static Person getPerson(final String code) {


        // добавляем телефон, только если введённый код не палиндром


        return new Person(
                code,
                new FullNameGenerator().generate(Integer.parseInt(code));
        new PhoneGenerator().generate(Integer.parseInt(code));
        new AppearanceGenerator().generate(Integer.parseInt(code));
        new FullNameGenerator().generate(Integer.parseInt(code));
        new PhoneGenerator().generate(Integer.parseInt(code));
        );
    }
}
