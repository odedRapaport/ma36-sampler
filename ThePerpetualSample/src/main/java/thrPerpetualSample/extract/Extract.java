package thrPerpetualSample.extract;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.parser.Parser;
import thrPerpetualSample.extract.reader.Reader;

import java.util.List;

public class Extract {
    private String path;
    private Reader reader;
    private Parser parser;

    public Extract(String path, Reader reader, Parser parser) {
        this.path = path;
        this.reader = reader;
        this.parser = parser;
    }

    public List<PerpetualSampleObject> extract() {
        return parser.parse(reader.read(path));
    }
}
