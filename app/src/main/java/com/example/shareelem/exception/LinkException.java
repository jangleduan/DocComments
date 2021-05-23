package com.example.shareelem.exception;

import com.example.shareelem.NamingException;

/**
 * 此异常用于描述解析链接时遇到的问题。
 * 将附加信息添加到基本NamingException中以进行精确定位
 * 链接问题。
 * <p>
 * 类似于NamingException如何捕获名称解析信息，
 * LinkException捕获精确定位的“链接”名称解析信息
 * 解决链接时遇到的问题。所有这些领域可能
 * 为空。
 * <ul>
 * <li> 链接解析名称。链接名称已解决的部分。
 * <li> 链接解析的对象。链接名称解析的对象。
 * <li> 链接剩余名称。链接名称尚未解析的部分。
 * <li> 链接说明。详细说明链接解析失败的原因。
 * </ul>
 *
 * <p>
 * LinkException实例未针对并发进行同步
 * 多线程访问。多个线程试图访问和修改一个LinkException实例应锁定该对象。
 *
 * @author author1
 * @author author2
 * @see Context#lookupLink
 * @see LinkRef
 * @since 1.3
 */


/*<p>
 * LinkException对象的序列化形式包括
 *其NamingException超类的序列化字段，链接已解析
 *名称（一个名称对象），链接解析对象，链接剩余名称
 *（一个Name对象），以及链接说明String。
 */


public class LinkException extends NamingException {
    /**
     * 包含链接中已成功解析的部分。
     * 这是一个复合名称，可以为null。
     * 此字段由构造函数初始化。
     * 您应该访问和操作此字段
     * 通过其get和set方法。
     *
     * @serial
     * @see #getLinkResolvedName
     * @see #setLinkResolvedName
     */
    protected Name linkResolvedName;

    /**
     * 包含链接部分解析成功的对象。
     * 可以为null。该字段由构造函数初始化。
     * 您应该访问和操作此字段
     * 通过其get和set方法。
     *
     * @serial
     * @see #getLinkResolvedObj
     * @see #setLinkResolvedObj
     */
    protected Object linkResolvedObj;

    /**
     * 包含尚未解析的其余链接名称。
     * 这是一个复合名称，可以为null。
     * 此字段由构造函数初始化。
     * 您应该访问和操作此字段
     * 通过其get和set方法。
     *
     * @serial
     * @see #getLinkRemainingName
     * @see #setLinkRemainingName
     */
    protected Name linkRemainingName;

    /**
     * 包含为什么链接解析失败的例外。
     * 可以为null。该字段由构造函数初始化。
     * 您应该访问和操作此字段
     * 通过其get和set方法。
     *
     * @serial
     * @see #getLinkExplanation
     * @see #setLinkExplanation
     */
    protected String linkExplanation;

    /**
     * 构造一个带有解释的LinkException的新实例
     * 所有其他字段均初始化为null。
     *
     * @param explanation 说明可能为空的字符串，其中包含其他
     *                    有关此异常的详细信息。
     * @see java.lang.Throwable#getMessage
     */
    public LinkException(String explanation) {
        super(explanation);
        linkResolvedName = null;
        linkResolvedObj = null;
        linkRemainingName = null;
        linkExplanation = null;
    }

    /**
     * 构造一个LinkException的新实例。
     * 所有与链接无关和与链接有关的字段均初始化为null。
     */
    public LinkException() {
        super();
        linkResolvedName = null;
        linkResolvedObj = null;
        linkRemainingName = null;
        linkExplanation = null;
    }

    /**
     * 检索已解析的链接名称的开头部分
     * 成功地。
     *
     * @return 链接名称中已成功解析的部分。
     * 这是一个综合名称。它可以为null，这意味着
     * 尚未设置链接解析名称字段。
     * @see #getLinkResolvedObj
     * @see #setLinkResolvedName
     */
    public Name getLinkResolvedName() {
        return this.linkResolvedName;
    }

    /**
     * 检索链接名称的剩余未解决部分。
     *
     * @return 链接名称中尚未解析的部分。
     * 这是一个综合名称。它可以为null，这意味着
     * 链接剩余名称字段尚未设置。
     * @see #setLinkRemainingName
     */
    public Name getLinkRemainingName() {
        return this.linkRemainingName;
    }

    /**
     * 检索成功解析的对象。
     * 这是解析的链接名称所绑定的对象。
     *
     * @return 到目前为止已解决的可能为空的对象。
     * 如果为null，则表示尚未设置链接解析对象字段。
     * @see #getLinkResolvedName
     * @see #setLinkResolvedObj
     */
    public Object getLinkResolvedObj() {
        return this.linkResolvedObj;
    }

    /**
     * 检索与遇到的问题相关的解释
     * 解析链接时。
     *
     * @return 可能为空的详细信息字符串，解释有关该问题的更多信息
     * 解决链接。
     * 如果为null，则表示没有
     * 此异常的链接详细信息。
     * @see #setLinkExplanation
     */
    public String getLinkExplanation() {
        return this.linkExplanation;
    }

    /**
     * 设置与遇到的问题相关的解释
     * 解析链接时。
     *
     * @param msg msg可能为null的详细信息字符串，解释有关该问题的更多信息
     *            解决链接。如果为null，则表示将不记录任何细节。
     * @see #getLinkExplanation
     */
    public void setLinkExplanation(String msg) {
        this.linkExplanation = msg;
    }

    /**
     * 设置此异常的已解析链接名称字段。
     * <p>
     * < tt > name </ tt>是一个复合名称。如果要设定
     * 此字段使用复合名称或字符串，您必须
     * “ stringify”复合名称，并创建一个复合
     * 使用字符串用单个组件命名。那你可以
     * 使用生成的复合名称调用此方法。
     * <p>
     * 复制并存储< code > name </ code>。
     * 随后对< code > name </ code>的更改不会
     * 在此NamingException中影响副本，反之亦然。
     *
     * @param name name设置解析链接名称的名称。可以为空。
     *             如果为null，则将链接解析的名称字段设置为null。
     * @see #getLinkResolvedName
     */
    public void setLinkResolvedName(Name name) {
        if (name != null) {
            this.linkResolvedName = (Name) (name.clone());
        } else {
            this.linkResolvedName = null;
        }
    }

    /**
     * 设置此异常的其余链接名称字段。
     * <p>
     * < tt > name </ tt>是一个复合名称。如果要设定
     * 此字段使用复合名称或字符串，您必须
     * “ stringify”复合名称，并创建一个复合
     * 使用字符串用单个组件命名。那你可以
     * 使用生成的复合名称调用此方法。
     * <p>
     * 复制并存储< code > name </ code>。
     * 随后对< code > name </ code>的更改不会
     * 在此NamingException中影响副本，反之亦然。
     *
     * @param name 设置剩余链接名称的名称。可以为空。
     *             如果为null，则将剩余的name字段设置为null。
     * @see #getLinkRemainingName
     */
    public void setLinkRemainingName(Name name) {
        if (name != null)
            this.linkRemainingName = (Name) (name.clone());
        else
            this.linkRemainingName = null;
    }

    /**
     * 设置此异常的链接解析对象字段。
     * 这表示链接名称的最后一个成功解析的对象。
     *
     * @param obj 设置链接解析对象的对象。可以为空。
     *            如果为null，则将链接解析对象字段设置为null。
     * @see #getLinkResolvedObj
     */
    public void setLinkResolvedObj(Object obj) {
        this.linkResolvedObj = obj;
    }

    /**
     * 生成此异常的字符串表示形式。
     * 此字符串包含NamingException信息以及
     * 链接的剩余名称。
     * 此字符串用于调试，不用于解释
     * 以编程方式。
     *
     * @return 此链接异常的非空字符串表示形式。
     */
    public String toString() {
        return super.toString() + "; Link Remaining Name: '" +
                this.linkRemainingName + "'";
    }

    /**
     * 生成此异常的字符串表示形式。
     * 此字符串包含NamingException信息以及
     * 解决链接的其他信息。
     * 如果'detail'为true，则该字符串还包含有关以下内容的信息
     * 链接解析的对象。如果为false，则此方法相同
     * 作为toString（）的形式，不接受任何参数。
     * 此字符串用于调试，不用于解释
     * 以编程方式。
     *
     * @param detail 如果为true，请添加有关已解析链接的信息
     *               目的。
     * @return此链接异常的非空字符串表示形式。
     */
    public String toString(boolean detail) {
        if (!detail || this.linkResolvedObj == null)
            return this.toString();

        return this.toString() + "; Link Resolved Object: " +
                this.linkResolvedObj;
    }

    /**
     * 使用JNDI 1.1.1中的serialVersionUID进行互操作性
     */
    private static final long serialVersionUID = -7967662604076777712L;
};