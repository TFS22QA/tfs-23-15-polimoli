package generators;

import person.models.Phone;
import utils.MyMath;

import java.util.Random;

public class PhoneGenerator implements Generator{
    @Override
    public final Phone generate(final int code){
        String sCode = Integer.toString(code);
        if (!sCode.contentEquals(new StringBuilder(sCode).reverse())) {
            final String number = "+79"
                    + String.format("%02d", MyMath.getDigitsSum(Integer.parseInt(sCode)))
                    + String.format("%03d", new Random().nextInt(1000))
                    + String.format("%04d", Integer.parseInt(sCode));
            return new Phone(number);
        }else {
            return new Phone("N/A");
        }
    }
}
