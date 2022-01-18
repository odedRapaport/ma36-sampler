package thrPerpetualSample;

public class Main {
    public static void main(String[] args) {
        MadaReports madaReports = new MadaReports();
        LabTests labTests = new LabTests();
        PositiveCoronaPeople positiveCoronaPeople = new PositiveCoronaPeople();
        madaReports.madaReports();
        labTests.labTests();
        positiveCoronaPeople.positiveCoronaPeople();
    }
}
