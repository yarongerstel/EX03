

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
                .filter(c->getCustomerOrders(c.getId()).size()>10)
                .sorted(Comparator.comparing(Customer::getId))
               .collect(toList());


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

              List<Long> products=  DataSource.allOrderProducts.stream()
                .collect(groupingBy(p ->p.getProductId()))
                .entrySet()
                .stream()
                .collect(toMap(e->e.getKey(), e -> e.getValue().size()))
                .entrySet()
                .stream()
                .filter(e-> e.getValue() >=orderedtimes)
                .map(e -> e.getKey())
                 .collect(toList());
        return DataSource.allProducts.stream()
                .filter(p->products.contains(p.getProductId()))
                .collect(toList());

    }

    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        List<Long> products= DataSource.allOrderProducts.stream()
                .filter(p -> p.getOrderId() == orderId)
                .sorted(Comparator.comparing((OrderProduct::getProductId)))
                .map(p->p.getProductId())
                .collect(toList());
        return DataSource.allProducts.stream()
                .filter(p->products.contains(p.getProductId()))
                .sorted(Comparator.comparing(Product::getProductId))
                .collect(toList());
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        List<Long> orders= DataSource.allOrderProducts.stream()
                .filter(p -> p.getProductId() == productId)
                .map(p->p.getOrderId())
                .collect(toList());
        List<Long>customerId = DataSource.allOrders.stream()
                .filter(p->orders.contains(p.getOrderId()))
                .map(o->o.getCustomerId())
                .collect(toList());
        return  DataSource.allCustomers.stream()
                .filter(p->customerId.contains(p.getId()))
                .sorted(Comparator.comparing(Customer::getId))
                .collect(toList());

    }

    @Override
    public Product getMaxOrderedProduct() {
        Long productId= DataSource.allOrderProducts.stream()
                .collect(groupingBy(p ->p.getProductId()))
                .entrySet()
               .stream()
                .collect(toMap(e->e.getKey(), e -> e.getValue().size()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
        return DataSource.allProducts.stream()
                .filter(p->p.getProductId() == productId)
                .findFirst().orElse(null);



    }
    @Override
    public double sumOfOrder(long orderID) {
        Map<Long,Integer> products = DataSource.allOrderProducts.stream()
                .filter(p->p.getOrderId() ==orderID)
                .collect(groupingBy(p ->p.getProductId()))
                .entrySet()
                .stream()
                .collect(toMap(e->e.getKey(), e -> e.getValue().get(0).getQuantity()));
        return DataSource.allProducts.stream()
                .filter(p->products.keySet().contains(p.getProductId()))
                .mapToDouble(p->p.getPrice()*products.get(p.getProductId()))
                .sum();

    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
       return DataSource.allOrders.stream()
                .filter(p->sumOfOrder(p.getOrderId())>price)
                .sorted(Comparator.comparing(Order::getOrderId))
                .collect(toList());

    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        int maxi =DataSource.allCustomers.stream()
                .filter(p->p.getTier() ==3)
                .collect(toMap(e->e.getId(),e->getCustomerOrders(e.getId()).size()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getValue();

        return DataSource.allCustomers.stream()
                .filter(p->p.getTier() ==3)
                .collect(toMap(identity(),e->getCustomerOrders(e.getId()).size()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==maxi)
                .map(e->e.getKey())
                .sorted(Comparator.comparing(Customer::getId))
                .collect(toList());


    }

}
