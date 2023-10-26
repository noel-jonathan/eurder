//package com.eurder.orders;
//
//import com.eurder.customers.CustomerRepository;
//import com.eurder.items.ItemRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import static com.eurder.TestConstants.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class OrderServiceTest {
//    @Mock
//    OrderRepository orderRepository;
//    @Mock
//    CustomerRepository customerRepository;
//    @Mock
//    ItemRepository itemRepository;
//    @Mock
//    OrderMapper orderMapper;
//    private CreateOrderGroupDto createOrderGroupDto;
//    private CreateOrderDto createOrderDto;
//    private OrderService orderService;
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        orderService = new OrderService(orderRepository, customerRepository, itemRepository, orderMapper);
//        createOrderGroupDto = new CreateOrderGroupDto(ITEM_ID, 3);
//        createOrderDto = new CreateOrderDto(CUSTOMER_ID, createOrderGroupDto);
//
//        when(customerRepository.getCustomer(CUSTOMER_ID)).thenReturn(CUSTOMER);
//    }
//
//    @Test
//    void create() {
//        orderService.create(createOrderDto);
//
//        verify(orderRepository).add(any(Order.class));
//    }
//}