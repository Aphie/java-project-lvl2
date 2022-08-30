package hexlet.code;

import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.Map;

public class Formatter {

    public static String toConvertWithFormat(Map<String, Object> diffMap, String format) {
        String resultString = "";

        if (format.equals("stylish")) {
            resultString += StylishFormat.convertToStylishFormat(diffMap);
            return resultString;
        } else if (format.equals("plain")) {
            resultString += PlainFormat.convertToPlainFormat(diffMap);
            return resultString;
        } else {
            return "No output for such format as " + format + ". Please specify existing format for information output";
        }

    }
}
