import java.util.LinkedList;
import java.util.List;


public class DirectoryDetails extends FileDetails {
    private List<FileDetails> filesList = new LinkedList<>();
    public DirectoryDetails(String path, String name){
        super(path,name);
    }
    public void addFile(FileDetails fileDetails){
        filesList.add(fileDetails);
    }
    public int getlengthlist(){return filesList.size();}

    public void accept(Visitor v)
    {

        for (FileDetails file : filesList){
            file.accept(v);
        }
        v.visit(this);

    }
}