package generators;

import person.models.FullName;
import person.models.Param;

public interface Generator {
    Param generate(final int code);
}