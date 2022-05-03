

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Long.parseLong;

public class Order {

    private long orderId;
    private Date orderDate;
    private Date deliveryDate;
    private OrderStatus status;
    private long customerId;

    public Order(String orderInfo)  {

        String [] arr = orderInfo.split(" ");

        orderId = Long.parseLong(arr[1]);
        try {
            orderDate=new SimpleDateFormat("dd/MM/yyyy").parse(arr[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            deliveryDate=new SimpleDateFormat("dd/MM/yyyy").parse(arr[7]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        status = OrderStatus.valueOf(arr[9]);
        customerId = Long.parseLong(arr[12]);

    }

    public Order(long Oid, Date OorderDate, Date OdeliveryDate, OrderStatus Ostatus, long OcustomrId) {
        setOrderId(Oid);
        setOrderDate(OorderDate);
        setDeliveryDate(OdeliveryDate);
        setStatus(Ostatus);
        setCustomerId(OcustomrId);
    }


    public String toString()
    {
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return "order: "+ getOrderId() + " order date: "+ ft.format(getOrderDate()) +" delivery date: "+ ft.format(getDeliveryDate()) + " status: "+ getStatus() + " customr id: "+ getCustomerId()+"\n";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}