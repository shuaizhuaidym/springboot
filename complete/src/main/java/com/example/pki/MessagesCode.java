package com.example.pki;

public class MessagesCode {
	public static final String A00F0001 = "A00F0001";
	/** 组装客户端询问响应报文失败，报文数据为空。 */
	public static final String A00F0002 = "A00F0002";
	/** 组装客户端认证响应报文失败，报文数据为空。 */
	public static final String A00F0003 = "A00F0003";
	/** 组装客户端询问响应报文失败，认证参数为空。 */
	public static final String A00F0004 = "A00F0004";
	/** 组装客户端认证响应报文失败，系统设置为空。 */
	public static final String A00F0005 = "A00F0005";
	/** 解析证书失败。 */
	public static final String A00F0006 = "A00F0006";
	/** 读取JKS文件失败。 */
	public static final String A00F0007 = "A00F0007";
	/** 读取JKS中的信任CA证书失败。 */
	public static final String A00F0008 = "A00F0008";
	/** 客户端认证失败，校验证书时出现异常。 */
	public static final String A00F0009 = "A00F0009";
	/** 证书[{0}]未生效，证书有效时间为{1}到{2}。 */
	public static final String A00F000A = "A00F000A";
	/** 证书[{0}]被注销。 */
	public static final String A00F000B = "A00F000B";
	/** 证书[{0}]已过期，证书有效时间为{1}到{2}。 */
	public static final String A00F000C = "A00F000C";
	/** 证书[{0}]被冻结。 */
	public static final String A00F000D = "A00F000D";
	/** 证书[{0}]无效。 */
	public static final String A00F000E = "A00F000E";
	/** 链接OCSP验证证书失败。 */
	public static final String A00F000F = "A00F000F";
	/** 校验证书[{0}]时出现未知错误。 */
	public static final String A00F000G = "A00F000G";
	/** 证书[{0}]用户不存在。 */
	public static final String A00F0020 = "A00F0020";
	/** 证书[{0}]用户被停用。 */
	public static final String A00F0021 = "A00F0021";

	/** 无效的URL[{0}]。 */
	public static final String A00F0010 = "A00F0010";
	/** 证书[{0}]的信任CA不存在，无法验证证书身份。 */
	public static final String A00F0011 = "A00F0011";
	/** 您输入的地址[{0}]不在网关的应用列表中。 */
	public static final String A00F0012 = "A00F0012";
	/** 组装客户端认证响应报文失败，客户端策略为空。 */
	public static final String A00F0013 = "A00F0013";
	/** cer格式文件转换成pem格式文件出现失败。 */
	public static final String A00F0014 = "A00F0014";
	/** 文件转换成X509Certificate证书失败。 */
	public static final String A00F0015 = "A00F0015";
	/** xslt转换xml报文失败。 */
	public static final String A00F0017 = "A00F0017";
	/** 验证签名时接收到的证书对象无效 ，无法进行认证。 */
	public static final String A00F0018 = "A00F0018";
	/** license不支持移动终端报文认证。 */
	public static final String A00F0019 = "A00F0019";
	/** 站点证书密码不正确 **/
	public static final String A00F0022 = "A00F0022";
	/** CRL更新失败，禁止认证。 */
	public static final String A00F0023 = "A00F0023";
	/** 从用户证书中取出密钥时发生错误，证书[{0}]格式不正确。 */
	public static final String A00F0101 = "A00F0101";
	/** 证书认证失败，您不是证书[{0}]的真正持有者，请使用正确的个人证书。 */
	public static final String A00F0102 = "A00F0102";
	/** 证书认证失败，验证证书[{0}]的持有者时出现错误。 */
	public static final String A00F0103 = "A00F0103";
	/** 口令认证失败，用户属性源未开启，请联系管理员。 */
	public static final String A00F010A = "A00F010A";
	/** 请管理员上传可信CA证书。 */
	public static final String A00F0107 = "A00F0107";
	/** 读取可信CA证书失败。 */
	public static final String A00F0108 = "A00F0108";
	/** 校验用户证书失败，请重新登录。 */
	public static final String A00F0109 = "A00F0109";
	/** 财政部项目（外部直接向网关提交表单）错误:签名结果格式错误 */
	public static final String A00F0C10 = "A00F0C10";
	/** 财政部项目（外部直接向网关提交表单）错误:公钥证书格式错误 */
	public static final String A00F0C11 = "A00F0C11";
	/** 财政部项目（外部直接向网关提交表单）错误:签名原文格式错误 */
	public static final String A00F0C12 = "A00F0C12";
	/** RSA证书验签名失败。 */
	public static final String A00F010B = "A00F010B";

	/** 国密证书验签名失败。 */
	public static final String A00F010C = "A00F010C";

	/** 连接普密密码机验签名失败，请检查密码机状态。 */
	public static final String A00F010D = "A00F010D";
	/** 连接普密密码机验签名失败，请检查“密码机配置”功能是否开启。 */
	public static final String A00F010E = "A00F010E";
	/** 用户登陆口令超过设置周期,请修改口令。 */
	public static final String A00F010F = "A00F010F";
	/** 用户登陆PIN吗超过设置周期,请修改PIN码。 */
	public static final String A00F0100 = "A00F0100";

	// *************** 反向代理中的反向T+A验证 A00F02XX ****************/
	/** 提交的请求错误，请求报文体为空。 */
	public static final String A00F0201 = "A00F0201";
	/** Token无效，请重新登录。 */
	public static final String A00F0202 = "A00F0202";
	/** 您所访问的[{0}]应用不网关的应用列表中。 */
	public static final String A00F0203 = "A00F0203";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0204 = "A00F0204";
	/** 没有获取到用户的任何属性信息。 */
	public static final String A00F0205 = "A00F0205";
	/** 解析响应报文体出现异常。 */
	public static final String A00F0206 = "A00F0206";
	/** 获取cab包（插件包）版本失败。 */
	public static final String A00F0207 = "A00F0207";
	/** 应用接入类型错误 */
	public static final String A00F0208 = "A00F0208";

	// ************** 客户自动升级服务错误码：A00FXXXX *****************/
	/** Token无效，请认证后再升级客户端。 */
	public static final String A00F0301 = "A00F0301";
	/** 客户端无权升级。 */
	public static final String A00F0302 = "A00F0302";
	/** 组装客户端自动升级响应报文失败，报文数据为空。 */
	public static final String A00F0303 = "A00F0303";
	/** 获取当前客户端升级包失败。 */
	public static final String A00F0304 = "A00F0304";
	/** 组装客户端自动升级响应报文中的客户端升级包信息时失败。 */
	public static final String A00F0305 = "A00F0305";
	/** 没有找到需要升级的客户端安装包、插件包或资源包。 */
	public static final String A00F0306 = "A00F0306";

	// ********************* 反向T+A验证 A00F04XX *********************/
	/** 提交的请求错误，请求报文体为空。 */
	public static final String A00F0401 = "A00F0401";
	/** Token无效，请重新登录。 */
	public static final String A00F0402 = "A00F0402";
	/** 您所访问的[{0}]应用不网关的应用列表中。 */
	public static final String A00F0403 = "A00F0403";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0404 = "A00F0404";
	/** 访问应用失败，解析[{0}]应用的URL地址出现异常。 */
	public static final String A00F0405 = "A00F0405";
	/** 解析响应报文体出现异常。 */
	public static final String A00F0406 = "A00F0406";
	/** 不支持该种访问方式，请使用其他方式访问应用系统 */
	public static final String A00F0407 = "A00F0407";
	/** 访问应用失败，读取角色证书文件[{0}]时出现异常 */
	public static final String A00F0408 = "A00F0408";

	// ***************************************************************/

	/** 保存自学习内容失败。 */
	public static final String A00F0501 = "A00F0501";
	// *************** 反向代理中的正向T+A验证 A00F06XX ****************/
	/** 解析响应报文体出现异常。 */
	public static final String A00F0601 = "A00F0601";
	/** Token无效，请重新登录。 */
	public static final String A00F0602 = "A00F0602";
	/** 您所访问的[{0}]应用不网关的应用列表中。 */
	public static final String A00F0603 = "A00F0603";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0604 = "A00F0604";
	/** 您输入的地址[{0}]不在网关的应用列表中。 */
	public static final String A00F0605 = "A00F0605";
	/** 提交的请求错误，请求报文体为空。 */
	public static final String A00F0606 = "A00F0606";
	/** 获取策略失败，策略信息为空。 */
	public static final String A00F0607 = "A00F0607";
	// *************** A00F07XX ****************/
	/** 查询从账号失败 */
	public static final String A00F0701 = "A00F0701";
	/** 更新策略模板Token错误 */
	// add by wq
	public static final String A00F0801 = "A00F0801";

	// ************* 反向代理中的正向应用策略下载 A00F09XX *************/
	/** 提交的请求错误，请求报文体为空。 */
	public static final String A00F0901 = "A00F0901";
	/** Token无效，请重新登录。 */
	public static final String A00F0902 = "A00F0902";
	/** 您提交的硬件信息为空，请重新认证。 */
	public static final String A00F0903 = "A00F0903";
	/** 您输入的地址[{0}]不在网关的应用列表中。 */
	public static final String A00F0904 = "A00F0904";
	/** 您所访问的[{0}]应用不网关的应用列表中。 */
	public static final String A00F0905 = "A00F0905";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0906 = "A00F0906";
	/** 获取策略失败，策略信息为空。 */
	public static final String A00F0907 = "A00F0907";

	// ************* 会话交换服务 A00F0AXX *************/
	public static final String A00F0A01 = "A00F0A01";
	public static final String A00F0A02 = "A00F0A02";
	public static final String A00F0A03 = "A00F0A03";

	// ************* Agent服务 A00F0AXX *************/
	/** 获取用户身份信息失败，用户身份信息已经过期或失效 */
	public static final String A00F0B01 = "A00F0B01";
	/** 获取用户身份信息失败，用户身份信息已经过期或失效 */
	public static final String A00F0B02 = "A00F0B02";
	/** 获取用户身份信息失败，Artifact解码失败 */
	public static final String A00F0B03 = "A00F0B03";
	/** 无效的查询类型 */
	public static final String A00F0B04 = "A00F0B04";
	/** 您访问的应用不在网关的应用列表中。 */
	public static final String A00F0B05 = "A00F0B05";
	/** 查询用户属性信息时发生异常 */
	public static final String A00F0B06 = "A00F0B06";
	/** 查询的个人属性信息不存在 */
	public static final String A00F0B07 = "A00F0B07";
	/** 无效的查询类型 */
	public static final String A00F0B08 = "A00F0B08";
	/** 获取用户证书信息失败 */
	public static final String A00F0B09 = "A00F0B09";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0B0A = "A00F0B0A";
	/** 未知的请求类型 */
	public static final String A00F0B0B = "A00F0B0B";
	/** 收到的请求格式无效或内容不完整。 */
	public static final String A00F0B0C = "A00F0B0C";
	/** 令牌已经失效或过期，请重新认证。 */
	public static final String A00F0B0D = "A00F0B0D";
	/** 获取应用[{0}]权限出现异常。 */
	public static final String A00F0B0E = "A00F0B0E";
	/** 您访问的应用不在网关的应用列表中。 */
	public static final String A00F0B0F = "A00F0B0F";
	/** 查询用户身份信息的请求已经过期 。 */
	public static final String A00F0B10 = "A00F0B10";
	/** 没有权限访问Agent应用。 */
	public static final String A00F0B11 = "A00F0B11";

	// end add
	/** 数据编码出现异常。 */
	public static final String A00F0F01 = "A00F0F01";
	/** 数据解码出现异常。 */
	public static final String A00F0F02 = "A00F0F02";
	/** 解析客户端信息失败 */
	public static final String A00F0F03 = "A00F0F03";
	/** 获取UTF-8转码异常。 */
	public static final String A00F0F04 = "A00F0F04";
	/** 获取模板页面[{0}]失败。 */
	public static final String A00F0F05 = "A00F0F05";
	/** 获取模板页面失败。 */
	public static final String A00F0F06 = "A00F0F06";
	/** 处理模板页面失败。 */
	public static final String A00F0F07 = "A00F0F07";
	/** 生成错误页面时出现异常，处理业务时错误码[{0}]，错误描述[{1}]。 */
	public static final String A00F0F08 = "A00F0F08";
	/** 生成错误页面时出现异常，错误信息缺失。 */
	public static final String A00F0F09 = "A00F0F09";

	/** 验证签名失败。 */
	public static final String A00F0F10 = "A00F0F10";
	/** 报文认证原文失败。 */
	public static final String A00F0F11 = "A00F0F11";

	/** 不支持此种认证方式 */
	public static final String A00F0F12 = "A00F0F12";

	/** Detach报文中原文或签名结果为空 */
	public static final String A00F0F13 = "A00F0F13";

	/** Attach报文中签名结果为空 */
	public static final String A00F0F14 = "A00F0F14";

	/** 系统内部错误，请与管理员联系。 */
	public static final String A00FFFFF = "A00FFFFF";

	/** 系统内部错误，请与管理员联系。 */
	public static final String A00FFFFE = "A00FFFFE";

	/** （从LADP服务器上）未找到合法证书 */
	public static final String A00F0F15 = "A00F0F15";
	/** 随机数加密失败！ */
	public static final String A00F0F16 = "A00F0F16";
	/** 对随机数做摘要失败！ */
	public static final String A00F0F17 = "A00F0F17";
	/** 证书状态无效，未通过验证！ */
	public static final String A00F0F18 = "A00F0F18";
	/** 非法的证书标识 */
	public static final String A00F0F19 = "A00F0F19";
	/** 认证原文已失效 */
	public static final String A00F0F20 = "A00F0F20";
	/** 产生随机数失败 */
	public static final String A00F0F21 = "A00F0F21";
	/** p1Sign报文中签名结果为空 */
	public static final String A00F0F22 = "A00F0F22";
	/** 认证数据非法，二维码非本服务器生成或已过期 */
	public static final String A00F0F23 = "A00F0F23";
	/** 该二维码已认证 */
	public static final String A00F0F24 = "A00F0F24";
	/** 签名数据不正确 */
	public static final String A00F0F26 = "A00F0F26";
	/** 解析二维码授权报文错误 */
	public static final String A00F0F27 = "A00F0F27";
	/** 解析二维码授权报文错误，解信封失败 */
	public static final String A00F0F28 = "A00F0F28";

	/** 报文签名接口 验证签名原文失败 */
	public static final String A00F0F29 = "A00F0F29";
	/** 报文签名接口 签名失败 */
	public static final String A00F0F35 = "A00F0F35";
	/** 报文签名接口 获取签名证书失败 */
	public static final String A00F0F36 = "A00F0F36";

	/** yyyy-MM-dd HH:mm:ss */
	public static final String TIMEFORMAT = "TIMEFORMAT";
	// ******************** 主服务错误码：A00FXXXX *********************/
	/** 挑战值验证失败。 */
	public static final String A00F0F30 = "A00F0F30";
	/** 非法的挑战值。 */
	public static final String A00F0F31 = "A00F0F31";
	/** 未获取到任何属性，请检查信息传递模板配置。 */
	public static final String A00F0F32 = "A00F0F32";
	/** 跨站请求（CSRF） */
	public static final String A00F0F33 = "A00F0F33";
	/** 跨站点脚本编制（XXS） */
	public static final String A00F0F34 = "A00F0F34";
	/******************* OAUTH2.0错误码： A00F0DXX *****************/
	/** 授权错误 */
	public static final String A00F0D00 = "A00F0D00";
	/** 您所访问的应用[{0}]不在网关的应用列表中。 */
	public static final String A00F0D01 = "A00F0D01";
	/** 非法重定向地址 */
	public static final String A00F0D02 = "A00F0D02";
	/** 非法验证类型 */
	public static final String A00F0D03 = "A00F0D03";
	/** 系统内部错误 */
	public static final String A00F0D04 = "A00F0D04";
	/** 非法应用安全口令 */
	public static final String A00F0D05 = "A00F0D05";
	/** 非法授权码 */
	public static final String A00F0D06 = "A00F0D06";
	/** 令牌无效或已过期 */
	public static final String A00F0D07 = "A00F0D07";
	/** 您无权限访问[{0}]应用。 */
	public static final String A00F0D08 = "A00F0D08";
	/** 获取用户身份信息失败，用户身份信息已经过期或失效。 */
	public static final String A00F0D09 = "A00F0D09";
	/** FIDO服务器无法访问此业务 */
	public static final String A00F0D10 = "A00F0D10";
	/** 请求参数不正确 */
	public static final String A00F0D11 = "A00F0D11";
	/** 访问华为云服务器地址异常 */
	public static final String A008AD04 = "A008AD04";
	/** 获取AD域账号密码失败 **/
	public static final String A008AD05 = "A008AD05";

	// ****** NC代理T+A ****/
	public static final String A0330010 = "A0330010";
	public static final String A0330011 = "A0330011";
	public static final String A0330012 = "A0330012";

	/** 查询用户安全策略失败。 */
	public static final String A0160011 = "A0160011";

	/** 监管平台升级网关 */
	public static final String A0340001 = "A0340001";
	public static final String A0340002 = "A0340002";
	public static final String A0340003 = "A0340003";
	public static final String A0340004 = "A0340004";
	public static final String A0340005 = "A0340005";
	/**
	 * 客戶端TOKEN认证PKCS#1签名失败
	 */
	public static final String A00F0F42 = "A00F0F42";
	/** 客户端TOKEN认证,PKCS#1验证签名失败 */
	public static final String A00F0F44 = "A00F0F44";
	/** 获取信任节点证书失败 */
	public static final String A00F0F43 = "A00F0F43";
	public static final String A00F0F46 = "A00F0F46";

	/** 证书+口令失败 */
	public static final String A00F0111 = "A00F0111";
	public static final String A00F0113 = "A00F0113";
	public static final String A00F0114 = "A00F0114";

	/** 客户端个数超过license限制最大个数 **/
	public static final String A00F0112 = "A00F0112";
}
