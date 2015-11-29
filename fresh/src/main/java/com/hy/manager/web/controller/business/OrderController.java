package com.hy.manager.web.controller.business;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.util.UtilDate;
import com.hy.manager.alipay.RefundOrderInfo;
import com.hy.manager.alipay.RefundService;
import com.hy.manager.domain.business.Order;
import com.hy.manager.domain.business.Sku;
import com.hy.manager.service.business.OrderService;
import com.hy.manager.service.business.SkuService;
import com.hy.manager.web.GridData;
import com.hy.manager.web.Parameter;
import com.hy.manager.web.ResponseMessage;
import com.hy.manager.web.controller.BasicController;

@Controller
@RequestMapping(value = "order")
public class OrderController extends BasicController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private SkuService skuService;

	@RequestMapping(value = "page")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("order/page");
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "paged")
	public GridData listPaged(Parameter parameter) {
		return orderService.listPaged(parameter);
	}

	/**
	 * 导出
	 * 
	 * @param ids
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "export", method = RequestMethod.GET)
	public void export(String ids, ModelMap model,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		List<Map<String, Object>> list;
		if("".equals(ids)){
			list = orderService.listByIds(null);
		}else{
			String s[] = ids.split(",");
			list = orderService.listByIds(s);
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("订单列表");
		sheet.setDefaultColumnWidth(250);
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);// 前景颜色
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 填充方式，前色填充
		String[] excelHeader = { "用户名", "昵称", "状态", "订单总价格", "订单折后价", "收货地址",
				"收件人", "联系方式", "买家留言", "买家支付宝账号", "支付宝交易号", "创建时间", "付款时间" };
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			if (i == 5 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12) {
				sheet.setColumnWidth(i, 25 * 256); // 设置列宽，25个字符宽
			} else {
				sheet.setColumnWidth(i, 15 * 256);
			}
		}
		int rowIdx = 1;
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + rowIdx);
			Map<String, Object> m = list.get(i);
			row.createCell(0).setCellValue((String) m.get("username"));
			row.createCell(1).setCellValue((String) m.get("showname"));
			Order o = new Order();
			o.setStatus(Integer.parseInt(m.get("status").toString()));
			row.createCell(2).setCellValue(o.getStatusInfo());
			row.createCell(3).setCellValue(m.get("price") + "");
			row.createCell(4).setCellValue(m.get("discountPrice") + "");
			row.createCell(5).setCellValue(m.get("address") + "");
			row.createCell(6).setCellValue(m.get("consignee") + "");
			row.createCell(7).setCellValue(m.get("phone") + "");
			row.createCell(8).setCellValue(m.get("message") + "");
			row.createCell(9).setCellValue(m.get("buyerEmail") + "");
			row.createCell(10).setCellValue(m.get("tradeNo") + "");
			row.createCell(11).setCellValue(m.get("createTime") + "");
			row.createCell(12).setCellValue(m.get("payTime") + "");
			int children = 0;
			List<Sku> skus = skuService.selectByOrderId((int) m.get("id"));
			for (int j = 0; j < skus.size() + 1; j++) {
				row = sheet.createRow(i + rowIdx + j + 1);
				if (j == 0) {
					HSSFCell cell1 = row.createCell(1);
					cell1.setCellValue("名称");
					cell1.setCellStyle(style);
					HSSFCell cell2 = row.createCell(2);
					cell2.setCellValue("原价");
					cell2.setCellStyle(style);
					HSSFCell cell3 = row.createCell(3);
					cell3.setCellValue("折扣价");
					cell3.setCellStyle(style);
					HSSFCell cell4 = row.createCell(4);
					cell4.setCellValue("规格");
					cell4.setCellStyle(style);
					HSSFCell cell5 = row.createCell(2);
					cell5.setCellValue("购买数量");
					cell5.setCellStyle(style);
				} else {
					row.createCell(1).setCellValue(skus.get(j - 1).getName());
					row.createCell(2).setCellValue(
							skus.get(j - 1).getOriginalPrice() + "");
					row.createCell(3).setCellValue(
							skus.get(j - 1).getDiscountPrice() + "");
					row.createCell(4).setCellValue(
							skus.get(j - 1).getStandard());
					row.createCell(4).setCellValue(
							skus.get(j - 1).getQuantity() + "");
				}
				children++;
			}
			rowIdx += children;
		}
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment;filename=order.xls");
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 卖家发货
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "send", method = RequestMethod.POST)
	public ResponseMessage sendGoods(@RequestParam("ids[]") int[] ids) {
		ResponseMessage message = new ResponseMessage();
		orderService.updateStatus(ids, Order.STATUS_SEND);// 已发货
		return message;
	}

	/**
	 * 卖家退款
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "refunded", method = RequestMethod.POST)
	public ResponseMessage refund(@RequestBody RefundOrderInfo r) {
		ResponseMessage message = new ResponseMessage();
		List<Order> orders = r.getOrders();
		int[] ids = new int[orders.size()];
		for (int i = 0; i < orders.size(); i++) {
			ids[i] = orders.get(i).getId();
		}
		String refundBatchNo = UtilDate.getBatchNo();// 生成退款批次号
														// 这个退款批次号应该记录到哪儿？？？
		String result = RefundService.refund(r, refundBatchNo);
		message.setData(result);
		orderService.updateStatus(ids, Order.STATUS_REFUNDED);
		return message;
	}

	@RequestMapping(value = "refunded_redirect", method = RequestMethod.GET)
	public String refund1(String form, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(form);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
