package service.impl;

import com.stylefeng.guns.rest.persistence.model.TradeOrder;
import com.stylefeng.guns.rest.persistence.dao.TradeOrderMapper;
import service.ITradeOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交易记录表 服务实现类
 * </p>
 *
 * @author codeGenerator
 * @since 2019-10-17
 */
@Service
public class TradeOrderServiceImpl extends ServiceImpl<TradeOrderMapper, TradeOrder> implements ITradeOrderService {

}
