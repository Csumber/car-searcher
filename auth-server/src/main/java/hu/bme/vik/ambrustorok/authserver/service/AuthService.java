//package hu.bme.vik.ambrustorok.authserver.service;
//
//import hu.bme.vik.ambrustorok.authserver.service.user.SearchEntity;
//import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchRepository;
//import hu.bme.vik.ambrustorok.searchservice.searchdata.data.VehicleClickRepository;
//import hu.bme.vik.ambrustorok.searchservice.searchdata.data.VehicleClicksEntity;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class AuthService {
//
//    private final SearchRepository repository;
//    private final VehicleClickRepository vehicleClickRepository;
//
//    public int increaseClicks(UUID carId, String username) {
//        VehicleClicksEntity vehicleClicksEntity = vehicleClickRepository.findAllByVehicleIdAndUsername(carId, username);
//        if (vehicleClicksEntity == null) {
//            vehicleClicksEntity = new VehicleClicksEntity();
//            vehicleClicksEntity.setUsername(username);
//            vehicleClicksEntity.setVehicleId(carId);
//            vehicleClicksEntity.setClicks(0);
//        }
//        vehicleClicksEntity.setClicks(vehicleClicksEntity.getClicks() + 1);
//        vehicleClickRepository.save(vehicleClicksEntity);
//        return vehicleClicksEntity.getClicks();
//    }
//
//    public Map<String, Map<UUID, Integer>> findAllClicksByUser() {
//        List<VehicleClicksEntity> clicks = vehicleClickRepository.findAll();
//        Map<String, Map<UUID, Integer>> ret = new HashMap<>();
//        for (var v : clicks) {
//            if (!ret.containsKey(v.getUsername()))
//                ret.put(v.getUsername(), new HashMap<>());
//            ret.get(v.getUsername()).put(v.getVehicleId(), v.getClicks());
//        }
//
//        return ret;
//    }
//
//    public Map<UUID, Map<String, Integer>> findAllClicksByVehicle() {
//        List<VehicleClicksEntity> clicks = vehicleClickRepository.findAll();
//        Map<UUID, Map<String, Integer>> ret = new HashMap<>();
//        for (var v : clicks) {
//            if (!ret.containsKey(v.getVehicleId()))
//                ret.put(v.getVehicleId(), new HashMap<>());
//            ret.get(v.getUsername()).put(v.getUsername(), v.getClicks());
//        }
//
//        return ret;
//    }
//
//    public Map<UUID, Integer> findOneClickByUser(String username) {
//        List<VehicleClicksEntity> clicks = vehicleClickRepository.findAllByUsername(username);
//        Map<UUID, Integer> ret = new HashMap<>();
//        for (var v : clicks) {
//            ret.put(v.getVehicleId(), v.getClicks());
//        }
//
//        return ret;
//    }
//
//    public Map<String, Integer> findONeClickByVehicle(UUID id) {
//        List<VehicleClicksEntity> clicks = vehicleClickRepository.findAllByVehicleId(id);
//        Map<String, Integer> ret = new HashMap<>();
//        for (var v : clicks) {
//            ret.put(v.getUsername(), v.getClicks());
//        }
//
//        return ret;
//    }
//
//
//    public boolean isNumber(String attribute) {
//        return attribute.equalsIgnoreCase("lengthMin") ||
//                attribute.equalsIgnoreCase("lengthMax") ||
//                attribute.equalsIgnoreCase("numberOfDoorsMin") ||
//                attribute.equalsIgnoreCase("numberOfDoorsMax") ||
//                attribute.equalsIgnoreCase("priceMin") ||
//                attribute.equalsIgnoreCase("priceMax") ||
//                attribute.equalsIgnoreCase("warrantyMin") ||
//                attribute.equalsIgnoreCase("warrantyMax") ||
//                attribute.equalsIgnoreCase("weightMin") ||
//                attribute.equalsIgnoreCase("weightMax") ||
//                attribute.equalsIgnoreCase("widthMin") ||
//                attribute.equalsIgnoreCase("widthMax");
//    }
//
//    public boolean isText(String attribute) {
//        return attribute.equalsIgnoreCase("manufacturer") ||
//                attribute.equalsIgnoreCase("model");
//    }
//
//    public boolean isEnum(String attribute) {
//        return attribute.equalsIgnoreCase("style");
//    }
//
//    private double calculateAverage(List<?> numbers) {
//        // https://stackoverflow.com/questions/23278685/list-with-integers-casted-to-listdouble-why-is-that-possible
//        List<Double> list = (List<Double>) numbers;
//        if (list.isEmpty())
//            return 0;
//        double sum = 0;
//        for (var v : list)
//            sum += v;
//        return sum / list.size();
//    }
//
//    private Comparable calculateMode(List<Comparable> items) {
//        Collections.sort(items);
//
//        int maxFrequency = 0;
//        boolean modeFound = false;
//        Set<Integer> modeSet = new HashSet<>();
//        Comparable mode = null;
//        for (int i = 0; i < items.size(); i++) {
//            Comparable item = items.get(i);
//            int count = 1;
//            for (; (i + count) < items.size() && items.get(i + count) == item; count++) {
//            }
//            i += (count - 1);
//            if (maxFrequency != 0 && count != maxFrequency) {
//                modeFound = true;
//            }
//            if (count > maxFrequency) {
//                mode = item;
//                maxFrequency = count;
//            }
//        }
//        if (!modeFound) {
//            modeSet.clear();
//        }
//        return mode;
//    }
//
//    private Comparable calculateMedian(List<Comparable> items) {
//        Collections.sort(items);
//        return items.get(items.size() / 2);
//    }
//
//    public Map<String, ArrayList<Comparable>> getStatsticsByName(String attribute) {
//
//        Collection<SearchEntity> searches = repository.findAll();
//        HashMap<String, ArrayList<Comparable>> byUsername = new HashMap<>();
//
//        for (var v : searches)
//            byUsername.put(v.getUsername(), new ArrayList<>());
//        if (attribute.equalsIgnoreCase("lengthMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getLengthMin());
//        }
//        if (attribute.equalsIgnoreCase("lengthMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getLengthMax());
//        }
//        if (attribute.equalsIgnoreCase("numberOfDoorsMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getNumberOfDoorsMin());
//        }
//        if (attribute.equalsIgnoreCase("numberOfDoorsMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getNumberOfDoorsMax());
//        }
//        if (attribute.equalsIgnoreCase("priceMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getPriceMin());
//        }
//        if (attribute.equalsIgnoreCase("priceMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getPriceMax());
//        }
//        if (attribute.equalsIgnoreCase("warrantyMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWarrantyMin());
//        }
//        if (attribute.equalsIgnoreCase("warrantyMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWarrantyMax());
//        }
//        if (attribute.equalsIgnoreCase("weightMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWeightMin());
//        }
//        if (attribute.equalsIgnoreCase("weightMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWeightMax());
//        }
//        if (attribute.equalsIgnoreCase("widthMin")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWidthMin());
//        }
//        if (attribute.equalsIgnoreCase("widthMax")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getWidthMax());
//        }
//        if (attribute.equalsIgnoreCase("manufacturer")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getManufacturer());
//        }
//        if (attribute.equalsIgnoreCase("model")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getModel());
//        }
//        if (attribute.equalsIgnoreCase("style")) // itt lesz majd a switch vagy sumthing
//        {
//            for (var v : searches)
//                byUsername.get(v.getUsername()).add(v.getStyle());
//        }
//        return byUsername;
//    }
//
//    public Map<String, ?> getMin(String attribute) {
//        if (!isNumber(attribute))
//            return null;
//        Map<String, Comparable> sortedByUsername = new HashMap<>();
//        Map<String, ArrayList<Comparable>> byUsername = getStatsticsByName(attribute);
//        if (byUsername == null)
//            return null;
//        for (var vv : byUsername.entrySet())
//            sortedByUsername.put(vv.getKey(), Collections.min(vv.getValue()));
//
//        return sortedByUsername;
//    }
//
//    public Map<String, ?> getMax(String attribute) {
//        if (!isNumber(attribute))
//            return null;
//        Map<String, Comparable> sortedByUsername = new HashMap<>();
//        Map<String, ArrayList<Comparable>> byUsername = getStatsticsByName(attribute);
//        if (byUsername == null)
//            return null;
//        for (var vv : byUsername.entrySet())
//            sortedByUsername.put(vv.getKey(), Collections.max(vv.getValue()));
//
//        return sortedByUsername;
//    }
//
//    public Map<String, ?> getAverage(String attribute) {
//        if (!isNumber(attribute))
//            return null;
//        Map<String, Comparable> sortedByUsername = new HashMap<>();
//        Map<String, ArrayList<Comparable>> byUsername = getStatsticsByName(attribute);
//        if (byUsername == null)
//            return null;
//        for (var vv : byUsername.entrySet())
//            sortedByUsername.put(vv.getKey(), calculateAverage(vv.getValue()));
//
//        return sortedByUsername;
//    }
//
//    public Map<String, ?> getMode(String attribute) {
//        Map<String, Comparable> sortedByUsername = new HashMap<>();
//        Map<String, ArrayList<Comparable>> byUsername = getStatsticsByName(attribute);
//        if (byUsername == null)
//            return null;
//        for (var vv : byUsername.entrySet())
//            sortedByUsername.put(vv.getKey(), calculateMode(vv.getValue()));
//
//        return sortedByUsername;
//    }
//
//    public Map<String, ?> getMedian(String attribute) {
//        Map<String, Comparable> sortedByUsername = new HashMap<>();
//        Map<String, ArrayList<Comparable>> byUsername = getStatsticsByName(attribute);
//        if (byUsername == null)
//            return null;
//        for (var vv : byUsername.entrySet())
//            sortedByUsername.put(vv.getKey(), calculateMedian(vv.getValue()));
//
//        return sortedByUsername;
//    }
//}
