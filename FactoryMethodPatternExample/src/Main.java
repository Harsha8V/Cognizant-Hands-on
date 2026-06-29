public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document myExcelDoc = excelFactory.createDocument();
        myExcelDoc.open();
    }
}