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
    collectionResourceRel = "externalData",
    path = "externalData"
)
public interface ExternalDataRepository
    extends PagingAndSortingRepository<ExternalData, String> {
    @Query(
        value = "select externalData " +
        "from ExternalData externalData " +
        "where(:collectionId is null or externalData.collectionId like %:collectionId%) and (:systemName is null or externalData.systemName like %:systemName%) and (:retrievedAt is null or externalData.retrievedAt = :retrievedAt)"
    )
    List<ExternalData> externalDataQueryHistory(
        String collectionId,
        String systemName,
        Date retrievedAt,
        Pageable pageable
    );
}
