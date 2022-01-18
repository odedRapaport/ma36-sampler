package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVLabTestSerology;
import thrPerpetualSample.extract.reader.ReaderCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\Serology.csv", new ReaderCSV(), new ParserCSVLabTestSerology());
        List<PerpetualSampleObject> objects = extract.extract();
        System.out.println();

        /*MadaReports madaReports = new MadaReports();
        LabTests labTests = new LabTests();
        PositiveCoronaPeople positiveCoronaPeople = new PositiveCoronaPeople();
        madaReports.madaReports();
        labTests.labTests();
        positiveCoronaPeople.positiveCoronaPeople();*/
    }
}
