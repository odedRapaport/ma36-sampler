package thrPerpetualSample.transform.Transformations;

import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.List;

public interface Transformation {
    List<PerpetualSampleObject> transformation(List<PerpetualSampleObject> objects);
}
