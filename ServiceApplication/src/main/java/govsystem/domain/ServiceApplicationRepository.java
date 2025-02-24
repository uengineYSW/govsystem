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
    collectionResourceRel = "serviceApplications",
    path = "serviceApplications"
)
public interface ServiceApplicationRepository
    extends PagingAndSortingRepository<ServiceApplication, String> {
    @Query(
        value = "select serviceApplication " +
        "from ServiceApplication serviceApplication " +
        "where(:applicationId is null or serviceApplication.applicationId like %:applicationId%) and (:progressStatus is null or serviceApplication.progressStatus = :progressStatus)"
    )
    List<ServiceApplication> serviceApplicationStatus(
        String applicationId,
        ProgressStatus progressStatus,
        Pageable pageable
    );

    @Query(
        value = "select serviceApplication " +
        "from ServiceApplication serviceApplication " +
        "where(:userId is null or serviceApplication.userId like %:userId%)"
    )
    ServiceApplication serviceApplicationDraft(String userId);

    @Query(
        value = "select serviceApplication " +
        "from ServiceApplication serviceApplication " +
        "where(:applicationId is null or serviceApplication.applicationId like %:applicationId%)"
    )
    ServiceApplication serviceApplicationFormMapping(String applicationId);
}
