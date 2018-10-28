package com.thoughtworks.nho.api;

import com.thoughtworks.nho.api.response.ResponseDTO;
import com.thoughtworks.nho.dto.TrainingDTO;
import com.thoughtworks.nho.exception.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import com.thoughtworks.nho.exception.TrainingExistingException;
import com.thoughtworks.nho.service.TrainingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/training")
public class TrainingController {

    @Resource
    private TrainingService trainingService;


    @PostMapping
    public Object save(@RequestBody TrainingDTO trainingDTO) throws AttributeCharTypeException, AttributeEmptyException, AttributeTooLongException {
        try {
            trainingService.save(trainingDTO);
        } catch (TrainingExistingException e) {
            return new ResponseDTO(400, "TrainingExistingException", null);
        }
        return new ResponseDTO();
    }
}
