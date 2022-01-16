package thrPerpetualSample.extract.parser;

import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.List;

public interface Parser {
    List<PerpetualSampleObject> parse(List<String[]> records);
}
