package rs.edu.raf.exchangeservice.service.myListingService;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import rs.edu.raf.exchangeservice.domain.dto.FutureDto;
import rs.edu.raf.exchangeservice.domain.dto.SellFutureDto;
import rs.edu.raf.exchangeservice.domain.model.listing.Future;
import rs.edu.raf.exchangeservice.domain.model.myListing.MyFuture;
import rs.edu.raf.exchangeservice.domain.model.order.FutureOrderSell;
import rs.edu.raf.exchangeservice.repository.listingRepository.FutureRepository;
import rs.edu.raf.exchangeservice.repository.myListingRepository.MyFutureRepository;
import rs.edu.raf.exchangeservice.repository.orderRepository.FutureOrderSellRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest

class MyFutureServiceTest {

    @Mock
    private MyFutureRepository myFutureRepository;

    @Mock
    private FutureOrderSellRepository futureOrderSellRepository;

    @Mock
    private FutureRepository futureRepository;

    @InjectMocks
    private MyFutureService myFutureService;

    @Test
    public void testGetAll() {
        List<MyFuture> expectedMyFutures = new ArrayList<>();
        when(myFutureRepository.findAll()).thenReturn(expectedMyFutures);

        List<MyFuture> actualMyFutures = myFutureService.getAll();

        assertEquals(expectedMyFutures, actualMyFutures);
    }

    @Test
    public void testSellFuture() {
        SellFutureDto sellFutureDto = new SellFutureDto();
        sellFutureDto.setEmployeeId(1L);
        sellFutureDto.setFutureId(1L);
        sellFutureDto.setPrice(100.0);
        when(futureOrderSellRepository.save(any())).thenReturn(new FutureOrderSell());

        String result = myFutureService.sellFuture(sellFutureDto);

        assertEquals("UBACENO U ORDER", result);
    }

}