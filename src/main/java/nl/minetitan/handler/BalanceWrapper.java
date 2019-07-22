package nl.minetitan.handler;
/*
Door: Maiky
Package: nl.minetitan.handler in de class BalanceWrapper.
*/

import java.text.DecimalFormat;
import java.util.Locale;

public class BalanceWrapper {

    public String convert(double d){
        DecimalFormat BE_DF = (DecimalFormat) DecimalFormat.getNumberInstance(Locale.GERMAN);

        return BE_DF.format(d);
    }

}
