package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String toConvertWithFormat(List<Map<String, Object>> diffList, String format)
            throws JsonProcessingException {
        String resultString = "";

        if (format.equals("stylish")) {
            resultString += StylishFormat.convertToStylishFormat(diffList);
            return resultString;
        } else if (format.equals("plain")) {
            resultString += PlainFormat.convertToPlainFormat(diffList);
            return resultString;
        } else if (format.equals("json")) {
            resultString += JsonFormat.convertToJsonFormat(diffList);
            return resultString;
        } else {
            return "No output for such format as " + format + ". Please specify existing format for information output";
        }
    }
}
