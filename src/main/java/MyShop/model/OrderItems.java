package MyShop.model;

import MyShop.entity.OrderItem;
import MyShop.entity.Orders;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OrderItems {
    private Orders order;

    private List<OrderItem> orderItemList;

    public OrderItems(Orders order, List<OrderItem> orderItemList) {
        this.order = order;
        this.orderItemList = orderItemList;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Orders getOrder() {
        return order;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public String describeItems(){
        StringBuilder desc = new StringBuilder();
         BigDecimal totalcost = new BigDecimal(0.0);
        for (OrderItem orderItem: this.orderItemList) {
            desc.append("ID Product: " + orderItem.getId() +"<br>");
            desc.append("Name Product: " + orderItem.getProduct().getName() + "<br>");
            desc.append(" $ " +orderItem.getProduct().getPrice() + "<br>");
                    desc.append("Count : "+ orderItem.getCount() + "<br>");
            for (int i = 0; i < orderItem.getCount(); i++) {
                desc.append("<img src=\""  +orderItem.getProduct().getImage_link() + "\" width=\"95\" height=\"95\" alt=\"#\">");
            }
            desc.append("<br>");
            totalcost =totalcost.add(new BigDecimal(orderItem.getProduct().getPrice() * orderItem.getCount()));
        }
        desc.append("<h4> Total cost: $ " + new BigDecimal(totalcost.doubleValue()).
                setScale(2, RoundingMode.HALF_UP).doubleValue()+ "</h4>" ) ;
        return desc.toString();
    }
    public String describeItemsForEmail(OrderItems orderItems, ImageHtmlEmail imageHtmlEmail) throws EmailException {
        StringBuilder desc = new StringBuilder();
        BigDecimal totalcost = new BigDecimal(0.0);
        desc.append("<h4>  ID Order : " +orderItems.getOrder().getId() +"</h4>  <br>");
        for (OrderItem orderItem: this.orderItemList) {
            desc.append("ID Product: " + orderItem.getId() +"<br>");
            desc.append("Name Product: " + orderItem.getProduct().getName() + "<br>");
            desc.append(" $ " +orderItem.getProduct().getPrice() + "<br>");

                String cid = imageHtmlEmail.embed(new File("/Users/mr/IdeaProjects/MyShop/src/main/webapp"+orderItem.getProduct().getImage_link()));
                for (int i = 0; i < orderItem.getCount(); i++) {
                    desc.append("<img src= \"cid:" + cid + "\" width=\"90\" height=\"90\"  >");
                }

            desc.append("Count : "+ orderItem.getCount() + "<br>");
            desc.append("<br>");
            totalcost =totalcost.add(new BigDecimal(orderItem.getProduct().getPrice() * orderItem.getCount()));
        }

        desc.append(" <p class=\"callout\">\n" +
                " Total cost: $  "+ new BigDecimal(totalcost.doubleValue()).setScale(2, RoundingMode.HALF_UP).doubleValue()+
                "</p>") ;

        return desc.toString();
    }

}
