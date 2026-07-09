package com.delivery.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.payment.dto.PaymentDTO;
import com.delivery.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(
    name = "Payment API",description = "Endpoints for processing and retrieving payment information"
)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Operation(
        summary = "Get all payments",description = "Returns a list of all processed payments."
    )
    @ApiResponse(responseCode = "200", description = "Payments retrieved successfully")
    @GetMapping("/showAll")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Operation(
        summary = "Get payment by ID",description = "Fetches payment details using the payment ID."
    )
    @ApiResponse(responseCode = "200", description = "Payment retrieved successfully")
    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
