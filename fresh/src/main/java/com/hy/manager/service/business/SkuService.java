package com.hy.manager.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.manager.domain.AbstractMapper;
import com.hy.manager.domain.business.Sku;
import com.hy.manager.domain.business.SkuMapper;
import com.hy.manager.service.AbstractService;

@Service
public class SkuService extends AbstractService<Sku> {

	@Autowired
	private SkuMapper skuMapper;

	public SkuService() {
		super(Sku.class);
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return skuMapper;
	}

	public List<Sku> selectByOrderId(int orderId) {
		return this.skuMapper.selectByOrderId(orderId);
	}

	/**
	 * 更新sku的评分
	 */
	public void updateSkuScore() {
		this.skuMapper.updateSkuScore();
	}
	/**
	 * 更新sku的好评数、中评数，差评数
	 * @param score
	 */
	public void updateSkuComment(int skuId,int score) {
		this.skuMapper.updateSkuComment(skuId,score);
	}
	public void addViceImgUuid(int skuId, String viceImgUuid, int orderNum) {
		this.skuMapper.addViceImgUuid(Integer.toString(skuId),
				viceImgUuid, orderNum);
	}
	public void addViceImgUuids(int skuId, List<String> viceImgUuids) {
		for (int i = 0; i < viceImgUuids.size(); i++) {
			this.addViceImgUuid(skuId, viceImgUuids.get(i), (i + 1));
		}
	}
	public void delViceImgUuids(int skuId) {
		this.skuMapper.delViceImgUuids(skuId);
	}
	
	public List<String> findViceImgs(int productId) {
		return this.skuMapper.findViceImgs(productId);
	}
}
