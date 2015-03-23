package mapreducedata.maxtemperature;

public class WeatherDataParser {

    public WeatherData parse(final String line) {

        final String year = year(line);
        final int airTemperature = airTemperature(line);
        final String quality = quality(line);

        return new WeatherData(year, airTemperature, quality);
    }

    private static final int YEAR_START = 15;
    private static final int YEAR_LENGTH = 4;

    private String year(final String line) {
        return line.substring(YEAR_START, YEAR_START + YEAR_LENGTH);
    }

    private static final int AIR_TEMPERATURE_START = 87;
    private static final int AIR_TEMPERATURE_LENGTH = 5;

    private int airTemperature(final String line) {
        final String string = line.substring(AIR_TEMPERATURE_START, AIR_TEMPERATURE_START + AIR_TEMPERATURE_LENGTH);
        return Integer.parseInt(string);
    }

    private static final int QUALITY_START = 92;
    private static final int QUALITY_LENGTH = 1;

    private String quality(final String line) {
        return line.substring(QUALITY_START, QUALITY_START + QUALITY_LENGTH);
    }
}
