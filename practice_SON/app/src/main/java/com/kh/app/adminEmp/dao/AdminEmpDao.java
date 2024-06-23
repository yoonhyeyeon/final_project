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

    public List<AdminEmpVo> adminEmpList() {
        return mapper.adminEmpList();
    }
}
