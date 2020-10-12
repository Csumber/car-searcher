package bme.vik.ambrustorok.vehicleservice.services;

import bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> listAll() {
        return null;
    }

    @Override
    public Vehicle getById(String id) {
        return null;
    }

    @Override
    public Vehicle saveOrUpdate(Vehicle product) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<String> getAllManufacturers() {


        ProjectionOperation projectionOperation = Aggregation.project("manufacturer").andExclude("_id");
        Aggregation aggregation = Aggregation.newAggregation(projectionOperation);

        AggregationResults<String> list = mongoTemplate.aggregate(aggregation, Vehicle.class, String.class);

        return list.getMappedResults();
    }

    @Override
    public List<String> getAllModels(String manufacturer) {

        ProjectionOperation projectionOperation = Aggregation.project("manufacturer").andExclude("_id");
        Aggregation aggregation = Aggregation.newAggregation(projectionOperation);

        AggregationResults<String> list = mongoTemplate.aggregate(aggregation, Vehicle.class, String.class);

        return list.getMappedResults();
    }

    @Override
    public List<String> search(SearchRequest searchRequest) {
        return null;
    }
}
