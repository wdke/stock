package com.wdke.stock.storage.dao;

import com.wdke.stock.storage.entity.WechatUser;
import com.wdke.stock.storage.entity.WechatUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WechatUserMapper {
    long countByExample(WechatUserExample example);

    int deleteByExample(WechatUserExample example);

    int deleteByPrimaryKey(String openid);

    int insert(WechatUser record);

    int insertSelective(WechatUser record);

    List<WechatUser> selectByExampleWithRowbounds(WechatUserExample example, RowBounds rowBounds);

    List<WechatUser> selectByExample(WechatUserExample example);

    WechatUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByExample(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByPrimaryKeySelective(WechatUser record);

    int updateByPrimaryKey(WechatUser record);

    Long sumByExample(WechatUserExample example);

    void batchInsert(@Param("items") List<WechatUser> items);
}