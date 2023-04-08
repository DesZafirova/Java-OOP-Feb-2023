package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if(type.equals("MainService")){
            service = new MainService(name);
        } else if (type.equals("SecondaryService")){
            service = new SecondaryService(name);
        }else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if(type.equals("PlasticArmor")){
            supplement = new PlasticArmor();
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        }else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName))
                .findFirst().orElse(null);
        Supplement supplement = supplements.findFirst(supplementType);
       if(supplement == null){
           throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
       }
        this.supplements.removeSupplement(supplement);
       service.addSupplement(supplement);


        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName))
                .findFirst().orElse(null);
        Robot robot;
        if(robotType.equals("MaleRobot")){
            robot = new MaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        }else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        String output;
        if((service.getClass().getSimpleName().equals("MainService") && !robotType.equals("MaleRobot"))
        || (service.getClass().getSimpleName().equals("SecondaryService") && !robotType.equals("FemaleRobot"))){
            output = UNSUITABLE_SERVICE;
        }else {
            service.addRobot(robot);
            output = String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        }
        return output;
    }

    @Override
    public String feedingRobot(String serviceName) {
       Service service = this.services.stream().filter(s -> s.getName().equals(serviceName))
                .findFirst().orElse(null);
       service.feeding();
        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName))
                .findFirst().orElse(null);
        double sumFromRobots = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double sumFromSupplements = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        return String.format(VALUE_SERVICE, serviceName, sumFromRobots + sumFromSupplements);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Service service : services) {
            stringBuilder.append(service.getStatistics()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
