public class HambDecotator implements Hamburger{
    private Hamburger itsHamb;
    public HambDecotator(Hamburger hamb)
    {
        this.itsHamb = hamb;
    }
    @Override
    public String serve() {
        return itsHamb.serve();
    }
}
