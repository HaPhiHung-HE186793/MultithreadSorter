package logic.main;

import logic.config.ConfigLoader;
import logic.core.CreateDataForInput;

public class Main {
    public static void main(String[] args) {
        try {
            // Đường dẫn đến file config (tùy theo cách bạn chạy project, có thể cần chỉnh lại đường dẫn)
            String configPath =  "src/resources/config/config.properties";

            // Load config
            ConfigLoader config = ConfigLoader.fromResource(configPath);

            CreateDataForInput.generateData(config);

        } catch (Exception e) {
            System.err.println("Lỗi khi khởi động chương trình: " + e.getMessage());
            e.printStackTrace(); // In chi tiết lỗi để debug
        }
    }
}
