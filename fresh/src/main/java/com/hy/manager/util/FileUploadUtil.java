package com.hy.manager.util;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hy.manager.domain.File;

public class FileUploadUtil {
	public static int MAX_SIZE = 5;
	public static File upload(CommonsMultipartFile file,HttpServletRequest request){
		if(file.getSize() > MAX_SIZE*(1024*1024)){
			return null;
		}
		String uuid = UUID.randomUUID().toString();
		String realPath = request.getSession().getServletContext().getRealPath("/") + "/static/upload/" + uuid;
//		String reletivePath = "static/upload/" + uuidFileName;
		String fileName = file.getOriginalFilename();
		int index = fileName.lastIndexOf(".");
		fileName = fileName.substring(0, index);
		String fileType = file.getContentType();
		if (!file.isEmpty()) {
			java.io.File localFile = new java.io.File(realPath);
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), localFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File f = new File();
		f.setName(fileName);
		f.setType(fileType);
		f.setUuid(uuid);
		f.setUploadTime(new Date());
		return f;
	}
}
