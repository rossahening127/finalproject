/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.Employee_;
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.ReligionRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class ReligionService {

    @Autowired
    private ReligionRepository rs;

    public Iterable<Religion> findAllReligion() { //fungsi findAllActor ntar bisa dipanggil
        return rs.findAll();
    }

    public List<Religion> getAll() {
        return rs.getAll();
    }

//    public String updateIsDelete(String id, String isDelete) {
//        return rs.updateIsDelete(id,isDelete);
//    }
//    public String softDelete() {
//           return rs.softDelete(String id);
//    }
    
//    public void softDelete(Religion id){
//        rs.softDelete(id);
//    }
    
    
//	public String softDelete(String id) {
//		return rs.softDelete(id);
//	}
            

}
