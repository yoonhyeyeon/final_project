package com.kh.app.adminDept.dao;

import com.kh.app.adminDept.mapper.AdminDeptMapper;
import com.kh.app.adminDept.vo.DivisionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminDeptDao {

    private final AdminDeptMapper mapper;

    public List<DivisionVo> adminDeptList(int offset, int size) {
        return mapper.adminDeptList(offset, size);
    }

    public int getTotalCount() {
        return mapper.getTotalCount();
    }

    public List<DivisionVo> adminDeptSearch(String empCategory, String searchBox, int offset, int size) {
        return mapper.adminDeptSearch(empCategory, searchBox, offset, size);
    }

    public List<DivisionVo> adminDeptSearchData(String empCategory, String searchBox, int offset, int size) {
        return mapper.adminDeptSearchData(empCategory, searchBox, offset, size);
    }

    public void enrollDiv(DivisionVo divisionVo) {
        mapper.enrollDiv(divisionVo);
    }

    public List<DivisionVo> enrollDivData(DivisionVo divisionVo) {
        return mapper.enrollDivData(divisionVo);
    }

    public String getDeptName(String deptCode) {
        return mapper.getDeptName(deptCode);
    }

    public DivisionVo getDivisionByCode(String code) {
        return mapper.getDivisionByCode(code);
    }

    public void updateDivision(DivisionVo divisionVo) {
        mapper.updateDivision(divisionVo);
    }

}
