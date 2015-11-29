package com.hy.manager.web.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hy.manager.domain.business.Coupon;
import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.SkuDTO;
import com.hy.manager.service.ScoreService;
import com.hy.manager.service.business.CouponService;
import com.hy.manager.service.business.CustomerService;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.web.ResponseMessage;

@Controller
@RequestMapping(value = "api/order")
public class ApiOrderController extends ApiBasicController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ScoreService scoreService;
	/**
	 * 点击某个订单，进入订单详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "order_detail/{orderId}", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseMessage orderDetail(@PathVariable int orderId) {
		Map<String,Object> data = orderService.orderDetail(orderId);
		ResponseMessage message = new ResponseMessage();
		message.setData(data);
		return message;
	}

	/**
	 * 添加订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage add(HttpServletRequest request, Order order, String skus,String couponId,int score) {
		
		int uid = this.getUid(request);
		order.setCustomerId(uid);
		
		String[] skuList = skus.split(":");
		SkuDTO[] dtos = new SkuDTO[skuList.length];
		for (int i = 0; i < skuList.length; i++) {
			String sku = skuList[i];
			String[] values = sku.split(",");
			SkuDTO dto = new SkuDTO();
			dto.setSkuId(values[0]);
			dto.setQuantity(Integer.valueOf(values[1]));
			dto.setUnitPrice(Double.valueOf(values[2]));
			dtos[i] = dto;
		}
		
		order.setCreateTime(new Date());// 设置订单创建时间
		// 设置订单编号
		long l = System.currentTimeMillis();
		String no = l + "" + order.getCustomerId();
		order.setNo(no);
		order.setStatus(Order.STATUS_NON_PAYMENT);// 待付款
		
		
		double price = order.getPrice();
		if(order.getDiscountPrice()>0){
			price = order.getDiscountPrice();
		}
		//减去现金券抵扣的金额
		Coupon coupon = couponService.selectById(couponId);
		if(coupon !=null){
			double d = coupon.getMoney();
			price = price - d;
		}
		//减去积分抵扣的金额
		if(score>0){
			Map<String,Object> map = scoreService.findRateByType("scoreToMoney");
			int rate = Integer.valueOf(map.get("rate").toString());
			double d = score*rate*0.1;
			price = price -d;
		}
		if(price!=order.getPrice()){
			order.setDiscountPrice(price);
		}
		
		orderService.insert(order);
		// 添加订单中的sku相关信息，包括购买的数量，购买时的价格等等
		orderService.addSkus(order.getId(), dtos);
		// 减少各个SKU的库存量
		orderService.decreaseSkusQuantity(dtos);
		ResponseMessage message = new ResponseMessage();
		message.setMessage("下单成功!");
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("orderNo", order.getNo());
		result.put("orderId", order.getId());
		result.put("orderStatus", order.getStatus());
		result.put("orderStatusInfo", order.getStatusInfo());
		
		message.setData(result);
		return message;
	}

	/**
	 * 取消订单
	 * 
	 * @return
	 */
	@RequestMapping(value = "cancel")
	@ResponseBody
	public ResponseMessage cancel(Order order) {
		order.setStatus(Order.STATUS_CANCEL);// 取消订单
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("取消订单成功!");
		return message;
	}

	/**
	 * 付款
	 * 
	 * @return
	 */
	@RequestMapping(value = "pay")
	@ResponseBody
	public ResponseMessage pay(Order order) {
		order.setPayTime(new Date());// 设置订单付款时间
		order.setStatus(Order.STATUS_PAYMENT);// 已付款
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("付款成功!");
		return message;
	}

	/**
	 * 收货
	 * 
	 * @return
	 */
	@RequestMapping(value = "receive")
	@ResponseBody
	public ResponseMessage receive(Order order) {
		order.setStatus(Order.STATUS_RECEIVE);// 已收货
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("收货成功!");
		return message;
	}

	/**
	 * 买家申请退货
	 * 
	 * @return
	 */
	@RequestMapping(value = "refunding")
	@ResponseBody
	public ResponseMessage refunding(Order order) {
		order.setStatus(Order.STATUS_REFUNDING);// 已收货
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("申请退货!");
		return message;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "del")
	@ResponseBody
	public ResponseMessage del(Order order) {
		order.setStatus(Order.STATUS_DEL);
		orderService.update(order);
		ResponseMessage message = new ResponseMessage();
		message.setData("删除成功!");
		return message;
	}

}
