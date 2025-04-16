package com.byusluer.searchservice.domain.usecase;

import java.util.List;

public interface SearchUseCase<IN, OUT> {
    List<OUT> search(IN request);
}
