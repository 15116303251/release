package com.king.dubbo.weixin.bo;

import com.king.dubbo.entities.model.wx.WxReplyTemplateInfo;
import com.king.dubbo.entities.model.wx.WxTemplateInfo;

public interface IWxTemplateBo extends IAbstractBo {

    /**
     * @description 根据模板key获取对应的模板
     * @param temKey 模板key
     * @return
     */
    public WxTemplateInfo getTemplateInfoByTemKey(String temKey);

    /**
     * @description 根据id查询模板的key值
     * @param id
     * @return
     */
    public WxReplyTemplateInfo getWxTemplateInfoById(Integer id);
}
