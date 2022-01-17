package thrPerpetualSample;

import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.extract.Extract;
import thrPerpetualSample.extract.parser.ParserCSVMadaReport;
import thrPerpetualSample.extract.reader.ReaderCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderCSV reader = new ReaderCSV();
        ParserCSVMadaReport parser = new ParserCSVMadaReport();
        Extract madaReports = new Extract("C:\\Users\\עודד\\Desktop\\ThePerpetualSample\\ThePerpetualSample\\src\\main\\resources\\MadaReports.csv", reader, parser);
        List<PerpetualSampleObject> objects = madaReports.extract();
        System.out.println();
    }
}
