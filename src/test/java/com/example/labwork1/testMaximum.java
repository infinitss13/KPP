//package com.example.labwork1;
//
//import com.example.labwork1.customException.CustomException;
//import com.example.labwork1.controller.MaximumController;
//import org.junit.jupiter.api.Test;
//import com.example.labwork1.calculations.Parameters;
//import com.example.labwork1.calculations.Solution;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//public class testMaximum {
//    private final MaximumController maximumController = new MaximumController();
//    @Test
//    void testMaximumResults_1_2_3()throws CustomException{
//        var solution = new Solution(
//                new Parameters(1,2,3));
//        solution.calculateRoot();
//
//        assertThat(solution.getRoot()).isEqualTo(3);
//    }
//    @Test
//    void testMaximumResults_10_minus2_0()throws CustomException{
//        var solution = new Solution(
//                new Parameters(10,-2,0));
//        solution.calculateRoot();
//
//        assertThat(solution.getRoot()).isEqualTo(10);
//    }
//    @Test
//    void testMaximumResult5_minus1()throws CustomException{
//        var solution = new Solution(
//                new Parameters(-5,-1, 0));
//        solution.calculateRoot();
//
//        assertThat(solution.getRoot()).isEqualTo(0);
//    }
//
//}
