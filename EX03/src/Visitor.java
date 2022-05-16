public interface Visitor {

    void visit(PptxFileDetails pptxFileDetails);

    void visit(TxtFileDetails txtFileDetails);

    void visit(Mp3FileDetails mp3FileDetails);

    void visit(JpgFileDetails jpgFileDetails);

    void visit(HtmlFileDetails htmlFileDetails);

    void visit(DocxFileDetails docxFileDetails);

    void visit(DirectoryDetails DirectoryDetails);
}
