package generators;

import person.models.Passport;
import person.models.Physical;
import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;

import java.util.Random;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class ParamGenerator {
    private static int MINIMUM_WEIGHT = 30;

    /**
     * по третьей цифре кода:
     * Глаза: 0..4
     * Длина волос: i
     * Цвет волос: 0..8.
     *
     * @return .
     */
    public Appearance appearanceGeneration(final int code) {
        final int thirdDigit = code % 100 / 10;
        String eyes = EyesColor.values()[thirdDigit / 2].name().toLowerCase();
        String hairColour = null;
        if (thirdDigit > 0) {
            hairColour = HairColor.values()[thirdDigit - 1].name().toLowerCase();
        }
        return new Appearance(eyes, new Hair(thirdDigit, hairColour));
    }

    /**
     * сумма цифр в коде.
     */
    public String lastNameGeneration(final int code) {
        final int digitSum = getDigitsSum(code);
        final String s = (digitSum % 2 == 0) ? "f" : "m";
        return getLinesFromFile("lastNames_" + s).get(digitSum);
    }

    /**
     * сумма первых двух цифр.
     */
    public String FirstNameGeneration(final int code) {
        final int digitSum = getDigitsSum(code);
        final String sex = (digitSum % 2 == 0) ? "f" : "m";
        return getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100));
    }

    /**
     * сумма последних двух цифр.
     */
    public String MiddleNameGeneration(final int code) {
        final int digitSum = getDigitsSum(code);
        final String sex = (digitSum % 2 == 0) ? "f" : "m";
        return getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100));
    }

    /**
     * по второй цифре кода:
     * Возраст: 10..100
     * Вес: 30..120
     * Рост: 1..1,9
     */
    public Physical GeneratePhysics(final int code) {
        final int secondDigit = code % 1000 / 100;
        int personAge = (secondDigit + 1) * 10;
        int personWeight = MINIMUM_WEIGHT + secondDigit * 10;
        double personHeight = (100 + secondDigit * 10) / 100.00;
        return new Physical(personAge, personWeight, personHeight);
    }

    /**
     * Генерация номера паспорта.
     *
     * @param code код
     * @return номер паспорта
     */
    public Passport passNumGen(final int code) {
        final int maxNumber = 999999;
        final String passportNumber = String.valueOf(code) + new Random().nextInt(maxNumber);
        return new Passport(passportNumber);
    }
}
