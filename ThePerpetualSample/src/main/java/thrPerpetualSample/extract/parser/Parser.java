package thrPerpetualSample.extract.parser;

import thrPerpetualSample.data.PerpetualSampleObject;

import java.io.BufferedReader;
import java.util.List;

public interface Parser {
    List<PerpetualSampleObject> parse(BufferedReader br);
}
