package thanhnt.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        ExportContext ctx = new ExportContext(new ExportPNG());
        ctx.createArchive("Mushroom");
        ctx.setStrategy(new ExportJPG());
        ctx.createArchive("Mushroom");
        ctx.setStrategy(new ExportPDF());
        ctx.createArchive("Mushroom");
    }
}
