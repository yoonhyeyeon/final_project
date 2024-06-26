package com.kh.app.adminDept.service;

import com.kh.app.adminDept.dao.AdminDeptDao;
import com.kh.app.adminDept.vo.DivisionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminDeptService {

    private final AdminDeptDao dao;

    public List<DivisionVo> adminDeptList(int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminDeptList(offset, size);
    }

    public int getTotalCount() {
        return dao.getTotalCount();
    }

    public List<DivisionVo> adminDeptSearch(String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminDeptSearch(empCategory, searchBox, offset, size);
    }
}
