package com.kh.app.adminEmp.service;

import com.kh.app.adminEmp.dao.AdminEmpDao;
import com.kh.app.adminEmp.vo.AdminEmpVo;
import com.kh.app.adminEmp.vo.DivisionVo;
import com.kh.app.adminEmp.vo.PositionVo;
import com.kh.app.exception.EmpJoinExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

    public void adminEmpEnrollData(AdminEmpVo vo) {
        validateEmpData(vo);
        dao.adminEmpEnrollData(vo);
    }

    private void validateEmpData(AdminEmpVo vo) {
        if (dao.existsById(vo.getId())) {
            throw new EmpJoinExceptions.IdAlreadyExistsException("이미 사용 중인 아이디입니다.");
        }

        if (!vo.getId().matches("^[a-zA-Z0-9]{4,12}$")) {
            throw new EmpJoinExceptions.InvalidIdFormatException("아이디는 4~12자의 영어 또는 숫자만 가능합니다.");
        }

        if (!vo.getPwd().matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$")) {
            throw new EmpJoinExceptions.WeakPasswordException("비밀번호는 8~20자이고 영문, 숫자, 특수문자를 포함해야 합니다.");
        }

        if (!vo.getPwd().equals(vo.getPwdCheck())) {
            throw new EmpJoinExceptions.PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        if (dao.existsByNick(vo.getNick())) {
            throw new EmpJoinExceptions.NicknameAlreadyExistsException("이미 사용 중인 닉네임입니다.");
        }

        if (vo.getNick().matches(".*(admin|ADMIN).*")) {
            throw new EmpJoinExceptions.InvalidNicknameFormatException("닉네임에 'admin'을 포함할 수 없습니다.");
        }
    }

    public Map<String, Object> adminEmpByNoData(AdminEmpVo vo) {
        return dao.adminEmpByNoData(vo);
    }

    public List<DivisionVo> getDivCode(String no) {
        return dao.getDivCode(no);
    }

    public AdminEmpVo getEmployeeDetail(String no) {
        return dao.selectEmployeeByNo(no);
    }

    public int updateEmployee(AdminEmpVo vo) {
        return  dao.updateEmployee(vo);
    }

    public Boolean existsById(String id) {
        return dao.existsById(id);
    }
}
