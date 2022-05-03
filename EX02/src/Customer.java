

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String customerInfo)
    {
        String [] arr = customerInfo.split(" ");
        id = Long.parseLong(arr[1]);
        name = arr[3];
        tier = Integer.parseInt(arr[5]);
    }

    public Customer(long Cid,String Cname, int Ctier)
    {
        setId(Cid);
        setName(Cname);
        setTier(Ctier);
    }

    public String toString()
    {
        return "customer: "+ getId() + " name: "+ getName() +" tier: "+ getTier()+"\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}