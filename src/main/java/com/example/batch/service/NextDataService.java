package com.example.batch.service;

import com.example.batch.entity.NextData;
import com.example.batch.entity.QNextData;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by whilemouse on 17. 8. 24.
 */
@Service
public class NextDataService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void create(NextData nextData){
        entityManager.persist(nextData);
    }

    public List<NextData> data() {
        QBean<NextData> bean = Projections.bean(NextData.class, QNextData.nextData.id, QNextData.nextData.name);
        List<NextData> list = new JPAQueryFactory(entityManager).select(bean).from(QNextData.nextData).fetch();
        return list;
    }

    /*// select
    public SampleModel get(String id) {
        log.debug("sample get id: {}", id);
        QSample qSample = QSample.sample;
        QBean<SampleModel> bean = Projections.bean(SampleModel.class, qSample.id, qSample.name);
        return new JPAQueryFactory(entityManager)
                .select(bean)
                .from(qSample)
                .where(qSample.id.eq(id))
                .fetchOne();
    }

    // insert
    @Transactional
    public void create(SampleModel sampleModel) {
        log.debug("sample create: {}", sampleModel);
        Sample sample = new Sample();
        sample.setName(sampleModel.getName());
        sample.setCreatedAt(new Date());
        List<String> extensions = sampleModel.getExtensions();
        if (extensions != null && !extensions.isEmpty()) {
            sample.setExtensions(Joiner.on(PIPE).join(extensions));
        }
        entityManager.persist(sample);
    }

    // update
    @Transactional
    public void update(String id, SampleModel sampleModel) {
        log.debug("sample update id: {}, sampleModel: {}", id, sampleModel);
        String extensionList = null;
        List<String> extensions = sampleModel.getExtensions();
        if (extensions != null && !extensions.isEmpty()) {
            extensionList = Joiner.on(PIPE).join(extensions);
        }

        QSample qSample = QSample.sample;
        new JPAUpdateClause(entityManager, qSample)
                .set(qSample.name, sampleModel.getName())
                .set(qSample.extensions, extensionList)
                .where(qSample.id.eq(id))
                .execute();
    }

    // delete
    @Transactional
    public void delete(String id) {
        log.debug("sample delete id: {}", id);
        QSample qSample = QSample.sample;
        new JPADeleteClause(entityManager, qSample)
                .where(qSample.id.eq(id))
                .execute();
    }*/

}
