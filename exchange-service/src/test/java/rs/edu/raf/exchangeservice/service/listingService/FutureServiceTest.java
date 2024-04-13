package rs.edu.raf.exchangeservice.service.listingService;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import rs.edu.raf.exchangeservice.domain.dto.FutureDto;
import rs.edu.raf.exchangeservice.domain.model.listing.Future;
import rs.edu.raf.exchangeservice.repository.listingRepository.FutureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest

class FutureServiceTest {

    @Mock
    private FutureRepository futureRepository;

    @InjectMocks
    private FutureService futureService;

    @Test
    public void testFindAll() {
        List<Future> expectedFutures = new ArrayList<>();
        when(futureRepository.findAll()).thenReturn(expectedFutures);

        List<Future> actualFutures = futureService.findAll();

        assertEquals(expectedFutures, actualFutures);
    }

    @Test
    public void testFindByContractName_ExistingName() {
        String contractName = "TestFuture";
        Future expectedFuture = new Future();
        expectedFuture.setContractName(contractName);
        Optional<Future> optionalFuture = Optional.of(expectedFuture);
        when(futureRepository.findByContractName(contractName)).thenReturn(optionalFuture);

        FutureDto actualFutureDto = futureService.findByContractName(contractName);

        assertEquals(expectedFuture.getContractName(), actualFutureDto.getContractName());
    }

    @Test
    public void testFindByContractName_NonExistingName() {
        String contractName = "NonExistingFuture";
        Optional<Future> optionalFuture = Optional.empty();
        when(futureRepository.findByContractName(contractName)).thenReturn(optionalFuture);

        FutureDto actualFutureDto = futureService.findByContractName(contractName);

        assertEquals(null, actualFutureDto);
    }

}