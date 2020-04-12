package com.fs.mapper;

import com.fs.model.Audit;

public interface AuditMapper {
    int deleteByPrimaryKey(Integer auditId);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(Integer auditId);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);
}