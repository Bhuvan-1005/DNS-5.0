public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new DocumentFactory() {
            @Override
            public Document createDocument() {
                return new WordDocument();
            }
        };
        DocumentFactory pdfFactory = new DocumentFactory() {
            @Override
            public Document createDocument() {
                return new PdfDocument();
            }
        };
        DocumentFactory excelFactory = new DocumentFactory() {
            @Override
            public Document createDocument() {
                return new ExcelDocument();
            }
        };

        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();

        word.open();
        word.save();
        word.close();

        pdf.open();
        pdf.save();
        pdf.close();

        excel.open();
        excel.save();
        excel.close();
    }
}
