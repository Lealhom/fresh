package com.hy.manager.alipay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayCore;
import com.alipay.util.AlipaySubmit;
import com.alipay.util.UtilDate;
import com.hy.manager.domain.business.Order;


public class RefundService {
	public static String refund(RefundOrderInfo refundOrderInfo,String refundBatchNo){
		//把请求参数打包成数组
				Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("service", "refund_fastpay_by_platform_pwd");//接口名称
		        sParaTemp.put("partner", AlipayConfig.partner);//合作者身份ID
		        sParaTemp.put("_input_charset", AlipayConfig.input_charset);//参数编码字符集
//		        String notify_url = "http://192.168.2.106:8080/refund_fastpay_by_platform_pwd-JAVA-UTF-8/notify_url.jsp";
//				sParaTemp.put("notify_url", notify_url);//非必填，这个相当于回调页面，在提交退款申请到支付宝后，支付宝会回调这个notify_url，返回退款的结果
				sParaTemp.put("seller_email", AlipayConfig.seller_email);//卖家支付宝账号,如果卖家Id已填，则此字段可为空。
				sParaTemp.put("refund_date", UtilDate.getDateFormatter());//退款请求的当前时间。格式为：yyyy-MM-dd hh:mm:ss。
				sParaTemp.put("batch_no", refundBatchNo);//退款批次号
				sParaTemp.put("batch_num", String.valueOf(refundOrderInfo.getOrders().size()));//退款总笔数，即参数detail_data的值中，“#”字符出现的数量加1
				
				//生成单笔数据集
				String detail_data = createDetailData(refundOrderInfo);
				sParaTemp.put("detail_data", detail_data);
				
				//除去数组中的空值和签名参数
		        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
		        //生成签名结果
		        String mysign = AlipaySubmit.buildRequestMysign(sPara);
		        //签名结果与签名方式加入请求提交参数组中
		        sPara.put("sign", mysign);
		        sPara.put("sign_type", AlipayConfig.sign_type);//签名方式
		        
				try {
//					String result = AlipaySubmit.buildRequest("", "",sParaTemp);//提交退款请求到支付宝,这里不需要上传文件，相关参数设置为空字符串
					String result = AlipaySubmit.buildRequest(sPara,"get","确认");
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	/**
	 * 根据多个退款订单，生成单笔数据集
	 * 单笔数据集格式为：第一笔交易退款数据集#第二笔交易退款数据集#第三笔交易退款数据集…#第N笔交易退款数据集；
	 * 交易退款数据集的格式为：原付款支付宝交易号^退款总金额^退款理由；
	 * @param refundOrderInfo
	 * @return
	 */
	public static String createDetailData(RefundOrderInfo refundOrderInfo){
		StringBuffer sb = new StringBuffer();
		List<Order> orders = refundOrderInfo.getOrders();
		for(Order o:orders){
			sb.append(o.getTradeNo()).append("^");
			if(o.getDiscountPrice()>0){//判断是否打折
				sb.append(o.getDiscountPrice()).append("^");
			}else{
				sb.append(o.getPrice()).append("^");
			}
			sb.append(refundOrderInfo.getReason()).append("#");
		}
		sb.deleteCharAt(sb.length()-1); //删除最后一个#号
		return sb.toString();
	}
}
