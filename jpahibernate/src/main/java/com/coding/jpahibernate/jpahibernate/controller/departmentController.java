package com.coding.jpahibernate.jpahibernate.controller;

import com.coding.jpahibernate.jpahibernate.Entities.departmentEntity;
import com.coding.jpahibernate.jpahibernate.dto.departmentDto;
import com.coding.jpahibernate.jpahibernate.exceptions.ResourceNotFoundException;
import com.coding.jpahibernate.jpahibernate.service.departmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/department")
@RestController
public class departmentController {
    private final departmentService departmentservice;

    public departmentController(departmentService departmentservice) {
        this.departmentservice = departmentservice;
    }

    @GetMapping("/{depid}")
    public ResponseEntity<departmentDto> department(@PathVariable(name = "depid" ) Long id) {
        Optional<departmentDto> dep=departmentservice.getDepartment(id);
        return dep.
                map(departmentDto->ResponseEntity.ok(departmentDto)).
              //orElse(ResponseEntity.notFound().build()); //not requires supplier
        orElseThrow(()->new ResourceNotFoundException("department not found"));

    }
    @GetMapping("/all")
    public ResponseEntity<List<departmentDto>> all(){
        return ResponseEntity.ok(departmentservice.getalldepartment());
    }
    @PostMapping("/add")
    public ResponseEntity<departmentDto> add(@RequestBody @Valid departmentDto departmentdto){
        departmentDto dep= departmentservice.addDepartment(departmentdto);
        return  new ResponseEntity<>(dep, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<departmentDto> update(@RequestBody departmentDto departmentdto,@PathVariable(name = "id") Long id){
      //  Optional<departmentDto> dep=departmentservice.getDepartment(id);
        return ResponseEntity.ok(departmentservice.updateDepartment(departmentdto,id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Long id){
        Boolean gotdeleted=departmentservice.deletebyid(id);
        if(gotdeleted){
            return ResponseEntity.ok(true);}
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<departmentDto> update(@RequestBody Map<String, Object> depdto, @PathVariable(name = "id") Long id) {
         departmentDto dto=departmentservice.patchDepartment(depdto,id);
         if(dto==null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(dto);
    }




}
