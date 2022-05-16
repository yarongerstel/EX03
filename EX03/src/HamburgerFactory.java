
public class HamburgerFactory {
    public static Hamburger createHamburger(String code){
        switch (code){
            case "cl":
                return new ClassicHamburger();
            case "sp":
                return new SpicyHamburger();
            case "la":
                return new LambHamburger();
            case "hla":
                return new HomemadeHamburger();
            default:
                throw new RuntimeException("wrong Hamburger");
        }

    }
}

