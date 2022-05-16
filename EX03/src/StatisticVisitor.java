public class StatisticVisitor implements Visitor{
    @Override
    public void visit(PptxFileDetails pptxFileDetails) {
        System.out.println("The average slide size in Presentation "+pptxFileDetails.getFullName()+
                " is "+pptxFileDetails.getSize()/ pptxFileDetails.getSlides()+".");
    }

    @Override
    public void visit(TxtFileDetails txtFileDetails) {
        System.out.println("The file "+txtFileDetails.getName()+" contains "+txtFileDetails.getWords()+" words.");
    }

    @Override
    public void visit(Mp3FileDetails mp3FileDetails) {
        System.out.println("The bitrate of "+ mp3FileDetails.getFullName()+
                " is "+mp3FileDetails.getSize()/ mp3FileDetails.getLengthSec() +
                " bytes per second.");

    }

    @Override
    public void visit(JpgFileDetails jpgFileDetails) {
        System.out.println("The picture "+jpgFileDetails.getFullName()+
                " has an average of "+Math.round(jpgFileDetails.getSize()/(float)(jpgFileDetails.getHeight()* jpgFileDetails.getWidth()))
                +" bytes per pixel.");
    }

    @Override
    public void visit(HtmlFileDetails htmlFileDetails) {
        System.out.println("The file "+htmlFileDetails.getName()+" contains "+htmlFileDetails.getLines()+" lines.");
    }

    @Override
    public void visit(DocxFileDetails docxFileDetails) {
        System.out.println("The file "+docxFileDetails.getName()+" has an average of "+
                docxFileDetails.getWords()/docxFileDetails.getPages()+" words per page.");
    }

    @Override
    public void visit(DirectoryDetails DirectoryDetails) {
        System.out.println("Directory "+DirectoryDetails.getName()+
                " has "+DirectoryDetails.getlengthlist()+" files.");

    }
}
