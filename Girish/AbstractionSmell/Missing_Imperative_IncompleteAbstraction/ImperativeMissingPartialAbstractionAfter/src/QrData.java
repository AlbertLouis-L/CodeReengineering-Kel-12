import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class QrData {
    private final Map<String, String> qrMap;

    public QrData() {
        this.qrMap = new HashMap<>();
    }

    public void saveQr(String name, String text) {
        qrMap.put(name, text);
    }

    public Optional<String> loadQr(String name) {
        return Optional.ofNullable(qrMap.get(name));
    }
}
