package com.objis.demo;

import org.springframework.context.annotation.Bean;

import com.objis.demo.dao.EtudiantDao;
import com.objis.demo.service.EtudiantService;

public class EtudiantServiceConfig
{
	@Bean
	public static EtudiantService etudiantService()
	{
		return new EtudiantService(etudiantDao());
	}

	@Bean
	public static EtudiantDao etudiantDao()
	{
		return new EtudiantDao();
	}
}
