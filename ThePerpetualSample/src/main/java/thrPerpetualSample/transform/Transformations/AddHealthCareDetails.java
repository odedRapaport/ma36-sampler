package thrPerpetualSample.transform.Transformations;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import thrPerpetualSample.data.HealthCareLabTest;
import thrPerpetualSample.data.OriginalLabTest;
import thrPerpetualSample.data.PerpetualSampleObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddHealthCareDetails implements Transformation{
    @Override
    public List<PerpetualSampleObject> transformation(List<PerpetualSampleObject> objects) {
        ArrayList<PerpetualSampleObject> labTests = new ArrayList<>();
        HealthCareInfoProvider provider = new HealthCareInfoProvider();
        for (PerpetualSampleObject labTest:
             objects) {
            OriginalLabTest lt = (OriginalLabTest)labTest;
            try {
                PersonInsured personInsured = provider.fetchInfo(parseInt(lt.getIdNum()), parseInt(lt.getIdType()));
                labTests.add(new HealthCareLabTest(lt.getIdNum(), lt.getIdType(), lt.getFirstName(),
                        lt.getLastName(), lt.getResultDate(), lt.getBirthDate(), lt.getLabcode(),
                        lt.getStickerNumber(), lt.getResultTestCorona(), lt.getVariant(), lt.getTestType(),
                        personInsured.getJoinDate().toString(), (Integer.toString(personInsured.getHealthCareId())), personInsured.getHealthCareName()));
            } catch (InvalidIdException e) {
            }
        }
        return labTests;
    }
}
