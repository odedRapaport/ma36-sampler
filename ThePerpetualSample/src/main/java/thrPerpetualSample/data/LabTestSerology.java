package thrPerpetualSample.data;

public class LabTestSerology extends PerpetualSampleObject {
    private String idNum, idType, firstName, lastName, resultDate, birthDate, labcode, stickerNumber, anidotes, kitNumber;

    public LabTestSerology(String idNum, String idType, String firstName, String lastName, String resultDate, String birthDate, String labcode, String stickerNumber, String anidotes, String kitNumber) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labcode = labcode;
        this.stickerNumber = stickerNumber;
        this.anidotes = anidotes;
        this.kitNumber = kitNumber;
    }

    public boolean isValid() {
        if ((idType.equals("0") && idNum.length() != 9) || labcode.length() != 5) {
            return false;
        } else if (!isNumber((Character.toString(labcode.charAt(0)))) || !isNumber((Character.toString(labcode.charAt(1))))
                || isNumber((Character.toString(labcode.charAt(2)))) || isNumber((Character.toString(labcode.charAt(3))))
                || !isNumber((Character.toString(labcode.charAt(4))))) {
            return false;
        }
        return true;
    }

    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLabcode() {
        return labcode;
    }

    public void setLabcode(String labcode) {
        this.labcode = labcode;
    }

    public String getStickerNumber() {
        return stickerNumber;
    }

    public void setStickerNumber(String stickerNumber) {
        this.stickerNumber = stickerNumber;
    }

    public String getAnidotes() {
        return anidotes;
    }

    public void setAnidotes(String anidotes) {
        this.anidotes = anidotes;
    }

    public String getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(String kitNumber) {
        this.kitNumber = kitNumber;
    }
}
