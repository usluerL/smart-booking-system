package com.byusluer.searchservice.infrastructure.query;

import com.byusluer.searchservice.infrastructure.persistance.entity.ReservationEntity;
import com.byusluer.searchservice.web.dto.ReservationSearchRequest;
import com.byusluer.searchservice.web.dto.SearchResultDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationSearchQueryBuilder {
    private final EntityManager entityManager;

    public List<SearchResultDto> execute(ReservationSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SearchResultDto> query = cb.createQuery(SearchResultDto.class);
        Root<ReservationEntity> root = query.from(ReservationEntity.class);

        return null;
    }
}
