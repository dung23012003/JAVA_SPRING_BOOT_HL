package com.lesson3.lesson3.service;

import com.lesson3.lesson3.request.NNDEmployeeRequest;
import com.lesson3.lesson3.service.NNDEmployeeService;
import com.lesson3.lesson3.mapper.NNDEmployeeMapper;
import com.lesson3.lesson3.entity.NNDEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NNDEmployeeService {

    private final NNDEmployeeMapper nndEmployeeMapper;
    private final List<NNDEmployee> nndEmployeeList;

    public NNDEmployeeService(NNDEmployeeMapper NNDEmployeeMapper) {
        this.nndEmployeeMapper = NNDEmployeeMapper;
        this.nndEmployeeList = new ArrayList<>();

        // Dữ liệu mẫu
        this.nndEmployeeList.add(new NNDEmployee(1, "Nguyễn Ngọc", "Dũng", 12.222f, "dung@gmail.com"));
        this.nndEmployeeList.add(new NNDEmployee(2, "Nguyễn Thị", "Dung", 20.2312f, "dungthi@gmail.com"));
    }

    public List<NNDEmployeeRequest> getNndEmployeeList() {
        return nndEmployeeList.stream()
                .map(nndEmployeeMapper::toNndEmployeeRequest)
                .collect(Collectors.toList());
    }

    public void nndEmployeeAdd(NNDEmployeeRequest nndEmployeeRequest) {
        NNDEmployee nndEmployee = nndEmployeeMapper.toNndEmployee(nndEmployeeRequest);
        nndEmployeeList.add(nndEmployee);
    }
}