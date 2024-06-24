package com.kh.app.adminEmp.dao;

import com.kh.app.adminEmp.mapper.AdminEmpMapper;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminEmpDao {

    private final AdminEmpMapper mapper;

    public List<AdminEmpVo> adminEmpList(int offset, int size) {
        return mapper.adminEmpList(offset, size);
    }

    public int getTotalCount() {
        return mapper.getTotalCount();
    }

    public AdminEmpVo adminEmpByNo(String no) {
        return mapper.adminEmpByNo(no);
    }

    public List<AdminEmpVo> adminEmpSearch(String empCategory, String searchBox, int offset, int size) {
        return mapper.adminEmpSearch(empCategory, searchBox, offset, size);
    }
}
