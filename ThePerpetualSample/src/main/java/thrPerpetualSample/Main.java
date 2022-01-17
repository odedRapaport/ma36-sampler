package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;
import thrPerpetualSample.load.Load;
import thrPerpetualSample.load.Writer.WriterJson;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderCSV reader = new ReaderCSV();
        ParserCSVMadaReport parser = new ParserCSVMadaReport();
        Extract extract = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\MadaReports.csv", reader, parser);
        List<PerpetualSampleObject> objects = extract.extract();
        Load load = new Load(objects,"C:\\Users\\עודד\\Desktop\\ThePerpetualSampleFiles\\mada_reports\\", new WriterJson(), 50000);
        load.load();
        System.out.println();
    }
}
