package com.byusluer.searchservice.application;

import com.byusluer.searchservice.infrastructure.persistance.entity.SearchEntry;
import com.byusluer.searchservice.infrastructure.persistance.repository.SearchEntryRepository;
import com.byusluer.searchservice.infrastructure.persistance.spesification.SearchEntrySpecification;
import com.byusluer.searchservice.web.dto.SearchEntryFilterRequest;
import com.byusluer.searchservice.web.dto.SearchResultDto;
import com.byusluer.searchservice.web.mapper.SearchEntryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchEntryService {

    private final SearchEntryRepository searchEntryRepository;


    public Page<SearchResultDto> search(SearchEntryFilterRequest request) {
        Specification<SearchEntry> spec = SearchEntrySpecification.build(request);

        Pageable pageable = PageRequest.of(
                request.getPage(),
                request.getSize(),
                Sort.by(Sort.Direction.fromString(request.getDirection()), request.getSortBy())
        );

        var entries = searchEntryRepository.findAll(spec, pageable);
        return entries.map(SearchEntryMapper::toDto);

    }
}
