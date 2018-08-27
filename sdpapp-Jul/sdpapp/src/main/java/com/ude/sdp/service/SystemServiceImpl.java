package com.ude.sdp.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ude.sdp.FileNotFoundException;
import com.ude.sdp.FileStorageProperties;
import com.ude.sdp.controller.LoginController;
import com.ude.sdp.dto.FileDTO;
import com.ude.sdp.dto.ResultDTO;
import com.ude.sdp.dto.UserAuthDTO;
import com.ude.sdp.dto.UserDTO;
import com.ude.sdp.model.FileDB;
import com.ude.sdp.model.Role;
import com.ude.sdp.model.User;
import com.ude.sdp.repository.FileRepository;
import com.ude.sdp.repository.UserRepository;

@Service
public class SystemServiceImpl implements SystemService {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserRepository repositoy;

	@Autowired
	FileRepository fileRepository;
	

	@Autowired
	@Qualifier("javaMailSender")
	public MailSender mailSender;

	@Autowired
	FileStorageProperties fileStorageProperties;

	private static final Random random = new Random();
	private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";
	private Path fileStorageLocation;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@PostConstruct
	public void init() {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	
}
