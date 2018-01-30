package com.mc.family.service;

import com.mc.family.config.ConstantComm;
import com.mc.family.mapper.DataInfoMapper;
import com.mc.family.model.DataInfo;
import com.mc.family.vo.SelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description 公共相关原子服务实现
 * @create 2018/01/26 16:22
 * @since v0.4
 */
@Service
public class PublishService {
    @Autowired
    private DataInfoMapper dataInfoMapper;

    /**
     * @description 根据code查询下拉框数据
     * @param code 条件code
     * @return SelectVo 下拉框结果
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/30 18:08
     **/
    public SelectVo querySelectorDatasByParentCode(String code) throws Exception {
        List<DataInfo> dataInfos = dataInfoMapper.selectDatasByParentCode(code);
        List<Map<String, String>> selects = new ArrayList<>();
        for (DataInfo dataInfo : dataInfos) {
            Map<String, String> select = new HashMap<>();
            select.put(ConstantComm.STRING_KEY, dataInfo.getDataCode());
            select.put(ConstantComm.STRING_VALUE, dataInfo.getDataName());
            selects.add(select);
        }
        SelectVo selectVo = new SelectVo();
        selectVo.setSelects(selects);
        return selectVo;
    }
}
