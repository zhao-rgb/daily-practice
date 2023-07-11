package com.zxl.dailypractice.card.three.july.july7;

import java.io.Serializable;
import java.util.Date;

public class ThirdUserPO implements Serializable {
    private String pkUserId;

    /**
     * 第三方用户id
     */
    private String thirdUserId;

    /**
     * 用户类型 00：微信 ，01：支付宝
     */
    private String thirdType;

    /**
     * 微信与支付宝关联后的联合ID
     */
    private String unionId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 手机号
     */

    private String phoneNumber;

    /**
     * 首次注册渠道 00：H5微站点 01：第三方 02：众畅公众号
     */

    private String registrationChannel;

    /**
     * 注册时间
     */
    private Date registrationTime;

    /**
     * 注销时间
     */
    private Date logoutTime;

    /**
     * 用户状态 00：已注销 01：正常
     */
    private String status;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否已经逻辑删除（0：未删除1：已删除）
     */
    private Integer deleted;

    /**
     * 数据版本
     */
    private Integer version;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 首次充值时间
     */
    private Date firstRechargeTime;

    /**
     * 累计充值金额
     */
    private Integer totalRechargeAmount;

    /**
     * 累计赠金
     */
    private Integer totalGiftAmount;

    /**
     * 钱包余额
     */
    private Integer walletBalance;

    /**
     * 冻结金额
     */
    private Integer frozenAmount;

    /**
     * 累计退款
     */
    private Integer totalRefund;

    private static final long serialVersionUID = 1L;

    public ThirdUserPO(String pkUserId, String thirdUserId, String thirdType, String unionId, String name, String nickName, String phoneNumber, String registrationChannel, Date registrationTime, String status, String tenantId, Date logoutTime, Date createTime, Date updateTime, Integer deleted, Integer version, String createBy, String updateBy) {
        this.pkUserId = pkUserId;
        this.thirdUserId = thirdUserId;
        this.thirdType = thirdType;
        this.unionId = unionId;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.registrationChannel = registrationChannel;
        this.registrationTime = registrationTime;
        this.logoutTime = logoutTime;
        this.status = status;
        this.tenantId = tenantId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.version = version;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public ThirdUserPO() {
        super();
    }

    /**
     * @return pk_user_id
     */
    public String getPkUserId() {
        return pkUserId;
    }

    /**
     * @param pkUserId
     */
    public void setPkUserId(String pkUserId) {
        this.pkUserId = pkUserId == null ? null : pkUserId.trim();
    }

    /**
     * 获取第三方用户id
     *
     * @return third_user_id - 第三方用户id
     */
    public String getThirdUserId() {
        return thirdUserId;
    }

    /**
     * 设置第三方用户id
     *
     * @param thirdUserId 第三方用户id
     */
    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId == null ? null : thirdUserId.trim();
    }

    /**
     * 获取用户类型 00：微信 ，01：支付宝
     *
     * @return third_type - 用户类型 00：微信 ，01：支付宝
     */
    public String getThirdType() {
        return thirdType;
    }

    /**
     * 设置用户类型 00：微信 ，01：支付宝
     *
     * @param thirdType 用户类型 00：微信 ，01：支付宝
     */
    public void setThirdType(String thirdType) {
        this.thirdType = thirdType == null ? null : thirdType.trim();
    }

    /**
     * 获取微信与支付宝关联后的联合ID
     *
     * @return union_id - 微信与支付宝关联后的联合ID
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置微信与支付宝关联后的联合ID
     *
     * @param unionId 微信与支付宝关联后的联合ID
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取首次注册渠道 00：H5微站点 01：第三方 02：众畅公众号
     *
     * @return registration_channel - 首次注册渠道 00：H5微站点 01：第三方 02：众畅公众号
     */
    public String getRegistrationChannel() {
        return registrationChannel;
    }

    /**
     * 设置首次注册渠道 00：H5微站点 01：第三方 02：众畅公众号 03：微信小程序 04：支付宝小程序 05：APP-IOS 06：APP-Android 07：其它
     *
     * @param registrationChannel 首次注册渠道 00：H5微站点 01：第三方 02：众畅公众号 03：微信小程序 04：支付宝小程序 05：APP-IOS 06：APP-Android 07：其它
     */
    public void setRegistrationChannel(String registrationChannel) {
        this.registrationChannel = registrationChannel == null ? null : registrationChannel.trim();
    }

    /**
     * 获取注册时间
     *
     * @return registration_time - 注册时间
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /**
     * 设置注册时间
     *
     * @param registrationTime 注册时间
     */
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * 获取注销时间
     *
     * @return logout_time - 注销时间
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 设置注销时间
     *
     * @param logoutTime 注销时间
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 获取用户状态 00：已注销 01：正常
     *
     * @return status - 用户状态 00：已注销 01：正常
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置用户状态 00：已注销 01：正常
     *
     * @param status 用户状态 00：已注销 01：正常
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取租户ID
     *
     * @return tenant_id - 租户ID
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 设置租户ID
     *
     * @param tenantId 租户ID
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否已经逻辑删除（0：未删除1：已删除）
     *
     * @return deleted - 是否已经逻辑删除（0：未删除1：已删除）
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否已经逻辑删除（0：未删除1：已删除）
     *
     * @param deleted 是否已经逻辑删除（0：未删除1：已删除）
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取数据版本
     *
     * @return version - 数据版本
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置数据版本
     *
     * @param version 数据版本
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getFirstRechargeTime() {
        return firstRechargeTime;
    }

    public void setFirstRechargeTime(Date firstRechargeTime) {
        this.firstRechargeTime = firstRechargeTime;
    }

    public Integer getTotalRechargeAmount() {
        return totalRechargeAmount;
    }

    public void setTotalRechargeAmount(Integer totalRechargeAmount) {
        this.totalRechargeAmount = totalRechargeAmount;
    }

    public Integer getTotalGiftAmount() {
        return totalGiftAmount;
    }

    public void setTotalGiftAmount(Integer totalGiftAmount) {
        this.totalGiftAmount = totalGiftAmount;
    }

    public Integer getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Integer walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Integer getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Integer frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Integer getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Integer totalRefund) {
        this.totalRefund = totalRefund;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ThirdUserPO other = (ThirdUserPO) that;
        return (this.getPkUserId() == null ? other.getPkUserId() == null : this.getPkUserId().equals(other.getPkUserId()))
            && (this.getThirdUserId() == null ? other.getThirdUserId() == null : this.getThirdUserId().equals(other.getThirdUserId()))
            && (this.getThirdType() == null ? other.getThirdType() == null : this.getThirdType().equals(other.getThirdType()))
            && (this.getUnionId() == null ? other.getUnionId() == null : this.getUnionId().equals(other.getUnionId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getRegistrationChannel() == null ? other.getRegistrationChannel() == null : this.getRegistrationChannel().equals(other.getRegistrationChannel()))
            && (this.getRegistrationTime() == null ? other.getRegistrationTime() == null : this.getRegistrationTime().equals(other.getRegistrationTime()))
            && (this.getLogoutTime() == null ? other.getLogoutTime() == null : this.getLogoutTime().equals(other.getLogoutTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))

            && (this.getFirstRechargeTime() == null ? other.getFirstRechargeTime() == null : this.getFirstRechargeTime().equals(other.getFirstRechargeTime()))
            && (this.getTotalRechargeAmount() == null ? other.getTotalRechargeAmount() == null : this.getTotalRechargeAmount().equals(other.getTotalRechargeAmount()))
            && (this.getTotalGiftAmount() == null ? other.getTotalGiftAmount() == null : this.getTotalGiftAmount().equals(other.getTotalGiftAmount()))
            && (this.getWalletBalance() == null ? other.getWalletBalance() == null : this.getWalletBalance().equals(other.getWalletBalance()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getTotalRefund() == null ? other.getTotalRefund() == null : this.getTotalRefund().equals(other.getTotalRefund()))

            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkUserId() == null) ? 0 : getPkUserId().hashCode());
        result = prime * result + ((getThirdUserId() == null) ? 0 : getThirdUserId().hashCode());
        result = prime * result + ((getThirdType() == null) ? 0 : getThirdType().hashCode());
        result = prime * result + ((getUnionId() == null) ? 0 : getUnionId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getRegistrationChannel() == null) ? 0 : getRegistrationChannel().hashCode());
        result = prime * result + ((getRegistrationTime() == null) ? 0 : getRegistrationTime().hashCode());
        result = prime * result + ((getLogoutTime() == null) ? 0 : getLogoutTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getFirstRechargeTime() == null) ? 0 : getFirstRechargeTime().hashCode());
        result = prime * result + ((getTotalRechargeAmount() == null) ? 0 : getTotalRechargeAmount().hashCode());
        result = prime * result + ((getTotalGiftAmount() == null) ? 0 : getTotalGiftAmount().hashCode());
        result = prime * result + ((getWalletBalance() == null) ? 0 : getWalletBalance().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getTotalRefund() == null) ? 0 : getTotalRefund().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkUserId=").append(pkUserId);
        sb.append(", thirdUserId=").append(thirdUserId);
        sb.append(", thirdType=").append(thirdType);
        sb.append(", unionId=").append(unionId);
        sb.append(", name=").append(name);
        sb.append(", nickName=").append(nickName);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", registrationChannel=").append(registrationChannel);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append(", logoutTime=").append(logoutTime);
        sb.append(", status=").append(status);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", version=").append(version);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", firstRechargeTime=").append(firstRechargeTime);
        sb.append(", totalRechargeAmount=").append(totalRechargeAmount);
        sb.append(", totalGiftAmount=").append(totalGiftAmount);
        sb.append(", walletBalance=").append(walletBalance);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", totalRefund=").append(totalRefund);
        sb.append(", serialVersionUID=").append(serialVersionUID);

        sb.append("]");
        return sb.toString();
    }
}
