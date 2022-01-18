package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVLabTest;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterXml;
import thrPerpetualSample.transform.Transform;
import thrPerpetualSample.transform.Transformations.AddHealthCareDetails;
import thrPerpetualSample.transform.Transformations.Transformation;

import java.util.ArrayList;
import java.util.List;

public class LabTests {
    public void labTests() {
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\LabTests.csv", new ReaderCSV(), new ParserCSVLabTest());
        List<PerpetualSampleObject> objects = extract.extract();
        ArrayList<Transformation> transformations = new ArrayList<>();
        transformations.add(new AddHealthCareDetails());
        Transform transform = new Transform(objects, transformations);
        objects = transform.transform();
        Load load = new Load(objects, new WriterXml("C:\\Users\\עודד\\Desktop\\ThePerpetualSampleFiles\\LABTESTS\\", 50000));
        load.load();
    }
}
