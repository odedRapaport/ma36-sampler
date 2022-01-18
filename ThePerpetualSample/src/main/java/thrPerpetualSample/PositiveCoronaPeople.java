package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVLabTest;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterJsonByBytes;
import thrPerpetualSample.transform.Transform;
import thrPerpetualSample.transform.Transformations.MergeMadaWithTests;
import thrPerpetualSample.transform.Transformations.Transformation;

import java.util.ArrayList;
import java.util.List;

public class PositiveCoronaPeople {
    public void positiveCoronaPeople(){
        Extract labTests = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\LabTests.csv", new ReaderCSV(), new ParserCSVLabTest());
        Extract madaReports = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\MadaReports.csv", new ReaderCSV(), new ParserCSVMadaReport());
        ArrayList<Transformation> transformations = new ArrayList<>();
        transformations.add((new MergeMadaWithTests(labTests.extract())));
        Transform transform = new Transform(madaReports.extract(), transformations);
        List<PerpetualSampleObject> objects = transform.transform();
        Load load = new Load(objects, "C:\\Users\\עודד\\Desktop\\ThePerpetualSampleFiles\\POSITIVE_CORONA_PEOPLE\\", new WriterJsonByBytes(), 20000000);
        load.load();
    }
}
