package generators;

import person.models.Physical;

public class PhysicalGenerator implements Generator{
    private static final int MINIMUM_WEIGHT = 30;

    @Override
    public Physical generate(final int code) {
        final int secondDigit = code % 1000 / 100;
        int personAge = (secondDigit + 1) * 10;
        int personWeight = MINIMUM_WEIGHT + secondDigit * 10;
        double personHeight = (100 + secondDigit * 10) / 100.00;
        return new Physical(personAge, personWeight, personHeight);
    }

}
