package govsystem.domain;

import govsystem.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "eligibilityChecks",
    path = "eligibilityChecks"
)
public interface EligibilityCheckRepository
    extends PagingAndSortingRepository<EligibilityCheck, String> {
    @Query(
        value = "select eligibilityCheck " +
        "from EligibilityCheck eligibilityCheck " +
        "where(:applicantId is null or eligibilityCheck.applicantId like %:applicantId%)"
    )
    List<EligibilityCheck> eligibilityInquiryHistory(
        String applicantId,
        Pageable pageable
    );
}
