package cn.edu.cqu.letao.service;

import cn.edu.cqu.letao.entity.CmdtyDetails;
import cn.edu.cqu.letao.entity.vo.CommodityVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * CMDTY_DETAILS 服务类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
public interface ICmdtyDetailsService extends IService<CmdtyDetails> {
    List<CommodityVO> showCommodity(String cmdty_id);
}
