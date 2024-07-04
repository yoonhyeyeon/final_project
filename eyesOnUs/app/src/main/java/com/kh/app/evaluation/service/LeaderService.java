package com.kh.app.evaluation.service;

import com.kh.app.evaluation.dao.LeaderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LeaderService {

    private final LeaderDao dao;

}
