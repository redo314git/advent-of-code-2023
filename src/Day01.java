import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Day01 {
    public static int getCalibrationNumberFirstPart(String line) {
        int firstDigit = 0, lastDigit = 0;
        boolean isFirstDigit = true;
        for (char c: line.toCharArray()) {
            if (Character.isDigit(c))
                lastDigit = Character.getNumericValue(c);
            if (Character.isDigit(c) && isFirstDigit) {
                firstDigit = lastDigit;
                isFirstDigit = false;
            }
        }
        return 10*firstDigit + lastDigit;
    }

    public static int getCalibrationNumberSecondPart(String line) {
        line = line.replaceAll("one", "o1e");
        line = line.replaceAll("two", "t2o");
        line = line.replaceAll("three", "t3e");
        line = line.replaceAll("four", "f4r");
        line = line.replaceAll("five", "f5e");
        line = line.replaceAll("six", "s6x");
        line = line.replaceAll("seven", "s7n");
        line = line.replaceAll("eight", "e8t");
        line = line.replaceAll("nine", "n9e");

        return getCalibrationNumberFirstPart(line);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/rsc/InputDay01.txt");
        List<String> fileContent = Files.readAllLines(file.toPath());
        int countFirstPart = 0;
        int countSecondPart = 0;
        for (String line : fileContent) {
            countFirstPart += getCalibrationNumberFirstPart(line);
            countSecondPart += getCalibrationNumberSecondPart(line);
        }
        System.out.println(countFirstPart);
        System.out.println(countSecondPart);
    }
}
