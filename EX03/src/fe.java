public class fe extends HambDecotator{
    public fe(Hamburger hamb) {
        super(hamb);
    }
    public String serve() {
        return super.serve()+"with fried egg ";
    }
}
