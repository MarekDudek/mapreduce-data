package mapreducedata.maxtemperature;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class WeatherDataRecord {

    private final String year;
    private final int airTemperature;
    private final String quality;

    public boolean isAirTemperaturePresent() {
        return airTemperature != MISSING_TEMPERATURE;
    }

    private static final int MISSING_TEMPERATURE = 9999;

    public boolean isQualitySufficient() {
        return QUALITY_SUFFICIENT.matcher(quality).matches();
    }

    private static final Pattern QUALITY_SUFFICIENT = Pattern.compile("[01459]");
}
