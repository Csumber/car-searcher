package hu.bme.vik.ambrustorok.vehicleservice.services;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.OptionResponse;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.VehicleModel;
import hu.bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    VehicleRepository vehicleRepository;

    // <========================================================

    @Override
    public List<String> getManufacturers() {

        List<String> list = mongoTemplate.findDistinct("manufacturer", Vehicle.class, String.class);
        return list;
    }

    @Override
    public List<String> getModelsOfManufacturer(String manufacturer) {

        Criteria criteria = Criteria.where("manufacturer").is(manufacturer);
        Query query = new Query();
        query.addCriteria(criteria);
        query.fields().include("model").include("manufacturer").exclude("_id");
        List<VehicleModel> list = mongoTemplate.find(query, VehicleModel.class, "vehicles");

        return list.stream().map(vehiclemodel -> vehiclemodel.getModel()).distinct().collect(Collectors.toList());
    }

    // <========================================================

    @Override
    public List<OptionResponse> getOptions() {

        Query query = new Query();
        query.fields().include("options").exclude("_id");
        List<Vehicle> list = mongoTemplate.findAll(Vehicle.class);

        List<Set<Option>> asd = list.stream().map(Vehicle::getOptions).collect(Collectors.toList());
        List<OptionResponse> options = asd.stream().flatMap(Set::stream).map(option -> new OptionResponse(option.getName(), option.getValue())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<OptionResponse> getManufacturerOptions(String manufacturer) {
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer);
        Query query = new Query();
        query.addCriteria(criteria);
        query.fields().include("model").include("manufacturer").include("options").exclude("_id");
        List<Vehicle> list = mongoTemplate.find(query, Vehicle.class);

        List<Set<Option>> asd = list.stream().map(Vehicle::getOptions).collect(Collectors.toList());
        return asd.stream().flatMap(Set::stream).map(option -> new OptionResponse(option.getName(), option.getValue())).distinct().collect(Collectors.toList());
    }

    @Override
    public List<OptionResponse> getModelOptions(String manufacturer, String model) {
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer).and("model").is(model);
        Query query = new Query();
        query.addCriteria(criteria);
        query.fields().include("model").include("manufacturer").include("options").exclude("_id");
        List<Vehicle> list = mongoTemplate.find(query, Vehicle.class);

        List<Set<Option>> asd = list.stream().map(Vehicle::getOptions).collect(Collectors.toList());
        return asd.stream().flatMap(Set::stream).map(option -> new OptionResponse(option.getName(), option.getValue())).distinct().collect(Collectors.toList());
    }

    // <========================================================

    @Override
    public List<Vehicle> getVehicles() {
        return mongoTemplate.findAll(Vehicle.class);
    }

    public List<Vehicle> getManufacturerVehicles(String manufacturer) {
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer);
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Vehicle.class);
    }

    public List<Vehicle> getModelVehicles(String manufacturer, String model) {
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer).and("model").is(model);
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Vehicle.class);
    }

    // <========================================================

    @Override
    public List<EngineResponse> getEngines() {

        Query query = new Query();
        query.fields().include("engines").exclude("_id");
        List<Vehicle> list = mongoTemplate.findAll(Vehicle.class);

        List<Set<Engine>> asd = list.stream().map(Vehicle::getEngines).collect(Collectors.toList());
        List<EngineResponse> options = asd.stream().flatMap(Set::stream).map(engine -> new EngineResponse(engine.getHorsepower(), engine.getFuel(), engine.getTransmission(), engine.getAverage_consumption(), engine.getCylinder_capacity(), engine.getPrice())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<EngineResponse> getManufacturerEngines(String manufacturer) {

        Query query = new Query();
        query.fields().include("engines").exclude("_id");
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer);
        query.addCriteria(criteria);

        List<Vehicle> list = mongoTemplate.find(query, Vehicle.class);
        List<Set<Engine>> asd = list.stream().map(Vehicle::getEngines).collect(Collectors.toList());
        List<EngineResponse> options = asd.stream().flatMap(Set::stream).map(engine -> new EngineResponse(engine.getHorsepower(), engine.getFuel(), engine.getTransmission(), engine.getAverage_consumption(), engine.getCylinder_capacity(), engine.getPrice())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<EngineResponse> getModelEngines(String manufacturer, String model) {

        Query query = new Query();
        query.fields().include("engines").exclude("_id");
        Criteria criteria = Criteria.where("manufacturer").is(manufacturer).and("model").is(model);
        query.addCriteria(criteria);

        List<Vehicle> list = mongoTemplate.find(query, Vehicle.class);
        List<Set<Engine>> asd = list.stream().map(Vehicle::getEngines).collect(Collectors.toList());
        List<EngineResponse> options = asd.stream().flatMap(Set::stream).map(engine -> new EngineResponse(engine.getHorsepower(), engine.getFuel(), engine.getTransmission(), engine.getAverage_consumption(), engine.getCylinder_capacity(), engine.getPrice())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }


    @Override
    public List<SearchResult> search(SearchRequest searchRequest) {
        //TODO ASAP
        return null;
    }

    @Override
    public Vehicle getById(String id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.get();
    }

    @Override
    public Vehicle saveOrUpdate(Vehicle vehicle) {
        return null;
    }

    @Override
    public void delete(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query();
        query.addCriteria(criteria);
        mongoTemplate.findAndRemove(query, Vehicle.class);
    }

    @Override
    public void delete(Vehicle vehicle) {
        Criteria criteria = Criteria.where("_id").is(vehicle.getId());
        Query query = new Query();
        query.addCriteria(criteria);
        mongoTemplate.findAndRemove(query, Vehicle.class);
    }

}
