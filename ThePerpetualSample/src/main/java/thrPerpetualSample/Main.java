package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVLabTest;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterJson;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\LabTests.csv", new ReaderCSV(), new ParserCSVLabTest());
        List<PerpetualSampleObject> objects = extract.extract();
        System.out.println();
    }
}
