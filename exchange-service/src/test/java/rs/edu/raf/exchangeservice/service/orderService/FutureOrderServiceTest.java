package rs.edu.raf.exchangeservice.service.orderService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import rs.edu.raf.exchangeservice.domain.dto.BuyFutureDto;
import rs.edu.raf.exchangeservice.domain.model.order.FutureOrder;
import rs.edu.raf.exchangeservice.repository.listingRepository.FutureRepository;
import rs.edu.raf.exchangeservice.repository.orderRepository.FutureOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FutureOrderServiceTest {

    @Mock
    private FutureOrderRepository futureOrderRepository;

    @Mock
    private FutureRepository futureRepository;

    @InjectMocks
    private FutureOrderService futureOrderService;

    @Test
    public void testFindAll() {
        List<FutureOrder> expectedOrders = new ArrayList<>();
        when(futureOrderRepository.findAll()).thenReturn(expectedOrders);

        List<FutureOrder> actualOrders = futureOrderService.findAll();

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testFindAllByEmployee() {
        Long employeeId = 1L;
        List<FutureOrder> expectedOrders = new ArrayList<>();
        when(futureOrderRepository.findByEmployeeId(employeeId)).thenReturn(expectedOrders);

        List<FutureOrder> actualOrders = futureOrderService.findAllByEmployee(employeeId);

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testGetAllOrdersToApprove() {
        CopyOnWriteArrayList<FutureOrder> expectedOrders = new CopyOnWriteArrayList<>();
        expectedOrders.add(new FutureOrder());
        futureOrderService.ordersToApprove = expectedOrders;

        List<FutureOrder> actualOrders = futureOrderService.getAllOrdersToApprove();

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testApproveFutureOrder() {
        Long orderId = 1L;
        FutureOrder expectedOrder = new FutureOrder();
        when(futureOrderRepository.findByFutureOrderId(orderId)).thenReturn(expectedOrder);
        when(futureOrderRepository.save(expectedOrder)).thenReturn(expectedOrder);

        FutureOrder actualOrder = futureOrderService.approveFutureOrder(orderId);

        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testBuyFuture() {
        BuyFutureDto buyFutureDto = new BuyFutureDto();
        buyFutureDto.setEmployeeId(1L);
        buyFutureDto.setFutureId(1L);
        buyFutureDto.setPrice(100.0);
        FutureOrder expectedOrder = new FutureOrder();
        when(futureOrderRepository.save(any())).thenReturn(expectedOrder);

        String result = futureOrderService.buyFuture(buyFutureDto);

        assertEquals("UBACENO U ORDER", result);
    }

}