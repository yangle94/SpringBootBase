package cn.ylapl.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 发送通知时所需的内容和用户列表
 * Created by Angle on 2017/2/28.
 */
public class UserIdCodeMessageDTO implements Serializable {
    /**
     * 内部系统userid
     */
    private List<String> userIdList;
    /**
     * 极光手机code
     */
    private List<String> identifyingCodeList;
    /**
     * 标签
     */
    private List<String> tag;
    /**
     * 别名
     */
    private List<String> alias;
    /**
     * 标签且
     */
    private List<String> tag_and;
    /**
     * 通知内容
     */
    private String message;
    /**
     * 0:默认学乐师生 1:学乐云家庭 2:学乐云教学store生产版本
     */
    private Integer flag;

    //操作类型
    /** [380001-消息详情] [380002-家庭邀请] [380003-活动审核] */
    private String type;

    /**
     * 属性表
     */
    private Map<String,String> parameters;

    public String getType() {
        return type;
    }

    public UserIdCodeMessageDTO setType(String type) {
        this.type = type;
        return this;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public UserIdCodeMessageDTO setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public UserIdCodeMessageDTO setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public UserIdCodeMessageDTO() {
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public UserIdCodeMessageDTO setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
        return this;
    }

    public List<String> getIdentifyingCodeList() {
        return identifyingCodeList;
    }

    public UserIdCodeMessageDTO setIdentifyingCodeList(List<String> identifyingCodeList) {
        this.identifyingCodeList = identifyingCodeList;
        return this;
    }

    public List<String> getTag() {
        return tag;
    }

    public UserIdCodeMessageDTO setTag(List<String> tag) {
        this.tag = tag;
        return this;
    }

    public List<String> getAlias() {
        return alias;
    }

    public UserIdCodeMessageDTO setAlias(List<String> alias) {
        this.alias = alias;
        return this;
    }

    public List<String> getTag_and() {
        return tag_and;
    }

    public UserIdCodeMessageDTO setTag_and(List<String> tag_and) {
        this.tag_and = tag_and;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserIdCodeMessageDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public UserIdCodeMessageDTO(List<String> userIdList, List<String> identifyingCodeList, List<String> tag, List<String> alias, List<String> tag_and, String message) {

        this.userIdList = userIdList;
        this.identifyingCodeList = identifyingCodeList;
        this.tag = tag;
        this.alias = alias;
        this.tag_and = tag_and;
        this.message = message;
    }
}
