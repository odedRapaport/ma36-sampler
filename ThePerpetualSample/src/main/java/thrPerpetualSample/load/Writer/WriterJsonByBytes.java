package thrPerpetualSample.load.Writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WriterJsonByBytes implements Writer{
    private String path;
    private int limit;

    public WriterJsonByBytes(String path, int limit) {
        this.path = path;
        this.limit = limit;
    }

    @Override
    public void write(List<PerpetualSampleObject> objects) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<PerpetualSampleObject> limitList = new ArrayList<>();
        int totalBytes = 0;
        int index = 0;
        for (PerpetualSampleObject o:
             objects) {
            JsonNode node = objectMapper.valueToTree(o);
            if (totalBytes + bytesCounter(node) < limit){
                limitList.add(o);
                totalBytes+= bytesCounter(node);
            }
            else {
                threadWriter(index, limitList, path);
                limitList.clear();
                totalBytes = 0;
                limitList.add(o);
                totalBytes+= bytesCounter(node);
                index++;
            }
        }
        threadWriter(index, limitList, path);
    }

    public void threadWriter(int index, List<PerpetualSampleObject> limitList, String path){
        Thread thread = new Thread(() -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new FileWriter(new File(path + index + ".json"), true), limitList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public int bytesCounter(JsonNode jsonNode){
        int counter = 0;
        if (jsonNode!=null) {
            for (Iterator<JsonNode> nodes = jsonNode.elements(); nodes.hasNext(); ) {
                nodes.next();
                counter++;
            }
        }
        return counter;
    }
}
