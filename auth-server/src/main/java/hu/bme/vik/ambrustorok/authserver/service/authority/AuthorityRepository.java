//package hu.bme.vik.ambrustorok.authserver.service.authority;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.UUID;
//
//public interface AuthorityRepository extends JpaRepository<AuthorityEntity, UUID> {
//
//    VehicleClicksEntity findAllByVehicleIdAndUsername(UUID vehicleId, String username);
//
//    List<VehicleClicksEntity> findAllByUsername(String username);
//
//    List<VehicleClicksEntity> findAllByVehicleId(UUID vehicleId);
//
//}
