public class ch extends HambDecotator{
    public ch(Hamburger hamb) {
        super(hamb);
    }
    public String serve() {return super.serve()+"with chips ";}
}
