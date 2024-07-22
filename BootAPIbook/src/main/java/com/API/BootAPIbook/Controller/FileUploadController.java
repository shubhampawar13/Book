package com.API.BootAPIbook.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	// this is called as handle;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile mfile) {
		System.out.println(mfile.getOriginalFilename());
		System.out.println(mfile.getSize());
		return ResponseEntity.ok("WorKing");
	}
}
