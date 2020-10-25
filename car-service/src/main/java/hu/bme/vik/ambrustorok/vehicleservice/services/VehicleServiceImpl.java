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
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Collections;
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
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<String> getAllManufacturers() {

        List<String> list = mongoTemplate.findDistinct("manufacturer", Vehicle.class, String.class);

        return list;
    }

    @Override
    public List<String> getAllModels(String manufacturer) {

        Criteria criteria = Criteria.where("manufacturer").is(manufacturer);
        Query query = new Query();
        query.addCriteria(criteria);
        query.fields().include("model").include("manufacturer").exclude("_id");
        List<VehicleModel> list = mongoTemplate.find(query, VehicleModel.class, "vehicles");

        return list.stream().map(vehiclemodel -> vehiclemodel.getModel()).distinct().collect(Collectors.toList());

    }

    @Override
    public List<Option> getAllOptions(String manufacturer, String model) {
        return null;

    }

    @Override
    public List<SearchResult> search(SearchRequest searchRequest) {
        return null;
    }


    @Override
    public List<OptionResponse> getAllOptions() {
//        Query query = new Query();
//        query.fields().include("options").exclude("_id");
//        List<Option> list = mongoTemplate.find(query, Option.class);
//
//        return list.stream().map(option -> new OptionResponse(option.getName(), option.getValue())).collect(Collectors.toList());


      /*  Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("options")
        );
        AggregationResults<Option> results = mongoTemplate.aggregate(aggregation,
                "vehicles", Option.class);

        List<Option> list  = results.getMappedResults();


        return list;//list.stream().map(option -> new OptionResponse(option.getName(), option.getValue())).collect(Collectors.toList());*/

        Query query = new Query();
        query.fields().include("options").exclude("_id");
        List<Vehicle> list = mongoTemplate.findAll(Vehicle.class);

        List<Set<Option>> asd = list.stream().map(Vehicle::getOptions).collect(Collectors.toList());
        List<OptionResponse> options = asd.stream().flatMap(Set::stream).map(option -> new OptionResponse(option.getName(), option.getValue())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<EngineResponse> getAllEngines() {

        Query query = new Query();
        query.fields().include("engines").exclude("_id");
        List<Vehicle> list = mongoTemplate.findAll(Vehicle.class);

        List<Set<Engine>> asd = list.stream().map(Vehicle::getEngines).collect(Collectors.toList());
        List<EngineResponse> options = asd.stream().flatMap(Set::stream).map(engine -> new EngineResponse(engine.getHorsepower(), engine.getFuel(), engine.getTransmission(), engine.getAverage_consumption(), engine.getCylinder_capacity(), engine.getPrice())).collect(Collectors.toList());

        return options.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getallVehicles() {
        return mongoTemplate.findAll(Vehicle.class);
    }
}
