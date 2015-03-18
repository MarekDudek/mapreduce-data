package mapreducedata;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FileAccessorTest {

    private static final String EXAMPLE_FILE = "us/counties.csv";
    private static final Charset CHARSET = Charsets.UTF_8;

    @Test
    public void file_should_be_accessible_via_full_path() throws IOException {

        // given
        final File file = new File("./src/main/resources/" + EXAMPLE_FILE);

        // when
        final List<String> lines = Files.readLines(file, CHARSET);

        // then
        assertThat(lines, hasSize(3142));
    }

    @Test
    public void file_should_be_accessible_via_path_relative_to_resources_directory() throws IOException {

        // given
        final URL url = getClass().getClassLoader().getResource(EXAMPLE_FILE);

        // when
        final File file = new File(url.getFile());

        // then
        assertThat(file, notNullValue());
    }

    @Test
    public void lines_should_be_accessible_via_simple_API() {

        // when
        final List<String> lines = new FileAccessor().readLines(EXAMPLE_FILE);

        // then
        assertThat(lines, notNullValue());
    }

    @Test
    public void lines_should_be_accessible_via_even_simpler_API() {

        // when
        final List<String> lines =  FileAccessor.readLinesFromResources(EXAMPLE_FILE);

        // then
        assertThat(lines, notNullValue());
    }
}
