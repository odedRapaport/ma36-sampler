package thrPerpetualSample.extract.parser;

import thrPerpetualSample.data.LabTestSerology;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.ArrayList;
import java.util.List;

public class ParserCSVLabTestSerology implements Parser{
    @Override
    public List<PerpetualSampleObject> parse(List<String[]> records) {
        records.remove(0);
        ArrayList<PerpetualSampleObject> tests = new ArrayList<>();
        for (String[] record :
                records) {
            LabTestSerology labTest = new LabTestSerology(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9]);
            if (labTest.isValid()) {
                tests.add(labTest);
            }
        }
        return tests;
    }
}
