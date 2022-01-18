package thrPerpetualSample.transform.Transformations;

import thrPerpetualSample.data.MadaReport;
import thrPerpetualSample.data.OriginalLabTest;
import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.data.PositiveCoronaPeople;

import java.util.ArrayList;
import java.util.List;

public class MergeMadaWithTests implements Transformation {
    private List<PerpetualSampleObject> labTests;

    public MergeMadaWithTests(List<PerpetualSampleObject> labTests) {
        this.labTests = positiveTests(labTests);
    }

    public List<PerpetualSampleObject> positiveTests(List<PerpetualSampleObject> labTests) {
        ArrayList<PerpetualSampleObject> positiveTests = new ArrayList<>();
        for (PerpetualSampleObject labTest :
                labTests) {
            if (((OriginalLabTest) labTest).getResultTestCorona().equals("1")) {
                positiveTests.add(labTest);
            }
        }
        return positiveTests;
    }

    @Override
    public List<PerpetualSampleObject> transformation(List<PerpetualSampleObject> objects) {
        ArrayList<PerpetualSampleObject> positiveRepoerts = new ArrayList<>();
        for (PerpetualSampleObject positiveTest :
                this.labTests) {
            OriginalLabTest test = (OriginalLabTest) positiveTest;
            for (PerpetualSampleObject madaReport :
                    objects) {
                MadaReport report = (MadaReport) madaReport;
                if (test.getIdNum().equals(report.getIdNum()) && test.getIdType().equals(report.getIdType())) {
                    positiveRepoerts.add(new PositiveCoronaPeople(report.getMdaCode(), report.getIdNum(),
                            report.getIdType(), report.getFirstName(), report.getLastName(),
                            report.getCity(), report.getStreet(), report.getBuildingNumber(), report.getBarcode(),
                            test.getBirthDate(), test.getLabcode(), test.getResultDate(),
                            report.getTakeDate(), test.getStickerNumber(), test.getResultTestCorona(),
                            test.getVariant(), test.getTestType()));
                }
            }

        }
        return positiveRepoerts;
    }
}
