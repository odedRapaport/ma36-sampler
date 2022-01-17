package thrPerpetualSample.load;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.load.Writer.Writer;

import java.util.List;

public class Load {
    private List<PerpetualSampleObject> objects;
    private String path;
    private Writer writer;
    private int limit;

    public Load(List<PerpetualSampleObject> objects, String path, Writer writer, int limit) {
        this.objects = objects;
        this.path = path;
        this.writer = writer;
        this.limit = limit;
    }

    public void load(){
        this.writer.write(this.objects, this.path, this.limit);
    }
}
