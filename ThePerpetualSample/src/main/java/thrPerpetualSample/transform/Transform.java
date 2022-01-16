package thrPerpetualSample.transform;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.transform.Transformations.Transformation;

import java.util.List;

public class Transform {
    private List<PerpetualSampleObject> objects;
    private List<Transformation> transformations;

    public Transform(List<PerpetualSampleObject> objects) {
        this.objects = objects;
    }

    public List<PerpetualSampleObject> transform() {
        for (Transformation transformation:
             this.transformations) {
            this.objects = transformation.transformation(this.objects);
        }
        return this.objects;
    }
}
