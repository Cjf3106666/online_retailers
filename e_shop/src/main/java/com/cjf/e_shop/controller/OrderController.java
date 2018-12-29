package com.cjf.e_shop.controller;

import com.cjf.modelapi.model.Orders;
import com.cjf.modelapi.service.ShowOrdersService;
import com.cjf.modelapi.service.TakeOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {
    //  private static final String Rest_Url_Prefix ="http://localhost:8001";
    private static final String Rest_Url_Prefix_take = "http://TAKE-ORDERS";
    private static final String Rest_Url_Prefix_show = "http://SHOW-ORDERS";
    static OrderController controller=new OrderController();

    private OrderController() {
    }
    static public OrderController getController(){
        return controller;
    }
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    TakeOrdersService takeOrdersService;
    @Autowired
    ShowOrdersService showOrdersService;

    /*
        @RequestMapping(value = "/consumer/order/add")
        public int add(Orders orders){
        return restTemplate.postForObject(Rest_Url_Prefix_take+"/order/add",orders,int.class);
        }
    */
    /*
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable int id){
        return restTemplate.getForObject(Rest_Url_Prefix+"/dept/get/"+id,Dept.class);
    }
    */
    /*
    @RequestMapping(value = "/consumer/order/list")
    public List<Orders> getAll(){
        return restTemplate.getForObject(Rest_Url_Prefix_show+"/order/getAll",List.class);
    }
*/

    @RequestMapping(value = "/consumer/order/add")
    public int add(Orders orders) {

        return takeOrdersService.addOrder(orders);
    }

    @RequestMapping(value = "/consumer/order/list")
    public List<Orders> getAll() {
        return showOrdersService.showAllOrders();
    }
}
