package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterJsonByCounter;

import java.util.List;

public class MadaReports {
    public void madaReports() {
        ReaderCSV reader = new ReaderCSV();
        ParserCSVMadaReport parser = new ParserCSVMadaReport();
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\MadaReports.csv", reader, parser);
        List<PerpetualSampleObject> objects = extract.extract();
        Load load = new Load(objects, new WriterJsonByCounter("C:\\Users\\עודד\\Desktop\\ThePerpetualSampleFiles\\mada_reports\\", 50000));
        load.load();
        System.out.println();
    }
}
