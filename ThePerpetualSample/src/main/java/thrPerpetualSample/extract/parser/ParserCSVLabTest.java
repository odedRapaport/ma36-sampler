package thrPerpetualSample.extract.parser;

import thrPerpetualSample.data.OriginalLabTest;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.ArrayList;
import java.util.List;

public class ParserCSVLabTest implements Parser {
    @Override
    public List<PerpetualSampleObject> parse(List<String[]> records) {
        records.remove(0);
        ArrayList<PerpetualSampleObject> tests = new ArrayList<>();
        for (String[] record :
                records) {
            OriginalLabTest labTest = new OriginalLabTest(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10]);
            tests.add(labTest);
        }
        return tests;
    }
}
