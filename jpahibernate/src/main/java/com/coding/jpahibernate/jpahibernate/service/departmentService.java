package com.coding.jpahibernate.jpahibernate.service;

import com.coding.jpahibernate.jpahibernate.Entities.departmentEntity;
import com.coding.jpahibernate.jpahibernate.dto.departmentDto;
import com.coding.jpahibernate.jpahibernate.exceptions.ResourceNotFoundException;
import com.coding.jpahibernate.jpahibernate.repo.departmentrepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class departmentService {
    private final departmentrepo repo;
    private final ModelMapper modelmapper;

    public departmentService(departmentrepo repo, ModelMapper modelmapper) {
        this.repo = repo;
        this.modelmapper = modelmapper;
    }


    public Optional<departmentDto> getDepartment(Long id){
        Optional<departmentEntity> entity=repo.findById(id);
        return entity.map(departmentEntity->modelmapper.map(departmentEntity,departmentDto.class));
    }
    public departmentDto addDepartment(departmentDto department){
         departmentEntity departmentdentity=modelmapper.map(department,departmentEntity.class);
        return modelmapper.map(repo.save(departmentdentity),departmentDto.class);
    }
    public List<departmentDto> getalldepartment(){
        List<departmentEntity> deps=repo.findAll();
        return  deps.stream()
                .map(departmentEntity->modelmapper.map(departmentEntity,departmentDto.class))
                .collect(Collectors.toList());
    }
    public void existsbyid(Long id) {
        if(!repo.existsById(id))
            throw new ResourceNotFoundException("department not found"+id);
    }
    public departmentDto updateDepartment(departmentDto departmentdto, Long id) {
        departmentEntity depEntity;

        // Check if the department with the given ID exists
            existsbyid(id);
            // Update existing entity
            depEntity = repo.findById(id).get(); // Fetch existing entity
            modelmapper.map(departmentdto, depEntity);
            depEntity.setCreatedAt(LocalDateTime.now());
            depEntity.setId(id); // Ensure ID is set


        // Save the entity and return DTO
        departmentEntity savedEntity = repo.save(depEntity);
        return modelmapper.map(savedEntity, departmentDto.class);
    }

    public Boolean deletebyid(Long id) {
            repo.existsById(id);
            repo.deleteById(id);
            return true;

    }

    public departmentDto patchDepartment(Map<String, Object> updates, Long id) {
        //Boolean exists=repo.existsById(id);
       // if(!exists){return  null;}
        existsbyid(id);
        departmentEntity depEntity=repo.findById(id).get();
        updates.forEach((field,value)->{
           Field fieldtobeupdated= ReflectionUtils.findRequiredField(departmentEntity.class,field);
            fieldtobeupdated.setAccessible(true);
            ReflectionUtils.setField(fieldtobeupdated,depEntity,value);
        });
 return modelmapper.map(repo.save(depEntity),departmentDto.class);
    }
}
