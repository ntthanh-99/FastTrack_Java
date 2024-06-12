package thanhnt.behavioral.strategy;

public class ExportJPG implements Export {
    @Override
    public void exportFile(String fileName) {
        System.out.println("Export file: '" + fileName + ".JPG' successfully");
    }
}
