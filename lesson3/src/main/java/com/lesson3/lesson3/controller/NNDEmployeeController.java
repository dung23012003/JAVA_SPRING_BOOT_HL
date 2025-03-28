package com.lesson3.lesson3.controller;
import com.lesson3.lesson3.request.NNDEmployeeRequest;
import com.lesson3.lesson3.controller.NNDEmployeeController;
import com.lesson3.lesson3.service.NNDEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nnd-employee")
public class NNDEmployeeController {

    private final NNDEmployeeService nndEmployeeService;

    public NNDEmployeeController(NNDEmployeeService nndEmployeeService) {
        this.nndEmployeeService = nndEmployeeService;
    }

    @GetMapping("/")
    public List<NNDEmployeeRequest> getAllNndEmployeeRequestList() {
        return nndEmployeeService.getNndEmployeeList();
    }

    @PostMapping("/add")
    public void nndEmployeeAdd(@RequestBody NNDEmployeeRequest nndEmployeeRequest) {
        nndEmployeeService.nndEmployeeAdd(nndEmployeeRequest);
    }
}
