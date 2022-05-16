public class CountVisitor implements Visitor{
    static int count=0;
    @Override
    public void visit(PptxFileDetails pptxFileDetails) {
        count++;
    }

    @Override
    public void visit(TxtFileDetails txtFileDetails) {
        count++;
    }

    @Override
    public void visit(Mp3FileDetails mp3FileDetails) {
        count++;
    }

    @Override
    public void visit(JpgFileDetails jpgFileDetails) {
        count++;
    }

    @Override
    public void visit(HtmlFileDetails htmlFileDetails) {
        count++;
    }

    @Override
    public void visit(DocxFileDetails docxFileDetails) {
        count++;
    }

    @Override
    public void visit(DirectoryDetails DirectoryDetails) {


    }
}
