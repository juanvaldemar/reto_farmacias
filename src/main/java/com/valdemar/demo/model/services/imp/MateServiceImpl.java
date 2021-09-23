package com.valdemar.demo.model.services.imp;

import com.valdemar.demo.model.dao.MateDao;
import com.valdemar.demo.model.entity.Mate;
import com.valdemar.demo.model.services.MateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Service
public class MateServiceImpl implements MateService {

    final static Logger logger = Logger.getLogger(String.valueOf(MateServiceImpl.class));

    @Autowired
    private MateDao mateDao;

    @Override
    public Mono<Mate> save(Mate mate) {
            logger.info("log save mate");
            return mateDao.save(mate);
    }



    @Override
    public Flux<Mate> saveAll(Flux<Mate> prostituta) {
        logger.info("log saveAll");
        return mateDao.saveAll(prostituta);
    }

    @Override
    public Flux<Mate> findAll() {
        logger.info("log findAll");
        return mateDao.findAll();
    }

    @Override
    public Mono<Mate> findById(String request) {
        logger.info("log findById");
        return mateDao.findById(request);
    }
}
