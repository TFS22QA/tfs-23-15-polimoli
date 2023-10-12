package generators;

import person.models.FullName;
import person.models.Param;

import static utils.FileReader.getLinesFromFile;
import static utils.MyMath.getDigitsSum;

public class FullNameGenerator implements Generator {

    @Override
    public final FullName generate(int code){
        final int digitSum = getDigitsSum(code);
        final String sex = (digitSum % 2 == 0) ? "f" : "m";
        String lastName = getLinesFromFile("lastNames_" + sex).get(digitSum);;
        String firstName =  getLinesFromFile("names_" + sex).get(getDigitsSum(code / 100));;
        String middleName = getLinesFromFile("middleNames_" + sex).get(getDigitsSum(code % 100));;

        return new FullName(firstName,lastName,middleName);
    }
}
