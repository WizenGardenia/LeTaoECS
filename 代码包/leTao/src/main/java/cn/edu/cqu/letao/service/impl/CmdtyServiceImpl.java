package cn.edu.cqu.letao.service.impl;

import cn.edu.cqu.letao.entity.Cmdty;
import cn.edu.cqu.letao.mapper.CmdtyMapper;
import cn.edu.cqu.letao.service.ICmdtyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * CMDTY 服务实现类
 * </p>
 *
 * @author just
 * @since 2021-07-16
 */
@Service
public class CmdtyServiceImpl extends ServiceImpl<CmdtyMapper, Cmdty> implements ICmdtyService {

    @Resource
    private CmdtyMapper cmdtyMapper;

    @Override
    public List<Cmdty> findByType(String cmdty_type) {
        List<Cmdty> list = cmdtyMapper.findByType(cmdty_type);
        return list;
    }

    @Override
    public List<Cmdty>  findByName(String cmdty_name) {

        List<Cmdty> list= cmdtyMapper.findByName(cmdty_name);
        return list;
    }

    @Override
    public List<Cmdty> showAll() {
        List<Cmdty> list = cmdtyMapper.showAll();
        return list;
    }
}
