package com.gd.sakila2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.sakila2.mapper.CountryMapper;
import com.gd.sakila2.vo.Country;
import com.gd.sakila2.vo.Page;

@Service
@Transactional
public class CountryService {
	@Autowired 
	private CountryMapper countryMapper;
	public Map<String, Object> getCountryList(int currentPage, int rowPerPage) {
		// 1. 컨트롤러에서 보내어준 매개값을 가공....
		int beginRow = (currentPage-1) * rowPerPage;
		Page pageParam = new Page();
		pageParam.setBeginRow(beginRow);
		pageParam.setRowPerPage(rowPerPage);
		
		// 2. dao 호출
		List<Country> list = countryMapper.selectCountryList(pageParam);
		int total = countryMapper.selectCountryTotal();
		// 3. dao의 반환값을 가공
		int lastPage = total / rowPerPage;
		if(total % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("lastPage", lastPage);
		return map;
	}
}