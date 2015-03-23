package mapreducedata.maxtemperature;

import com.google.common.collect.Lists;
import mapreducedata.FileAccessor;

import java.util.List;

public class WeatherDataImporter {

    public List<WeatherData> importData(final String file) {

        final List<String> lines = FileAccessor.readLinesFromResources(file);
        final WeatherDataParser parser = new WeatherDataParser();

        final List<WeatherData> records = Lists.newArrayList();
        for (final String line : lines) {
            final WeatherData record = parser.parse(line);
            records.add(record);
        }

        return records;
    }
}
