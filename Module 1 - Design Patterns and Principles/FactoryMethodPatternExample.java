public class FactoryMethodPatternExample {

    // Step 2: Document Interface
    interface Document {
        void open();
    }

    // Step 3: Concrete Document Classes
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening Word Document");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening PDF Document");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening Excel Document");
        }
    }

    // Step 4: Abstract Factory
    static abstract class DocumentFactory {
        abstract Document createDocument();
    }

    // Concrete Factories
    static class WordFactory extends DocumentFactory {
        Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {
        Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test Factory Method
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();

        DocumentFactory excelFactory = new ExcelFactory();
        Document excel = excelFactory.createDocument();
        excel.open();
    }
}