package com.thoughtworks.nho.service;

import com.thoughtworks.nho.domain.Training;
import com.thoughtworks.nho.dto.TrainingDTO;
import com.thoughtworks.nho.exception.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import com.thoughtworks.nho.exception.TrainingExistingException;
import com.thoughtworks.nho.repository.TrainingRepo;
import com.thoughtworks.nho.service.verifier.TrainingVerifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TrainingService {
    @Resource
    private TrainingRepo trainingRepo;


    public void save(TrainingDTO trainingDTO) throws AttributeEmptyException, AttributeTooLongException, AttributeCharTypeException, TrainingExistingException {
        if (null == trainingDTO) throw new NullPointerException();

        TrainingVerifier.verifyTitle(trainingDTO.getTitle());
        TrainingVerifier.verifyDescription(trainingDTO.getDescription());

        if (!trainingRepo.findByTitle(trainingDTO.getTitle()).isEmpty()) throw new TrainingExistingException();

        trainingRepo.save(new Training(trainingDTO.getTitle(), trainingDTO.getDescription()));
    }
}
