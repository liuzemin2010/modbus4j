package com.net4iot.oss.infra.utils;

import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.net4iot.oss.domain.dto.MsgInfo;
import com.net4iot.oss.infra.config.Config;

/**
 * <pre>
 * 作用:
 * 注意:
 * 其他:
 * </pre>
 *
 * @author chenwentao
 * @version 1.0, Jan 29, 2016
 * @see
 * @since
 */
public class ClientFTP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 上传文件
	 * 
	 * @param fileName
	 * @param in
	 * @return
	 */
	public static MsgInfo ftpUploadFile(String fileName, InputStream in) {
		MsgInfo msgInfo = new MsgInfo();
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(Config.getProperty(Config.FTP_URL),
					new Long(Config.getProperty(Config.FTP_PORT)).intValue());// 连接FTP服务器

			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(Config.getProperty(Config.FTP_NAME),
					Config.getProperty(Config.FTP_PASSWORD));// 登录

			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				msgInfo.reset(1, "连接FTP服务器失败");
				return msgInfo;
			}

			if (!ftp.changeWorkingDirectory(Config
					.getProperty(Config.FTP_IMAGE_SAVEPATH))) {
				msgInfo.reset(1, "上传失败");
				return msgInfo;
			}

			ftp.setControlEncoding("UTF-8");

			// 设置文件类型
			if (!ftp.setFileType(FTPClient.BINARY_FILE_TYPE)) {
				msgInfo.reset(1, "上传失败");
				return msgInfo;
			}

			if (!ftp.storeFile(fileName, in)) {
				msgInfo.reset(1, "上传失败");
				return msgInfo;
			}

			ftp.logout();
		} catch (Exception e) {
			msgInfo.reset(1, "上传失败");
			return msgInfo;
		}

		return msgInfo;
	}

	/**
	 * 远程删除文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static MsgInfo ftpRemoveFile(String fileName) {
		MsgInfo msgInfo = new MsgInfo();
		FTPClient ftp = new FTPClient();

		try {
			ftp.connect(Config.getProperty(Config.FTP_URL),
					new Long(Config.getProperty(Config.FTP_PORT)).intValue());// 连接FTP服务器

			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(Config.getProperty(Config.FTP_NAME),
					Config.getProperty(Config.FTP_PASSWORD));// 登录

			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				msgInfo.reset(1, "连接FTP服务器失败");
				return msgInfo;
			}

			if (!ftp.changeWorkingDirectory(Config
					.getProperty(Config.FTP_IMAGE_SAVEPATH))) {
				msgInfo.reset(1, "上传失败");
				return msgInfo;
			}

			ftp.deleteFile(fileName);

			ftp.logout();
		} catch (Exception e) {
			msgInfo.reset(1, "上传失败");
			return msgInfo;
		}

		return msgInfo;
	}

}
