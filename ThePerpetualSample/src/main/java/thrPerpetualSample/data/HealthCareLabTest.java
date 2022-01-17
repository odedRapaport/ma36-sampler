package thrPerpetualSample.data;

public class HealthCareLabTest extends OriginalLabTest{
    private String joinDate, HealthCareId,healthCareName;

    public HealthCareLabTest(String idNum, String idType, String firstName, String lastName, String resultDate, String birthDate, String labcode, String stickerNumber, String resultTestCorona, String variant, String testType, String joinDate, String healthCareId, String healthCareName) {
        super(idNum, idType, firstName, lastName, resultDate, birthDate, labcode, stickerNumber, resultTestCorona, variant, testType);
        this.joinDate = joinDate;
        HealthCareId = healthCareId;
        this.healthCareName = healthCareName;
    }
}
