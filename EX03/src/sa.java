public class sa extends HambDecotator{
    public sa(Hamburger hamb) {
        super(hamb);
    }
    public String serve() { return super.serve()+"with salad ";}
}
