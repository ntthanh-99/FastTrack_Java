package thanhnt.behavioral.strategy;

public class ExportPDF implements Export {
    @Override
    public void exportFile(String fileName) {
        System.out.println("Export file: '" + fileName + ".PDF' successfully");
    }
}
