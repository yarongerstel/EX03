

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {
        return DataSource.allProducts.stream()
                .filter(p -> p.getProductId()==productId)
                .findFirst().orElse(null);
    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream()
                .filter(o -> o.getOrderId()==orderId)
                .findFirst().orElse(null);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream()
                .filter(o -> o.getId()==customerId)
                .findFirst().orElse(null);
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts.stream()
                .filter(p -> p.getCategory()==cat)
                .filter(p -> p.getPrice()<=price)
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(toList());
    }

    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                                    .filter(p-> p.getTier()==3)
                                    .collect(toList());
//        List<Customer> custumer=DataSource.allCustomers.stream()
//                                    .filter(p-> p.getTier()==3)
//                                    .collect(toList());
//
//        Map<Long,Integer> countMap = DataSource.allOrders.stream()
//                .collect(Collectors.groupingBy(p -> p.getOrderId(),Collectors
//                .counting()));


    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders.stream()
                .filter(p -> p.getCustomerId() == customerId)
                .sorted(Comparator.comparing(Order::getOrderId))
                .collect(toList());
    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        return DataSource.allOrderProducts.stream()
                .filter(p -> p.getOrderId() == orderId)
                .count();
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {
        //return DataSource.allOrderProducts.stream();

        return null;

    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
//        return DataSource.allOrderProducts.stream()
//                .filter(p -> p.getOrderId() == orderId)
//                .sorted(Comparator.comparing((OrderProduct::getProductId)))
//                .collect(toList());
        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    @Override
    public Product getMaxOrderedProduct() {
        Integer a= DataSource.allOrderProducts.stream()
                .collect(groupingBy(p ->p.getProductId()))
                .entrySet()
               .stream()
                .collect(toMap(e->e.getKey(), e -> e.getValue().size()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getValue();
        System.out.println(a);

//        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//        }
        return null;


    }
    @Override
    public double sumOfOrder(long orderID) {
        //To do
        return 0;
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
