package logic.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public int numThreads;
    public String inputFile;
    public String outputFile;
    public int numElements;
    public int minValue;
    public int maxValue;

    // Constructor chính nhận vào InputStream
    public ConfigLoader(InputStream input) throws IOException {
        Properties props = new Properties();
        props.load(input);
        input.close();

        numThreads = Integer.parseInt(props.getProperty("num_threads"));
        inputFile = props.getProperty("input_file");
        outputFile = props.getProperty("output_file");
        numElements = Integer.parseInt(props.getProperty("num_elements"));
        minValue = Integer.parseInt(props.getProperty("min_value"));
        maxValue = Integer.parseInt(props.getProperty("max_value"));

        validateConfig();
    }

    private void validateConfig() {
        if (numThreads <= 0) {
            throw new IllegalArgumentException("Số luồng (num_threads) phải lớn hơn 0.");
        }
        if (numElements <= 0) {
            throw new IllegalArgumentException("Số phần tử (num_elements) phải lớn hơn 0.");
        }
        if (minValue >= maxValue) {
            throw new IllegalArgumentException("min_value phải nhỏ hơn max_value.");
        }
        if (inputFile == null || inputFile.isEmpty()) {
            throw new IllegalArgumentException("input_file không được để trống.");
        }
        if (outputFile == null || outputFile.isEmpty()) {
            throw new IllegalArgumentException("output_file không được để trống.");
        }
    }

    // Dùng khi file nằm trong resources (classpath)
    public static ConfigLoader fromResource(String resourcePath) throws IOException {
        InputStream in = new FileInputStream(resourcePath);

        if (in == null) {
            throw new IOException("Không tìm thấy file cấu hình trong resources: " + resourcePath);
        }
        return new ConfigLoader(in);
    }
}
