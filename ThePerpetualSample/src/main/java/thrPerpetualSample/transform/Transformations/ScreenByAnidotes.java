package thrPerpetualSample.transform.Transformations;

import thrPerpetualSample.data.LabTestSerology;
import thrPerpetualSample.data.PerpetualSampleObject;
import thrPerpetualSample.data.PositiveCoronaPeople;

import java.util.ArrayList;
import java.util.List;

public class ScreenByAnidotes implements Transformation{
    @Override
    public List<PerpetualSampleObject> transformation(List<PerpetualSampleObject> objects) {
        ArrayList<PerpetualSampleObject> labTests = new ArrayList<>();
        for (PerpetualSampleObject labTest:
             objects) {
            if(((LabTestSerology) labTest).getKitNumber().equals("15") && Integer.parseInt(((LabTestSerology) labTest).getAnidotes())>=500){
                labTests.add(labTest);
            }
            else if(((LabTestSerology) labTest).getKitNumber().equals("16") && Integer.parseInt(((LabTestSerology) labTest).getAnidotes())>=1500){
                labTests.add(labTest);
            }
            else if(((LabTestSerology) labTest).getKitNumber().equals("17") && Integer.parseInt(((LabTestSerology) labTest).getAnidotes())>=3000){
                labTests.add(labTest);
            }
        }
        return labTests;
    }
}
