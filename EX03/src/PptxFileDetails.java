public class PptxFileDetails extends FileDetails {
    private int slides;
    private int size;
    public PptxFileDetails(String path, String fileName, int slides, int size){
        super(path,fileName);
        this.slides=slides;
        this.size=size;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
    public int getSlides() {
        return slides;
    }

    public int getSize() {
        return size;
    }
}
