package com.kh.app.adminEmp.dao;

import com.kh.app.adminEmp.mapper.AdminEmpMapper;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import com.kh.app.adminEmp.vo.DivisionVo;
import com.kh.app.adminEmp.vo.PositionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AdminEmpDao {

    private final AdminEmpMapper mapper;

    public List<AdminEmpVo> adminEmpList(int offset, int size) {
        return mapper.adminEmpList(offset, size);
    }

    public List<AdminEmpVo> adminEmpListData(int offset, int size) {
        return mapper.adminEmpListData(offset, size);
    }

    public int getTotalCount() {
        return mapper.getTotalCount();
    }

    public int getSearchTotalCount(String empCategory, String searchBox) {
        return mapper.getSearchTotalCount(empCategory, searchBox);
    }

    public AdminEmpVo adminEmpByNo(String no) {
        return mapper.adminEmpByNo(no);
    }

    public List<AdminEmpVo> adminEmpSearch(String empCategory, String searchBox, int offset, int size) {
        return mapper.adminEmpSearch(empCategory, searchBox, offset, size);
    }

    public List<AdminEmpVo> adminEmpSearchData(String empCategory, String searchBox, int offset, int size) {
        return mapper.adminEmpSearchData(empCategory, searchBox, offset, size);
    }


    public void adminEmpEnrollData(AdminEmpVo vo) {
        mapper.adminEmpEnrollData(vo);
    }

    public Map<String, Object> adminEmpByNoData(AdminEmpVo vo) {
        return mapper.adminEmpByNoData(vo);
    }

    public List<DivisionVo> getDivCode(String no) {
        return mapper.getDivCode(no);
    }

    public AdminEmpVo selectEmployeeByNo(String no) {
        return mapper.selectEmployeeByNo(no);
    }

    public int updateEmployee(AdminEmpVo vo) {
        return mapper.updateEmployee(vo);
    }
}
