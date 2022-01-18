package thrPerpetualSample.load.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterJsonByCounter implements Writer {
    private String path;
    private int limit;

    public WriterJsonByCounter(String path, int limit) {
        this.path = path;
        this.limit = limit;
    }

    @Override
    public void write(List<PerpetualSampleObject> objects) {
        for (int i = 0; i < threadCount(objects, limit); i++) {
            threadWriter(i, objects, path, limit);
        }
    }

    public void threadWriter(int index, List<PerpetualSampleObject> objects, String path, int limit) {
        Thread thread = new Thread(() -> {
            ArrayList<PerpetualSampleObject> limitList = new ArrayList<>();
            for (int i = index * limit; i < index * limit + limit && i < objects.size(); i++) {
                limitList.add(objects.get(i));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new FileWriter(new File(path + index + ".json"), true), limitList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public int threadCount(List<PerpetualSampleObject> objects, int limit) {
        if (objects.size() % limit == 0) {
            return objects.size() / limit;
        }
        return objects.size() / limit + 1;
    }
}
