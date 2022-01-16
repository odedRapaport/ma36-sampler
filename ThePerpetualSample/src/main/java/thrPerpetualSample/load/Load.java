package thrPerpetualSample.load;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.load.Writer.Writer;

import java.util.List;

public class Load {
    private List<PerpetualSampleObject> objects;
    private String path;
    private Writer writer;

    public Load(List<PerpetualSampleObject> objects, String path, Writer writer) {
        this.objects = objects;
        this.path = path;
        this.writer = writer;
    }

    public void load(){
        this.writer.write(this.objects, this.path);
    }
}
