package thrPerpetualSample.load.Writer;

import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.List;

public interface Writer {
    void write(List<PerpetualSampleObject> objects, String path, int limit);
}
