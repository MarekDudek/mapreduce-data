package mapreducedata.maxtemperature;

import com.google.common.base.MoreObjects;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.checkNotNull;

public class WeatherDataRecord {

    private final String year;
    private final int airTemperature;
    private final String quality;

    public WeatherDataRecord(final String year, final int airTemperature, final String quality) {
        this.year = checkNotNull(year);
        this.airTemperature = airTemperature;
        this.quality = checkNotNull(quality);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("year", year)
                .add("air temperature", airTemperature)
                .add("quality", quality)
                .toString();
    }

    public String getYear() {
        return year;
    }

    public int getAirTemperature() {
        return airTemperature;
    }

    public String getQuality() {
        return quality;
    }

    public boolean isAirTemperaturePresent() {
        return airTemperature != MISSING_TEMPERATURE;
    }

    private static final int MISSING_TEMPERATURE = 9999;

    public boolean isQualitySufficient() {
        return QUALITY_SUFFICIENT.matcher(quality).matches();
    }

    private static final Pattern QUALITY_SUFFICIENT = Pattern.compile("[01459]");
}
