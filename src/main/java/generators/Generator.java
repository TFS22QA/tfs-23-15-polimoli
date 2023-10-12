package generators;

import person.models.Param;

public interface Generator {
    Param Generate(int code);
}