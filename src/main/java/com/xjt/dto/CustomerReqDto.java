package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameCustomerReqDto
 * @Description
 * @Author
 * @Date2019/11/6 9:45
 * @Version V1.0
 **/
@ApiModel
public class CustomerReqDto extends BaseReqDto {

    /**
     * 渠道编号
     */
    @ApiModelProperty("渠道编号")
    private String customerId;

    /**
     * 渠道简称
     */
    @ApiModelProperty("渠道简称")
    private String abbrev;

    /**
     * 渠道名称
     */
    @ApiModelProperty("渠道名称")
    private String customerNa;

    /**
     * 开业时间
     */
    private Date practisedate;
    @ApiModelProperty("开业时间")
    private String practisedatestr;

    /**
     * 停业时间
     */
    private Date shutoutdate;
    @ApiModelProperty("停业时间")
    private String shutoutdatestr;

    /**
     * 法人
     */
    @ApiModelProperty("法人")
    private String fictitiousperson;

    /**
     * 社会信用代码(税号)
     */
    @ApiModelProperty("社会信用代码(税号)")
    private String taxnumber;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String keyman;

    /**
     * 手机
     */
    @ApiModelProperty("手机")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 传真
     */
    @ApiModelProperty("传真")
    private String fax;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String tel1;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String tel2;

    /**
     * 组
     */
    @ApiModelProperty("组")
    private String cgroup;

    /**
     * 公司ID
     */
    private String companyId;
    @ApiModelProperty("公司id")
    private String companyid;

    /**
     * 机构组织ID
     */
    @ApiModelProperty("组织机构id")
    private String organizationid;

    /**
     * 国
     */
    @ApiModelProperty("国")
    private String country;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String region;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 邮编
     */
    @ApiModelProperty("邮编")
    private String zipcode;

    /**
     * 经营方式(1自营2加盟3代理4批发)
     */
    @ApiModelProperty("经营方式(1自营2加盟3代理4批发)")
    private String mathod;

    /**
     * 经营模式
     */
    @ApiModelProperty("经营模式")
    private String dealinpattern;

    /**
     * 评级
     */
    @ApiModelProperty("评级")
    private Short clevel;

    /**
     * 渠道类别
     */
    @ApiModelProperty("渠道类别")
    private String sort;

    /**
     * 业务员
     */
    private String saleman;
    @ApiModelProperty("业务员")
    private Object salemans;

    private String propertylevel;

    /**
     * 销售目标
     */
    @ApiModelProperty("销售目标")
    private BigDecimal saletarget;

    /**
     * 经营费用
     */
    @ApiModelProperty("经营费用")
    private BigDecimal fee;

    /**
     * 营业面积
     */
    @ApiModelProperty("营业面积")
    private BigDecimal carea;

    /**
     * 保证金
     */
    @ApiModelProperty("保证金")
    private BigDecimal deposit;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 信用额度
     */
    @ApiModelProperty("信用额度")
    private Long credit;

    /**
     * 上级渠道
     */
    @ApiModelProperty("上级渠道")
    private String parentchannelid;

    /**
     * 应收归集户口
     */
    @ApiModelProperty("应收归集户口")
    private String accountcustomerId;

    /**
     * 应收户口
     */
    @ApiModelProperty("应收户口")
    private Integer accountcustomerflag;

    /**
     * 零售价类型
     */
    @ApiModelProperty("零售价类型")
    private String dppricetype;

    /**
     * 结算价类型
     */
    @ApiModelProperty("结算价类型")
    private String balancepricetype;

    /**
     * 结算价是否从货品档案取
     */
    @ApiModelProperty("结算价是否从货品档案获取")
    private Integer balancepricegetfromgoods;

    /**
     * 折扣
     */
    @ApiModelProperty("折扣")
    private BigDecimal fdiscount;

    /**
     * 商场扣点
     */
    @ApiModelProperty("商场扣点")
    private BigDecimal marketplacediscount;

    /**
     * 换货率
     */
    @ApiModelProperty("换货率")
    private BigDecimal qiexchangerate;

    /**
     * 换货周期
     */
    @ApiModelProperty("换货周期")
    private Integer qiexchangecyc;

    private BigDecimal exchangerate;

    private Integer exchangecyc;

    private BigDecimal exchangefirst;

    /**
     * VIP卡顺序(0先卡后促销1先促销后卡)
     */
    @ApiModelProperty("VIP卡顺序")
    private Integer spromobeforevip;

    /**
     * 配货周期天数
     */
    @ApiModelProperty("配货周期天数")
    private Integer sortcycdays;

    private BigDecimal nospromoscale;

    /**
     * 暂无
     */
    private String vipusegroup;

    /**
     * 暂无
     */
    private String stockquerygroup;

    /**
     * 暂无
     */
    private String businessmangroup;

    /**
     * 是否停用
     */
    @ApiModelProperty("是否停用")
    private Integer shutout;

    /**
     * 建立日期
     */
    @ApiModelProperty("建立日期")
    private Date inputDate;

    /**
     * 更新日期
     */
    @ApiModelProperty("更新日期")
    private Date updatetimestamp;

    /**
     * 允许负库存
     */
    @ApiModelProperty("是否允许负库存")
    private Integer allowminusstock;

    /**
     * 暂无
     */
    private String shopsId;

    /**
     * 暂无
     */
    private String item;

    /**
     * 暂无
     */
    private Integer flag;

    /**
     * 暂无
     */
    private String warehouseNo;

    /**
     * 暂无
     */
    private Integer calulate;

    /**
     * 暂无
     */
    private String formulaid;

    /**
     * 暂无
     */
    private Integer overcrdt;

    /**
     * 暂无
     */
    private Integer ischeckbalancemode;

    /**
     * 暂无
     */
    private Integer printpossmallbill;

    /**
     * 暂无
     */
    private String repofficeId;

    /**
     * 暂无
     */
    private Integer isautobuildbill;

    /**
     * 暂无
     */
    private Integer companypriceflag;

    /**
     * 暂无
     */
    private String accountcompanyId;

    /**
     * 暂无
     */
    private Integer isemporium;

    /**
     * 暂无
     */
    private Integer notintegral;

    /**
     * 暂无
     */
    private Integer notdiscount;

    /**
     * 暂无
     */
    private Integer notsendmobilemsg;

    /**
     * 暂无
     */
    private Integer tag;

    /**
     * 暂无
     */
    private String customergroup;

    /**
     * 暂无
     */
    private Integer isquotamanage;

    /**
     * 暂无
     */
    private Integer checkminusstockwhenposdaybalance;

    /**
     * 暂无
     */
    private Integer isuseunitprice;

    /**
     * 暂无
     */
    private Integer ismall;

    /**
     * 暂无
     */
    private Integer multiselectrenotice;

    /**
     * 暂无
     */
    private Integer multiselectshopapplyout;

    /**
     * 暂无
     */
    private BigDecimal usearea;

    /**
     * 暂无
     */
    private BigDecimal shoptoparea;

    /**
     * 暂无
     */
    private BigDecimal shopafterarea;

    /**
     * 暂无
     */
    private BigDecimal contractarea;

    /**
     * 暂无
     */
    private BigDecimal shoplocation1;

    /**
     * 暂无
     */
    private BigDecimal shoplocation2;

    /**
     * 暂无
     */
    private Integer standardstockqt;

    /**
     * 暂无
     */
    private BigDecimal standardarearate;

    /**
     * 暂无
     */
    private Date contractbegindate;

    /**
     * 暂无
     */
    private Date contractenddate;

    /**
     * 暂无
     */
    private BigDecimal securityamount;

    /**
     * 暂无
     */
    private String controlman;

    /**
     * 暂无
     */
    private String shopstaffing;

    /**
     * 暂无
     */
    private Integer billingcycle;

    /**
     * 暂无
     */
    private String division;

    /**
     * 暂无
     */
    private String divisionlevel;

    /**
     * 暂无
     */
    private String ownbrand;

    /**
     * 是否单独核算成本
     */
    @ApiModelProperty("是否单独核算成本")
    private Integer iscalccost;

    /**
     * 暂无
     */
    private String insurance;

    /**
     * 暂无
     */
    private String giftcardusegroup;

    /**
     * 暂无
     */
    private String linkman;

    /**
     * 暂无
     */
    private String vipstoredgroup;

    /**
     * 经营企业许可、备案编号（自动生成）
     */
    @ApiModelProperty("经营企业许可，备案编号")
    private String brid;
    //渠道品牌
    @ApiModelProperty("渠道品牌")
    private Object brands;
    private List<String> brandNames;
    //渠道开户行
    @ApiModelProperty("渠道开户行")
    private String accountId;
    //渠道组
    @ApiModelProperty("渠道组")
    private String customerGroup;

    private Integer deleteFlag;
    /**
     * 开户行
     */
    @ApiModelProperty("开户行")
    private String bank;

    /**
     * 开户行地址
     */
    @ApiModelProperty("开户行地址")
    private String bankaddr;

    /**
     * 户名
     */
    @ApiModelProperty("户名")
    private String accountsName;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String accounts;

    /**
     * 行号
     */
    @ApiModelProperty("行号")
    private String banknumber;

    /**
     * 开户电话
     */
    @ApiModelProperty("开户电话")
    private String tel;

    /**
     * 银行电话
     */
    @ApiModelProperty("银行电话")
    private String banktel;

    @ApiModelProperty("开户行备注")
    private String cmemo;

    private String parentChannelId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getCustomerNa() {
        return customerNa;
    }

    public void setCustomerNa(String customerNa) {
        this.customerNa = customerNa;
    }

    public Date getPractisedate() {
        return practisedate;
    }

    public void setPractisedate(Date practisedate) {
        this.practisedate = practisedate;
    }

    public Date getShutoutdate() {
        return shutoutdate;
    }

    public void setShutoutdate(Date shutoutdate) {
        this.shutoutdate = shutoutdate;
    }

    public String getFictitiousperson() {
        return fictitiousperson;
    }

    public void setFictitiousperson(String fictitiousperson) {
        this.fictitiousperson = fictitiousperson;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getCgroup() {
        return cgroup;
    }

    public void setCgroup(String cgroup) {
        this.cgroup = cgroup;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMathod() {
        return mathod;
    }

    public void setMathod(String mathod) {
        this.mathod = mathod;
    }

    public String getDealinpattern() {
        return dealinpattern;
    }

    public void setDealinpattern(String dealinpattern) {
        this.dealinpattern = dealinpattern;
    }

    public Short getClevel() {
        return clevel;
    }

    public void setClevel(Short clevel) {
        this.clevel = clevel;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSaleman() {
        return saleman;
    }

    public void setSaleman(String saleman) {
        this.saleman = saleman;
    }

    public String getPropertylevel() {
        return propertylevel;
    }

    public void setPropertylevel(String propertylevel) {
        this.propertylevel = propertylevel;
    }

    public BigDecimal getSaletarget() {
        return saletarget;
    }

    public void setSaletarget(BigDecimal saletarget) {
        this.saletarget = saletarget;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getCarea() {
        return carea;
    }

    public void setCarea(BigDecimal carea) {
        this.carea = carea;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public String getParentchannelid() {
        return parentchannelid;
    }

    public void setParentchannelid(String parentchannelid) {
        this.parentchannelid = parentchannelid;
    }

    public String getAccountcustomerId() {
        return accountcustomerId;
    }

    public void setAccountcustomerId(String accountcustomerId) {
        this.accountcustomerId = accountcustomerId;
    }

    public Integer getAccountcustomerflag() {
        return accountcustomerflag;
    }

    public void setAccountcustomerflag(Integer accountcustomerflag) {
        this.accountcustomerflag = accountcustomerflag;
    }

    public String getDppricetype() {
        return dppricetype;
    }

    public void setDppricetype(String dppricetype) {
        this.dppricetype = dppricetype;
    }

    public String getBalancepricetype() {
        return balancepricetype;
    }

    public void setBalancepricetype(String balancepricetype) {
        this.balancepricetype = balancepricetype;
    }

    public Integer getBalancepricegetfromgoods() {
        return balancepricegetfromgoods;
    }

    public void setBalancepricegetfromgoods(Integer balancepricegetfromgoods) {
        this.balancepricegetfromgoods = balancepricegetfromgoods;
    }

    public BigDecimal getFdiscount() {
        return fdiscount;
    }

    public void setFdiscount(BigDecimal fdiscount) {
        this.fdiscount = fdiscount;
    }

    public BigDecimal getMarketplacediscount() {
        return marketplacediscount;
    }

    public void setMarketplacediscount(BigDecimal marketplacediscount) {
        this.marketplacediscount = marketplacediscount;
    }

    public BigDecimal getQiexchangerate() {
        return qiexchangerate;
    }

    public void setQiexchangerate(BigDecimal qiexchangerate) {
        this.qiexchangerate = qiexchangerate;
    }

    public Integer getQiexchangecyc() {
        return qiexchangecyc;
    }

    public void setQiexchangecyc(Integer qiexchangecyc) {
        this.qiexchangecyc = qiexchangecyc;
    }

    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Integer getExchangecyc() {
        return exchangecyc;
    }

    public void setExchangecyc(Integer exchangecyc) {
        this.exchangecyc = exchangecyc;
    }

    public BigDecimal getExchangefirst() {
        return exchangefirst;
    }

    public void setExchangefirst(BigDecimal exchangefirst) {
        this.exchangefirst = exchangefirst;
    }

    public Integer getSpromobeforevip() {
        return spromobeforevip;
    }

    public void setSpromobeforevip(Integer spromobeforevip) {
        this.spromobeforevip = spromobeforevip;
    }

    public Integer getSortcycdays() {
        return sortcycdays;
    }

    public void setSortcycdays(Integer sortcycdays) {
        this.sortcycdays = sortcycdays;
    }

    public BigDecimal getNospromoscale() {
        return nospromoscale;
    }

    public void setNospromoscale(BigDecimal nospromoscale) {
        this.nospromoscale = nospromoscale;
    }

    public String getVipusegroup() {
        return vipusegroup;
    }

    public void setVipusegroup(String vipusegroup) {
        this.vipusegroup = vipusegroup;
    }

    public String getStockquerygroup() {
        return stockquerygroup;
    }

    public void setStockquerygroup(String stockquerygroup) {
        this.stockquerygroup = stockquerygroup;
    }

    public String getBusinessmangroup() {
        return businessmangroup;
    }

    public void setBusinessmangroup(String businessmangroup) {
        this.businessmangroup = businessmangroup;
    }

    public Integer getShutout() {
        return shutout;
    }

    public void setShutout(Integer shutout) {
        this.shutout = shutout;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public Integer getAllowminusstock() {
        return allowminusstock;
    }

    public void setAllowminusstock(Integer allowminusstock) {
        this.allowminusstock = allowminusstock;
    }

    public String getShopsId() {
        return shopsId;
    }

    public void setShopsId(String shopsId) {
        this.shopsId = shopsId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public Integer getCalulate() {
        return calulate;
    }

    public void setCalulate(Integer calulate) {
        this.calulate = calulate;
    }

    public String getFormulaid() {
        return formulaid;
    }

    public void setFormulaid(String formulaid) {
        this.formulaid = formulaid;
    }

    public Integer getOvercrdt() {
        return overcrdt;
    }

    public void setOvercrdt(Integer overcrdt) {
        this.overcrdt = overcrdt;
    }

    public Integer getIscheckbalancemode() {
        return ischeckbalancemode;
    }

    public void setIscheckbalancemode(Integer ischeckbalancemode) {
        this.ischeckbalancemode = ischeckbalancemode;
    }

    public Integer getPrintpossmallbill() {
        return printpossmallbill;
    }

    public void setPrintpossmallbill(Integer printpossmallbill) {
        this.printpossmallbill = printpossmallbill;
    }

    public String getRepofficeId() {
        return repofficeId;
    }

    public void setRepofficeId(String repofficeId) {
        this.repofficeId = repofficeId;
    }

    public Integer getIsautobuildbill() {
        return isautobuildbill;
    }

    public void setIsautobuildbill(Integer isautobuildbill) {
        this.isautobuildbill = isautobuildbill;
    }

    public Integer getCompanypriceflag() {
        return companypriceflag;
    }

    public void setCompanypriceflag(Integer companypriceflag) {
        this.companypriceflag = companypriceflag;
    }

    public String getAccountcompanyId() {
        return accountcompanyId;
    }

    public void setAccountcompanyId(String accountcompanyId) {
        this.accountcompanyId = accountcompanyId;
    }

    public Integer getIsemporium() {
        return isemporium;
    }

    public void setIsemporium(Integer isemporium) {
        this.isemporium = isemporium;
    }

    public Integer getNotintegral() {
        return notintegral;
    }

    public void setNotintegral(Integer notintegral) {
        this.notintegral = notintegral;
    }

    public Integer getNotdiscount() {
        return notdiscount;
    }

    public void setNotdiscount(Integer notdiscount) {
        this.notdiscount = notdiscount;
    }

    public Integer getNotsendmobilemsg() {
        return notsendmobilemsg;
    }

    public void setNotsendmobilemsg(Integer notsendmobilemsg) {
        this.notsendmobilemsg = notsendmobilemsg;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCustomergroup() {
        return customergroup;
    }

    public void setCustomergroup(String customergroup) {
        this.customergroup = customergroup;
    }

    public Integer getIsquotamanage() {
        return isquotamanage;
    }

    public void setIsquotamanage(Integer isquotamanage) {
        this.isquotamanage = isquotamanage;
    }

    public Integer getCheckminusstockwhenposdaybalance() {
        return checkminusstockwhenposdaybalance;
    }

    public void setCheckminusstockwhenposdaybalance(Integer checkminusstockwhenposdaybalance) {
        this.checkminusstockwhenposdaybalance = checkminusstockwhenposdaybalance;
    }

    public Integer getIsuseunitprice() {
        return isuseunitprice;
    }

    public void setIsuseunitprice(Integer isuseunitprice) {
        this.isuseunitprice = isuseunitprice;
    }

    public Integer getIsmall() {
        return ismall;
    }

    public void setIsmall(Integer ismall) {
        this.ismall = ismall;
    }

    public Integer getMultiselectrenotice() {
        return multiselectrenotice;
    }

    public void setMultiselectrenotice(Integer multiselectrenotice) {
        this.multiselectrenotice = multiselectrenotice;
    }

    public Integer getMultiselectshopapplyout() {
        return multiselectshopapplyout;
    }

    public void setMultiselectshopapplyout(Integer multiselectshopapplyout) {
        this.multiselectshopapplyout = multiselectshopapplyout;
    }

    public BigDecimal getUsearea() {
        return usearea;
    }

    public void setUsearea(BigDecimal usearea) {
        this.usearea = usearea;
    }

    public BigDecimal getShoptoparea() {
        return shoptoparea;
    }

    public void setShoptoparea(BigDecimal shoptoparea) {
        this.shoptoparea = shoptoparea;
    }

    public BigDecimal getShopafterarea() {
        return shopafterarea;
    }

    public void setShopafterarea(BigDecimal shopafterarea) {
        this.shopafterarea = shopafterarea;
    }

    public BigDecimal getContractarea() {
        return contractarea;
    }

    public void setContractarea(BigDecimal contractarea) {
        this.contractarea = contractarea;
    }

    public BigDecimal getShoplocation1() {
        return shoplocation1;
    }

    public void setShoplocation1(BigDecimal shoplocation1) {
        this.shoplocation1 = shoplocation1;
    }

    public BigDecimal getShoplocation2() {
        return shoplocation2;
    }

    public void setShoplocation2(BigDecimal shoplocation2) {
        this.shoplocation2 = shoplocation2;
    }

    public Integer getStandardstockqt() {
        return standardstockqt;
    }

    public void setStandardstockqt(Integer standardstockqt) {
        this.standardstockqt = standardstockqt;
    }

    public BigDecimal getStandardarearate() {
        return standardarearate;
    }

    public void setStandardarearate(BigDecimal standardarearate) {
        this.standardarearate = standardarearate;
    }

    public Date getContractbegindate() {
        return contractbegindate;
    }

    public void setContractbegindate(Date contractbegindate) {
        this.contractbegindate = contractbegindate;
    }

    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }

    public BigDecimal getSecurityamount() {
        return securityamount;
    }

    public void setSecurityamount(BigDecimal securityamount) {
        this.securityamount = securityamount;
    }

    public String getControlman() {
        return controlman;
    }

    public void setControlman(String controlman) {
        this.controlman = controlman;
    }

    public String getShopstaffing() {
        return shopstaffing;
    }

    public void setShopstaffing(String shopstaffing) {
        this.shopstaffing = shopstaffing;
    }

    public Integer getBillingcycle() {
        return billingcycle;
    }

    public void setBillingcycle(Integer billingcycle) {
        this.billingcycle = billingcycle;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivisionlevel() {
        return divisionlevel;
    }

    public void setDivisionlevel(String divisionlevel) {
        this.divisionlevel = divisionlevel;
    }

    public String getOwnbrand() {
        return ownbrand;
    }

    public void setOwnbrand(String ownbrand) {
        this.ownbrand = ownbrand;
    }

    public Integer getIscalccost() {
        return iscalccost;
    }

    public void setIscalccost(Integer iscalccost) {
        this.iscalccost = iscalccost;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getGiftcardusegroup() {
        return giftcardusegroup;
    }

    public void setGiftcardusegroup(String giftcardusegroup) {
        this.giftcardusegroup = giftcardusegroup;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getVipstoredgroup() {
        return vipstoredgroup;
    }

    public void setVipstoredgroup(String vipstoredgroup) {
        this.vipstoredgroup = vipstoredgroup;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public Object getBrands() {
        return brands;
    }

    public void setBrands(Object brands) {
        this.brands = brands;
    }

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public Object getSalemans() {
        return salemans;
    }

    public void setSalemans(Object salemans) {
        this.salemans = salemans;
    }

    public String getPractisedatestr() {
        return practisedatestr;
    }

    public void setPractisedatestr(String practisedatestr) {
        this.practisedatestr = practisedatestr;
    }

    public String getShutoutdatestr() {
        return shutoutdatestr;
    }

    public void setShutoutdatestr(String shutoutdatestr) {
        this.shutoutdatestr = shutoutdatestr;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankaddr() {
        return bankaddr;
    }

    public void setBankaddr(String bankaddr) {
        this.bankaddr = bankaddr;
    }

    public String getAccountsName() {
        return accountsName;
    }

    public void setAccountsName(String accountsName) {
        this.accountsName = accountsName;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBanktel() {
        return banktel;
    }

    public void setBanktel(String banktel) {
        this.banktel = banktel;
    }

    public String getCmemo() {
        return cmemo;
    }

    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }

    public String getParentChannelId() {
        return parentChannelId;
    }

    public void setParentChannelId(String parentChannelId) {
        this.parentChannelId = parentChannelId;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }
}
