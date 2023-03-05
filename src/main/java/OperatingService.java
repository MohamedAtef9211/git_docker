import java.util.Arrays;
import java.util.List;

public class OperatingService {
    private static final String WEB = "WEB";
    private static final String ANDROID = "ANDROID";
    private static final String IOS = "IOS";
    private static final String SPLIT = ",";


    public OperationDTO fillOperationData(String opParam) {

        // Check if param is empty
        if (opParam == null || "".equals(opParam)) return new OperationDTO();

        OperationDTO dto = new OperationDTO();

        // Check if it is single value
        if (!opParam.contains(SPLIT)) {
            return checkOperation(dto, opParam);
        }

        // Check if Multi values

        List<String> items = Arrays.asList(opParam.split("\\s*" + SPLIT + "\\s*"));

        items.forEach(item -> {
            checkOperation(dto, item);
        });

        return dto;
    }

    private OperationDTO checkOperation(OperationDTO dto, String value) {

        if (value.equals(WEB)) {
            dto.setWeb(Boolean.TRUE);
        }
        else if (value.equals(ANDROID)) {
            dto.setAndroid(Boolean.TRUE);
        }
        else if (value.equals(IOS)) {
            dto.setIos(Boolean.TRUE);
        }

        return dto;
    }

    public static void main(String[] args) {
        OperatingService operatingService = new OperatingService();

        //String params = null;
        //String params = "";
        //String params = "WEB";
        String params = "WEB,IOS,ANDROID";

        OperationDTO operationDTO = operatingService.fillOperationData(params);
        System.out.println("isWeb = " + operationDTO.isWeb());
        System.out.println("isAndroid = " + operationDTO.isAndroid());
        System.out.println("isIos = " + operationDTO.isIos());
    }


    public class OperationDTO {
        private boolean isWeb = false;
        private boolean isAndroid = false;
        private boolean isIos = false;

        public boolean isWeb() {
            return isWeb;
        }

        public void setWeb(boolean web) {
            isWeb = web;
        }

        public boolean isAndroid() {
            return isAndroid;
        }

        public void setAndroid(boolean android) {
            isAndroid = android;
        }

        public boolean isIos() {
            return isIos;
        }

        public void setIos(boolean ios) {
            isIos = ios;
        }
    }


}
