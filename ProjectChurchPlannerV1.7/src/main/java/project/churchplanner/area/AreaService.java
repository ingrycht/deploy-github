/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.churchplanner.area;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.churchplanner.activity.Activity;
import project.churchplanner.activity.ActivityRepository;

/**
 *
 * @author Ingrycht Antunes
 */

@Service
public class AreaService {
    
    @Autowired
    private AreaRepository areaRepo;
    
    public List<Area> listAll(){
        return areaRepo.findAll();
    }
    
    public void save(Area area){
        areaRepo.save(area);
    }
    
    public Area get(Integer areaID){
        return areaRepo.findById(areaID).get();
    }
    
    public void delete(Integer areaID){
        areaRepo.deleteById(areaID);
    }
    
}
