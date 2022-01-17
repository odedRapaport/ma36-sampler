package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVLabTest;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterJson;
import thrPerpetualSample.transform.Transform;
import thrPerpetualSample.transform.Transformations.AddHealthCareDetails;
import thrPerpetualSample.transform.Transformations.Transformation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\LabTests.csv", new ReaderCSV(), new ParserCSVLabTest());
        List<PerpetualSampleObject> objects = extract.extract();
        ArrayList<Transformation> transformations = new ArrayList<>();
        transformations.add(new AddHealthCareDetails());
        Transform transform = new Transform(objects,transformations);
        objects = transform.transform();
        System.out.println();
    }
}
