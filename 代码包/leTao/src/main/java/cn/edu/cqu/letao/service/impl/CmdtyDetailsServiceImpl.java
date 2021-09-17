package cn.edu.cqu.letao.service.impl;

import cn.edu.cqu.letao.entity.CmdtyDetails;
import cn.edu.cqu.letao.entity.vo.CommodityVO;
import cn.edu.cqu.letao.mapper.CmdtyDetailsMapper;
import cn.edu.cqu.letao.service.ICmdtyDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * CMDTY_DETAILS 服务实现类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@Service
public class CmdtyDetailsServiceImpl extends ServiceImpl<CmdtyDetailsMapper, CmdtyDetails> implements ICmdtyDetailsService {

    @Resource
    private CmdtyDetailsMapper cmdtyDetailsMapper;

    @Override
    public List<CommodityVO> showCommodity(String cmdty_id) {
        List<CommodityVO> list = cmdtyDetailsMapper.showCommodity(cmdty_id);
        return list;
    }
}
