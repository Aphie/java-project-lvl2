package hexlet.code;

import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.PlainFormat;
import hexlet.code.formatters.StylishFormat;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String toConvertWithFormat(List<Map<String, Object>> diffList, String format)
            throws RuntimeException {

        return switch (format.toLowerCase()) {
            case "plain" -> PlainFormat.convertToPlainFormat(diffList);
            case "stylish" -> StylishFormat.convertToStylishFormat(diffList);
            case "json" -> JsonFormat.convertToJsonFormat(diffList);
            default -> throw new RuntimeException("No output for such format as "
                    + format + ". Please specify existing format for information output");
        };
    }
}
