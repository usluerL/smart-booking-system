package com.byusluer.searchservice.application;

import com.byusluer.searchservice.domain.usecase.SearchReservationUseCase;
import com.byusluer.searchservice.infrastructure.query.ReservationSearchQueryBuilder;
import com.byusluer.searchservice.web.dto.ReservationSearchRequest;
import com.byusluer.searchservice.web.dto.SearchResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchReservationService implements SearchReservationUseCase {
    private final ReservationSearchQueryBuilder reservationQueryBuilder;
    @Override
    public List<SearchResultDto> search(ReservationSearchRequest request) {

        return reservationQueryBuilder.execute(request);
    }
}
