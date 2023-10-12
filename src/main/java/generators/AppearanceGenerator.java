package generators;

import person.models.appearance.Appearance;
import person.models.appearance.Hair;
import person.models.appearance.enums.EyesColor;
import person.models.appearance.enums.HairColor;

public class AppearanceGenerator implements Generator {
    @Override
    public Appearance generate(final int code) {
        final int thirdDigit = code % 100 / 10;
        String eyes = EyesColor.values()[thirdDigit / 2].name().toLowerCase();
        String hairColour = null;
        if (thirdDigit > 0) {
            hairColour = HairColor.values()[thirdDigit - 1].name().toLowerCase();
        }
        return new Appearance(eyes, new Hair(thirdDigit, hairColour));
    }
}
