package com.fs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.mapper.LogMapper;
import com.fs.service.LogService;

/**
 * @author Mr-Yang
 *
 */

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;
	
	//------------------------------------------------下面写逻辑代码--------------------------------------------------------

}
