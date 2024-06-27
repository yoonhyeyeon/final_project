package com.kh.app.adminEmp.service;

import com.kh.app.adminEmp.dao.AdminEmpDao;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminEmpService {

    private final AdminEmpDao dao;

    public List<AdminEmpVo> adminEmpList(int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminEmpList(offset, size);
    }

    public List<AdminEmpVo> adminEmpListData(int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminEmpListData(offset, size);
    }

    public int getTotalCount() {
        return dao.getTotalCount();
    }

    public int getSearchTotalCount(String empCategory, String searchBox) {
        return dao.getSearchTotalCount(empCategory, searchBox);
    }

    public AdminEmpVo adminEmpByNo(String no) {
        return dao.adminEmpByNo(no);
    }

    public List<AdminEmpVo> adminEmpSearch(String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminEmpSearch(empCategory, searchBox, offset, size);
    }

    public List<AdminEmpVo> adminEmpSearchData(String empCategory, String searchBox, int page, int size) {
        int offset = (page - 1) * size;
        return dao.adminEmpSearchData(empCategory, searchBox, offset, size);
    }

}
