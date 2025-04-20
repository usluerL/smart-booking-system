package com.byusluer.searchservice.infrastructure.persistance.spesification;

import com.byusluer.searchservice.infrastructure.persistance.entity.SearchEntry;
import com.byusluer.searchservice.web.dto.SearchEntryFilterRequest;
import org.springframework.data.jpa.domain.Specification;

public class SearchEntrySpecification {

    public static Specification<SearchEntry> build(SearchEntryFilterRequest request){

        return Specification.where(cityEquals(request.getCity()))
                .and(starEquals(request.getStar()))
                .and(roomTypeEquals(request.getRoomType()))
                .and(reservationStatusEquals(request.getReservationStatus()));

    }

    private static Specification<SearchEntry> cityEquals(String city) {
        return (root, query, cb) -> city == null ? null : cb.equal(root.get("city"), city);
    }

    private static Specification<SearchEntry> starEquals(Integer star) {
        return (root, query, cb) -> star == null ? null : cb.equal(root.get("star"), star);
    }

    private static Specification<SearchEntry> roomTypeEquals(String roomType) {
        return (root, query, cb) -> roomType == null ? null : cb.equal(root.get("roomType"), roomType);
    }

    private static Specification<SearchEntry> reservationStatusEquals(String reservationStatus) {
        return (root, query, cb) -> reservationStatus == null ? null : cb.equal(root.get("reservationStatus"), reservationStatus);
    }

}
