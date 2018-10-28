package com.thoughtworks.nho.service;

import com.thoughtworks.nho.dto.TrainingDTO;
import com.thoughtworks.nho.exception.AttributeCharTypeException;
import com.thoughtworks.nho.exception.AttributeEmptyException;
import com.thoughtworks.nho.exception.AttributeTooLongException;
import com.thoughtworks.nho.exception.TrainingExistingException;
import com.thoughtworks.nho.repository.TrainingRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class TrainingServiceTest {

    @InjectMocks
    @Resource
    TrainingService trainingService;

    @Mock
    TrainingRepo trainingRepo;

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenTrainingIsNull() throws AttributeCharTypeException, AttributeEmptyException, AttributeTooLongException, TrainingExistingException {
        trainingService.save(null);
    }

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = TrainingExistingException.class)
    public void shouldThrowTrainingExistingExceptionWhenTitleRepeat() throws AttributeCharTypeException, AttributeEmptyException, AttributeTooLongException, TrainingExistingException {
        TrainingDTO trainingDTO = TrainingDTO.builder().title("testTitle").description("testDescription").build();

        when(trainingRepo.findByTitle(trainingDTO.getTitle())).thenReturn(new ArrayList<>());

        trainingService.save(trainingDTO);
    }
}
