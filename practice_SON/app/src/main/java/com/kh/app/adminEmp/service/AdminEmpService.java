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

    public int getTotalCount() {
        return dao.getTotalCount();
    }

    public AdminEmpVo adminEmpByNo(String no) {
        return dao.adminEmpByNo(no);
    }
}
