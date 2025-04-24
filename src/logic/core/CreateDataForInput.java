package logic.core;

import logic.config.ConfigLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateDataForInput {

    public static void generateData(ConfigLoader config) throws IOException {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(config.inputFile))) {
            for (int i = 0; i < config.numElements; i++) {
                int value = config.minValue + random.nextInt(config.maxValue - config.minValue + 1);
                writer.write(String.valueOf(value));
                writer.newLine(); // hoặc writer.write('\b'); nếu bạn muốn dùng backspace
            }
        }

        System.out.println("✅ Dữ liệu đầu vào đã được tạo thành công: " + config.inputFile);
    }
}
