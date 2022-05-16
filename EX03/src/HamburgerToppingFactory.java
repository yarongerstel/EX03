public class HamburgerToppingFactory {
    public static HambDecotator addToppic (String toppic,Hamburger hamb)
    {
        switch (toppic){
            case "ch":
                return new ch(hamb);
            case "or":
                return new or(hamb);
            case "sa":
                return new sa(hamb);
            case "fe":
                return new fe(hamb);
            default:
                throw new RuntimeException("wrong Toppic");
        }
    }
}
