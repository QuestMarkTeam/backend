package com.example.cluvrapi.domain.common.repository;


import com.example.cluvrapi.global.exception.BusinessException;
import com.example.cluvrapi.global.response.ResponseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

    default T findByIdOrElseThrow(ID id) {
        return findById(id).orElseThrow(() ->
            new BusinessException(ResponseCode.NOT_FOUND, "해당 Entity를 찾을 수 없습니다. id = " + id)
        );
    }

}