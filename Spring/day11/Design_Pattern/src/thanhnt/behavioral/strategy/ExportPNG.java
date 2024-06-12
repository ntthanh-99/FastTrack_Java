package thanhnt.behavioral.strategy;

public class ExportPNG implements Export {
    @Override
    public void exportFile(String fileName) {
        System.out.println("Export file: '" + fileName + ".PNG' successfully");
    }
}
