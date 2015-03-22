package mapreducedata.maxtemperature;

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
}
