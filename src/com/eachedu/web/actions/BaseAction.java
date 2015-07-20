package com.eachedu.web.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.eachedu.utils.ConstUtils;
import com.eachedu.web.vo.UserVO;
import com.sdicons.json.mapper.JSONMapper;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public abstract class BaseAction {
	
	//附件信息上传
	protected String fileName;
	protected String contentType;
	protected File uploadFile;
	
	private int checkCodeWidth = 80;
	private int checkCodeHeight = 40;
	private int checkCodeNumber = 4; // 显示多少个字符
	protected String checkCodeCodes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 有哪些字符可供选择
	
	/**
	 * 从HTTP SESSION中取出已登录的User对象信息
	 * @return
	 */
	protected UserVO currentUser(){
		return (UserVO)ServletActionContext.getRequest().getSession().getAttribute(ConstUtils.USER_LOGIN);
	}
	
	public void setAttribute(String key, Object value){
		ServletActionContext.getRequest().setAttribute(key, value);
	}
	
	public Object getAttribute(String key){
		return ServletActionContext.getRequest().getAttribute(key);
	}
	
	public void setSession(String key, Object value){
		ServletActionContext.getRequest().getSession().setAttribute(key, value);
	}
	
	public Object getSession(String key){
		return ServletActionContext.getRequest().getSession().getAttribute(key);
	}
	
	//生成验证码
	public void checkcode(){

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			response.setContentType("image/jpeg");

			// 创建一张图片
			BufferedImage image = new BufferedImage(checkCodeWidth, checkCodeHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();

			// 创建白色背景
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, checkCodeWidth, checkCodeHeight);

			// 画黑边框
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, checkCodeWidth - 1, checkCodeHeight - 1);

			Random random = new Random();

			// 每个字符占据的宽度
			int x = (checkCodeWidth - 1) / checkCodeNumber;
			int y = checkCodeHeight - 4;

			StringBuffer sb = new StringBuffer();

			// 随机生成字符
			for (int i = 0; i < checkCodeNumber; i++) {
				String code = String.valueOf(checkCodeCodes.charAt(random.nextInt(checkCodeCodes
						.length())));
				int red = random.nextInt(255);
				int green = random.nextInt(255);
				int blue = random.nextInt(255);
				g.setColor(new Color(red, green, blue));

				Font font = new Font("Arial", Font.PLAIN,
						random(checkCodeHeight / 2, checkCodeHeight));
				g.setFont(font);

				g.drawString(code, i * x + 1, y);

				sb.append(code);
			}

			// 将验证码串放到HTTP SESSION中
			request.getSession().setAttribute("codes", sb.toString());

			// 随机生成一些点
			for (int i = 0; i < 50; i++) {
				int red = random.nextInt(255);
				int green = random.nextInt(255);
				int blue = random.nextInt(255);
				g.setColor(new Color(red, green, blue));
				g.drawOval(random.nextInt(checkCodeWidth), random.nextInt(checkCodeHeight), 1, 1);
			}

			OutputStream out = response.getOutputStream();
			// 将图片转换为JPEG类型
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);

			out.flush();
			out.close();
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getCheckcode(){
		ajaxWriteOutStr((String) ServletActionContext.getRequest().getSession().getAttribute("codes"));
	}
	
	/**
	 * 产生一个从min到max之间的随机数
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	protected int random(int min, int max) {
		int m = new Random().nextInt(999999) % (max - min);
		return m + min;
	}
	
	/**
	 * 获取当前工程名路径
	 * @return
	 */
	public String getURLBase() {
		return this.getRequest().getContextPath();
	}
   
	/**
	 * 获取当前工程详细路径
	 * @return
	 */
	public String getRealPath(){
		return getServletContext().getRealPath("/");
	}
	
	public String getSRCPath(){
		return new Thread().getContextClassLoader().getClass().getResource("/").getPath();
	}
	
	public String getUploadPath(){
		return getServletContext().getRealPath("/") + "ATTACHMENT\\";
	}
	
	public void delFile(String fileName){
		File file = new File(getUploadFile() + fileName);
		file.deleteOnExit();
	}
	
	public String getCurrentUrl() throws Exception {
		String urlBase = getRequest().getRequestURL().toString();
		String urlParameters = getRequest().getQueryString();
		return URLEncoder.encode(urlBase + "?" + urlParameters, "UTF-8");
	}
	protected final ServletContext getServletContext(){
		return ServletActionContext.getServletContext();
	}
	protected final HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected final HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected final HttpSession getHttpSession() {
		return getRequest().getSession();
	}

	public final String getSessionId() {
		return getHttpSession().getId();
	}
	
	/**
	 * ajax 输出
	 * @param msg
	 */
	public void ajaxWriteOutStr(String msg){
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().println(
					msg
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ajaxWriteOutJSON(Object object){
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().println(
				JSONMapper.toJSON(object).render(false)
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("在将对象"+object+"转换为JSON格式字符串的时候发生异常！");
		}
	}
	
	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	//接收上传文件的文件名
	public void setUploadFileFileName(String fName){
		fileName = fName;
	}
	
	//接收上传文件的类型
	public void setUploadFileContentType(String contentType){
		this.contentType = contentType;
	}
	
	/**
	 * 校验文件是否在最大值内
	 * @param file
	 * @param maxSize
	 * @return
	 */
	public boolean verifyFileSize(File file, int maxSize){
		if (file != null && file.length()/1024 <= maxSize ) {
			return true;
		}
		return false;
	}
	

	public int getCheckCodeWidth() {
		return checkCodeWidth;
	}

	public void setCheckCodeWidth(int checkCodeWidth) {
		this.checkCodeWidth = checkCodeWidth;
	}

	public int getCheckCodeHeight() {
		return checkCodeHeight;
	}

	public void setCheckCodeHeight(int checkCodeHeight) {
		this.checkCodeHeight = checkCodeHeight;
	}

	public int getCheckCodeNumber() {
		return checkCodeNumber;
	}

	public void setCheckCodeNumber(int checkCodeNumber) {
		this.checkCodeNumber = checkCodeNumber;
	}

	public String getCheckCodeCodes() {
		return checkCodeCodes;
	}

	public void setCheckCodeCodes(String checkCodeCodes) {
		this.checkCodeCodes = checkCodeCodes;
	}
}
