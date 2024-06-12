package thanhnt.behavioral.strategy;

public class ExportContext {
    private Export export;

    public ExportContext(Export export) {
        this.export = export;
    }

    public void setStrategy(Export export) {
        this.export = export;
    }

    public void createArchive(String fileName) {
        export.exportFile(fileName);
    }
}
