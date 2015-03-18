package mapreducedata;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileAccessor {

    public static List<String> readLinesFromResources(final String relativePath) {

        return new FileAccessor().readLines(relativePath);
    }

    public List<String> readLines(final String relativePath) {

        final InputStream stream = getClass().getClassLoader().getResourceAsStream(relativePath);
        try {
            final List<String> lines = IOUtils.readLines(stream);
            return lines;
        } catch (final IOException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
