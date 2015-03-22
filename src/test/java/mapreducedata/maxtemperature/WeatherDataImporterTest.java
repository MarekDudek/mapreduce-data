package mapreducedata.maxtemperature;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class WeatherDataImporterTest {

    @Test
    public void importing_data() {

        // when
        final List<WeatherDataRecord> records = new WeatherDataImporter().importData("max-temperature/input/1901");

        // then
        assertThat(records, hasSize(6565));
    }

}
