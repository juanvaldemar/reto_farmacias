package com.valdemar.demo.model.dao;

import com.valdemar.demo.model.entity.Mate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MateDao extends R2dbcRepository<Mate,String> {

}
