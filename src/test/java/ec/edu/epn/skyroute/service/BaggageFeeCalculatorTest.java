package ec.edu.epn.skyroute.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class BaggageFeeCalculatorTest {
    @Mock
    private BaggageFeeCalculator baggageFeeCalculator;

    @InjectMocks
    private BaggageFeeCalculatorTest baggageFeeCalculatorTest;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void testCalculetronOfBaggageFee(){
        //Arrange
        double weight = 25.0;
        double expectedFee = 50.0;
        when(baggageFeeCalculator.calculateFee(weight)).thenReturn(expectedFee);
        //Act
        double actualfee = baggageFeeCalculator.calculateFee(weight);
        //Assert
        assertEquals( expectedFee, actualfee, 0.0001);

    }

    //Beneficios Vip
    @Test
    public void testCalculetronOfBaggageFeeWithVip(){
        //Arrange
        double weight = 25.0;
        double expectedFee = 40.0;
        when(baggageFeeCalculator.calculateFee(weight)).thenReturn(expectedFee);
        //Act
        double actualfee = baggageFeeCalculator.calculateFee(weight);
        //Assert
        assertEquals( expectedFee, actualfee, 0.0001);
    }
    //weight no puede ser menor o igual a 0 kg.
    @Test
    public void testCalculetronOfweightDiferentZero(){
        //Arrange
        double weight = -5.0;
        when(baggageFeeCalculator.calculateFee(weight)).thenThrow(IllegalArgumentException.class);
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> baggageFeeCalculator.calculateFee(weight));
    }
    // bagCount debe ser al menos 1.
    @Test
    public void testBagCount (){
        //Arrange
        int bagCount = 0;
        when(baggageFeeCalculator.calculateFee(bagCount)).thenThrow(IllegalArgumentException.class);
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> baggageFeeCalculator.calculateFee(bagCount));
    }
    //passengerId no puede ser null.
    @Test
    public void testpassengerIdNotNull(){
        //Arrange
        Long passengerId = null;
        when(baggageFeeCalculator.calculateFee(passengerId)).thenThrow(IllegalArgumentException.class);
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> baggageFeeCalculator.calculateFee(passengerId));
    }







}
