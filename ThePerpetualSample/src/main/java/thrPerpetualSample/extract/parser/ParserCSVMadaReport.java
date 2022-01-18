package thrPerpetualSample.extract.parser;

import thrPerpetualSample.data.MadaReport;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.ArrayList;
import java.util.List;

public class ParserCSVMadaReport implements Parser {

    @Override
    public List<PerpetualSampleObject> parse(List<String[]> records) {
        records.remove(0);
        ArrayList<PerpetualSampleObject> reports = new ArrayList<>();
        for (String[] record :
                records) {
            MadaReport madaReport = new MadaReport(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11]);
            reports.add(madaReport);
        }
        return reports;
    }
}
