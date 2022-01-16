package thrPerpetualSample.extract.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReaderCSV implements Reader {
    @Override
    public List<String[]> read(String path) {
        try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
            List<String[]> records = reader.readAll();
            return records;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
