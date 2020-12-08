//package hu.bme.vik.ambrustorok.authserver.service.user;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.UUID;
//
//public interface UserRepository extends JpaRepository<VehicleClicksEntity, UUID> {
//
//    VehicleClicksEntity findAllByVehicleIdAndUsername(UUID vehicleId, String username);
//
//    List<VehicleClicksEntity> findAllByUsername(String username);
//
//    List<VehicleClicksEntity> findAllByVehicleId(UUID vehicleId);
//
//}
