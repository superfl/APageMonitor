/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.component;

import cn.superfl.apagemonitor.dal.dao.APMLogonApp;
import cn.superfl.apagemonitor.dal.dao.APMUser;
import cn.superfl.apagemonitor.dal.mapper.APMLogonAppMapper;
import cn.superfl.apagemonitor.dal.mapper.APMUserMapper;
import cn.superfl.apagemonitor.model.APMException;
import cn.superfl.apagemonitor.model.enums.EnableStatusEnum;
import cn.superfl.apagemonitor.model.enums.ResultEnum;
import cn.superfl.apagemonitor.model.user.LogonApp;
import cn.superfl.apagemonitor.model.user.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author superfl
 * @version $Id: UserComponentImpl.java, v 0.1 2017-03-16 下午2:04 superfl Exp $$
 */
@Service
public class UserComponentImpl implements UserComponent{

    /** uid日期格式化 **/
    public static final SimpleDateFormat UID_DATE_FORMAT = new SimpleDateFormat("yyMMdd");

    /** userIdSeqName */
    private static final String UID_SEQ_NAME = "userIdSeq";

    @Autowired
    private SequenceComponent sequenceComponent;

    @Autowired
    private APMUserMapper apmUserMapper;

    @Autowired
    private APMLogonAppMapper apmLogonAppMapper;

    /**
     * 生成UserId,共22位数字
     * 格式: 5233+六位时间戳倒置+10位seq前4位倒置+用户分类位+10位seq后6位+校验位
     *
     * @return
     */
    @Override
    public String genUserId(int userType) {
        // 准备数据
        String dataStr = UID_DATE_FORMAT.format(new Date());
        long uidSeq = sequenceComponent.getSequence(UID_SEQ_NAME);
        String uidSeqStr = StringUtils.leftPad(String.valueOf(uidSeq), 10, "0");

        // 生成uid
        StringBuilder uidBuilder = new StringBuilder();
        // 5233
        uidBuilder.append("5233");
        // 六位时间戳倒置
        uidBuilder.append(StringUtils.reverse(dataStr));
        // 10位seq前4位倒置
        uidBuilder.append(StringUtils.reverse(StringUtils.left(uidSeqStr, 4)));
        // 用户分类位
        uidBuilder.append(String.valueOf(userType));
        // 10位seq后6位
        uidBuilder.append(StringUtils.right(uidSeqStr, 6));
        // 校验位
        uidBuilder.append(String.valueOf(computeChecksum(uidBuilder.toString())));

        // 返回结果
        return uidBuilder.toString();
    }

    /**
     * 创建用户
     *
     * @param logonApp
     * @param logonType
     * @param password
     * @return
     */
    @Override
    public UserInfo createUser(String userId, String logonApp, String logonType, String password) {
        // 新建用户
        APMUser apmUser = new APMUser();
        apmUser.setUserid(userId);
        apmUser.setPassword(password);
        apmUser.setEnablestatus(EnableStatusEnum.NORMAL.getStatusCode());
        apmUser.setCreatedate(new Date());
        int insertRes = apmUserMapper.insert(apmUser);
        if (insertRes != 1){
            throw new APMException(ResultEnum.UPDATE_DB_ERROR.getCode(), "注册插入APMUser表错误,res:"+insertRes);
        }

        // 新建登录号
        APMLogonApp apmLogonApp = new APMLogonApp();
        apmLogonApp.setLogonapp(logonApp);
        apmLogonApp.setLogontype(logonType);
        apmLogonApp.setUserid(apmUser.getUserid());
        apmLogonApp.setEnablestatus(EnableStatusEnum.NORMAL.getStatusCode());
        apmLogonApp.setCreatedate(new Date());
        insertRes = apmLogonAppMapper.insert(apmLogonApp);
        if (insertRes != 1){
            throw new APMException(ResultEnum.UPDATE_DB_ERROR.getCode(), "注册插入APMLogonApp表错误,res:"+insertRes);
        }

        // 组装返回对象
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(apmUser.getUserid());
        userInfo.setEnablestatus(apmUser.getEnablestatus());
        userInfo.setPassword(apmUser.getPassword());
        userInfo.setCreatedate(apmUser.getCreatedate());

        LogonApp logonAppModel = new LogonApp();
        logonAppModel.setLogonapp(apmLogonApp.getLogonapp());
        logonAppModel.setLogontype(apmLogonApp.getLogontype());
        logonAppModel.setEnablestatus(apmLogonApp.getEnablestatus());
        logonAppModel.setCreatedate(apmLogonApp.getCreatedate());

        userInfo.getLogonAppList().add(logonAppModel);
        return userInfo;
    }

    /**
     * 计算校验码。
     *
     * <p>
     * 校验码规则: 1-15位做异或，并用10取模。
     *
     * @param string
     * @return
     */
    private int computeChecksum(String string) {
        // 计算校验码
        int checksum = 0;

        // 计算校验和
        for (int i = 0; i < string.length(); i++) {
            checksum ^= (string.charAt(i) - '0');
        }

        return checksum % 10;
    }

    /**
     * Setter method for property apmLogonAppMapper.
     *
     * @param apmLogonAppMapper value to be assigned to property apmLogonAppMapper
     */
    public void setApmLogonAppMapper(APMLogonAppMapper apmLogonAppMapper) {
        this.apmLogonAppMapper = apmLogonAppMapper;
    }

    /**
     * Setter method for property apmUserMapper.
     *
     * @param apmUserMapper value to be assigned to property apmUserMapper
     */
    public void setApmUserMapper(APMUserMapper apmUserMapper) {
        this.apmUserMapper = apmUserMapper;
    }

    /**
     * Setter method for property sequenceComponent.
     *
     * @param sequenceComponent value to be assigned to property sequenceComponent
     */
    public void setSequenceComponent(SequenceComponent sequenceComponent) {
        this.sequenceComponent = sequenceComponent;
    }


}