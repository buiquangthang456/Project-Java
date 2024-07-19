package com.vanlang.service.impl;

import com.vanlang.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	ServletContext app;

	@Override
	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/assets/" + folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String name = file.getOriginalFilename();

		// Kiểm tra và xử lý trường hợp trùng tên
		File savedFile = new File(dir, name);
		int i = 1;
		while (savedFile.exists()) {
			String newName = name.substring(0, name.lastIndexOf('.')) + "(" + i + ")" + name.substring(name.lastIndexOf('.'));
			savedFile = new File(dir, newName);
			i++;
		}

		try {
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
