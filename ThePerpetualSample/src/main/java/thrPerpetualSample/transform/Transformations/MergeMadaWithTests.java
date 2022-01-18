package thrPerpetualSample.transform.Transformations;

import thrPerpetualSample.data.OriginalLabTest;
import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.data.PositiveCoronaPeople;

import java.util.ArrayList;
import java.util.List;

public class MergeMadaWithTests implements Transformation{
    private List<PerpetualSampleObject> labTests;

    public MergeMadaWithTests(List<PerpetualSampleObject> labTests) {
        this.labTests = positiveTests(this.labTests);
    }

    public List<PerpetualSampleObject> positiveTests(List<PerpetualSampleObject> labTests){
        ArrayList<PerpetualSampleObject> positiveTests = new ArrayList<>();
        for (PerpetualSampleObject labTest:
             labTests) {
            if(((OriginalLabTest) labTest).getResultTestCorona().equals("1")){
                positiveTests.add(labTest);
            }
        }
        return positiveTests;
    }

    @Override
    public List<PerpetualSampleObject> transformation(List<PerpetualSampleObject> objects) {
        ArrayList<PerpetualSampleObject> positiveRepoerts = new ArrayList<>();
        for (PerpetualSampleObject positiveTest:
             this.labTests) {
            
        }
        return positiveRepoerts;
    }
}
