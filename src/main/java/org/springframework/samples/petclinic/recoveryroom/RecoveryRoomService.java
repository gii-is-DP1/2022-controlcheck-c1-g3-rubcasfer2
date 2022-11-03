package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RecoveryRoomService {
    RecoveryRoomRepository repo;
    @Autowired
    public RecoveryRoomService (RecoveryRoomRepository repo){
        this.repo = repo;
    }
    @Transactional(readOnly=true)
    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }
    @Transactional(readOnly=true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return repo.save(p);       
    }

    
}
